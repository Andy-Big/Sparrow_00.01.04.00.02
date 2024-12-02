package com.rigol.scope.views;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.exifinterface.media.ExifInterface;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.databinding.FormatTransformKeyBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.util.ToastUtils;

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

    /* JADX DEBUG: Multi-variable search result rejected for r3v510, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v511, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v512, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v513, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v514, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v515, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v516, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v517, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v518, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v519, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v520, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v521, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v522, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v523, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v524, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v525, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v526, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v527, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v528, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v529, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v530, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v531, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v532, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v533, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v534, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v535, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v536, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v537, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v693, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v694, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v695, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v696, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v697, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v698, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v699, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v701, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v703, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v704, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v705, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v706, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v707, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r3v708, resolved type: boolean */
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
    */
    public void onClick(View view) {
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        int i6;
        String binaryString;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        String binaryString2;
        String binaryString3;
        String str2;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        this.format = this.param.getFormat();
        int id = view.getId();
        if (id == R.id.key_right) {
            int i22 = 0;
            if (this.context instanceof Activity) {
                int i23 = this.format;
                if (i23 == 0) {
                    int i24 = this.formatIndex + 1;
                    this.formatIndex = i24;
                    int i25 = this.binLengthMax;
                    if (i24 > i25) {
                        this.formatIndex = i25;
                    }
                    String obj = this.binding.typeFormatValue.getText().toString();
                    if (this.formatIndex < obj.length() && obj.charAt(this.formatIndex) == ' ') {
                        this.formatIndex++;
                    }
                } else if (i23 == 1) {
                    int i26 = this.formatIndex + 1;
                    this.formatIndex = i26;
                    int i27 = this.hexLengthMax;
                    if (i26 > i27) {
                        this.formatIndex = i27;
                    }
                    String obj2 = this.binding.typeFormatValue.getText().toString();
                    if (this.formatIndex < obj2.length() && obj2.charAt(this.formatIndex) == ' ') {
                        this.formatIndex++;
                    }
                }
                int length = this.binding.typeFormatValue.getText().length();
                this.formatIndexMax = length;
                if (this.formatIndex >= length) {
                    i = 1;
                    this.formatIndex = length - 1;
                } else {
                    i = 1;
                }
                Editable text = this.binding.typeFormatValue.getText();
                int length2 = text.length();
                this.formatIndexMax = length2;
                if (this.formatIndex >= length2) {
                    this.formatIndex = length2 - i;
                }
                EditText editText = this.binding.typeFormatValue;
                int i28 = this.formatIndex;
                editText.setSelection(i28, i28 + 1);
                this.binding.keyA.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyB.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyC.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyD.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyE.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyF.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyTwo.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 2));
                this.binding.keyThree.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 2));
                this.binding.keyFour.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                this.binding.keyFive.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                this.binding.keySix.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                this.binding.keySeven.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                this.binding.keyEigth.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyNine.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                    if (this.format == 0) {
                        TriggerParam triggerParam = this.param;
                        int i29 = this.formatIndex;
                        triggerParam.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, i29 - (i29 / 9));
                    } else {
                        TriggerParam triggerParam2 = this.param;
                        triggerParam2.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, (this.formatIndex + (triggerParam2.getByteLength() * 8)) - (this.formatIndex / 3));
                    }
                }
                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                    if (this.format == 0) {
                        int i30 = this.formatIndex;
                        if (this.param.getDataBits() <= 8 || this.param.getDataBits() > 16) {
                            if (this.param.getDataBits() > 16 && this.param.getDataBits() <= 24) {
                                if (this.formatIndex <= this.param.getDataBits() % 8 || this.formatIndex >= (this.param.getDataBits() % 8) + 9) {
                                }
                                i30--;
                                this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i30);
                            } else {
                                if (this.param.getDataBits() > 24) {
                                    if (this.formatIndex <= this.param.getDataBits() % 8 || this.formatIndex >= (this.param.getDataBits() % 8) + 9) {
                                        if (this.formatIndex <= (this.param.getDataBits() % 8) + 9 || this.formatIndex >= (this.param.getDataBits() % 8) + 18) {
                                            if (this.formatIndex > (this.param.getDataBits() % 8) + 18) {
                                                i30 -= 3;
                                            }
                                        }
                                        i30 -= 2;
                                    }
                                    i30--;
                                }
                                this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i30);
                            }
                        }
                    } else {
                        String obj3 = text.toString();
                        for (int i31 = 0; i31 < this.formatIndex; i31++) {
                            if (obj3.charAt(i31) != ' ') {
                                i22++;
                            }
                        }
                        TriggerParam triggerParam3 = this.param;
                        triggerParam3.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i22 + triggerParam3.getDataBits());
                    }
                }
                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                    if (this.format == 0) {
                        if (this.param.getCanDataIdType() == 0) {
                            TriggerParam triggerParam4 = this.param;
                            int i32 = this.formatIndex;
                            triggerParam4.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i32 - (i32 / 9));
                        } else {
                            int i33 = this.formatIndex;
                            if (this.param.getIdExtended()) {
                                int i34 = this.formatIndex;
                                if (i34 < 6 || i34 > 13) {
                                    int i35 = this.formatIndex;
                                    if (i35 < 15 || i35 > 22) {
                                        int i36 = this.formatIndex;
                                        if (i36 >= 24 && i36 <= 31) {
                                            i33 -= 3;
                                        }
                                    } else {
                                        i33 -= 2;
                                    }
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i33);
                                }
                                i33--;
                                this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i33);
                            } else {
                                int i37 = this.formatIndex;
                                if (i37 >= 4) {
                                }
                                this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i33);
                            }
                        }
                    } else if (this.param.getCanDataIdType() == 0) {
                        TriggerParam triggerParam5 = this.param;
                        triggerParam5.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, (this.formatIndex + (triggerParam5.getDataByte() * 8)) - (this.formatIndex / 3));
                    } else if (this.param.getIdExtended()) {
                        TriggerParam triggerParam6 = this.param;
                        triggerParam6.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, (this.formatIndex + triggerParam6.getCanIdBits()) - (this.formatIndex / 3));
                    } else {
                        TriggerParam triggerParam7 = this.param;
                        triggerParam7.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, (this.formatIndex + triggerParam7.getCanIdBits()) - (this.formatIndex / 2));
                    }
                }
                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                    if (this.format == 0) {
                        TriggerParam triggerParam8 = this.param;
                        int i38 = this.formatIndex;
                        triggerParam8.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, i38 - (i38 / 9));
                    } else {
                        TriggerParam triggerParam9 = this.param;
                        triggerParam9.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, (this.formatIndex + (triggerParam9.getLinByte() * 8)) - (this.formatIndex / 3));
                    }
                }
                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                    if (this.format == 0) {
                        int i39 = this.formatIndex;
                        if (this.param.getWidth() <= 8 || this.param.getWidth() > 16) {
                            if (this.param.getWidth() > 16 && this.param.getWidth() <= 24) {
                                if (this.formatIndex <= this.param.getWidth() % 8 || this.formatIndex >= (this.param.getWidth() % 8) + 9) {
                                }
                                i39--;
                                if (this.param.getI2sDataType() != 0) {
                                }
                            } else {
                                if (this.param.getWidth() > 24) {
                                    if (this.formatIndex <= this.param.getWidth() % 8 || this.formatIndex >= (this.param.getWidth() % 8) + 9) {
                                        if (this.formatIndex <= (this.param.getWidth() % 8) + 9 || this.formatIndex >= (this.param.getWidth() % 8) + 18) {
                                            if (this.formatIndex > (this.param.getWidth() % 8) + 18) {
                                                i39 -= 3;
                                            }
                                        }
                                        i39 -= 2;
                                    }
                                    i39--;
                                }
                                if (this.param.getI2sDataType() != 0) {
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, i39);
                                } else if (this.param.getI2sDataType() == 1) {
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, i39);
                                } else if (this.param.getI2sDataType() == 2) {
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, i39);
                                }
                            }
                        }
                    } else if (this.param.getI2sDataType() == 0) {
                        TriggerParam triggerParam10 = this.param;
                        triggerParam10.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, (this.formatIndex + triggerParam10.getWidth()) - (this.formatIndex / 2));
                    } else if (this.param.getI2sDataType() == 1) {
                        TriggerParam triggerParam11 = this.param;
                        triggerParam11.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, (this.formatIndex + triggerParam11.getWidth()) - (this.formatIndex / 2));
                    } else if (this.param.getI2sDataType() == 2) {
                        TriggerParam triggerParam12 = this.param;
                        triggerParam12.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, (this.formatIndex + triggerParam12.getWidth()) - (this.formatIndex / 2));
                    }
                }
                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                    if (this.format == 0) {
                        if (this.param.getMilstdDataType() == 0) {
                            TriggerParam triggerParam13 = this.param;
                            int i40 = this.formatIndex;
                            triggerParam13.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, i40 - (i40 / 9));
                        } else if (this.param.getMilstdDataType() == 1) {
                            TriggerParam triggerParam14 = this.param;
                            int i41 = this.formatIndex;
                            triggerParam14.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, i41 - (i41 / 9));
                        } else if (this.param.getMilstdDataType() == 2) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, this.formatIndex);
                        } else if (this.param.getMilstdDataType() == 3) {
                            int i42 = this.formatIndex;
                            if (i42 > 3) {
                                i42--;
                            }
                            this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, i42);
                        }
                    } else if (this.param.getMilstdDataType() == 0) {
                        TriggerParam triggerParam15 = this.param;
                        int i43 = this.formatIndex;
                        triggerParam15.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, (i43 + 16) - (i43 / 3));
                    } else if (this.param.getMilstdDataType() == 1) {
                        TriggerParam triggerParam16 = this.param;
                        int i44 = this.formatIndex;
                        triggerParam16.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, (i44 + 16) - (i44 / 3));
                    } else if (this.param.getMilstdDataType() == 2) {
                        this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, this.formatIndex + 5);
                    } else if (this.param.getMilstdDataType() == 3) {
                        TriggerParam triggerParam17 = this.param;
                        int i45 = this.formatIndex;
                        triggerParam17.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, (i45 + 11) - (i45 / 2));
                    }
                }
            }
        } else if (id == R.id.type_format_value) {
            int i46 = 0;
            if (this.context instanceof Activity) {
                this.formatIndex = this.binding.typeFormatValue.getSelectionStart();
                Editable text2 = this.binding.typeFormatValue.getText();
                int length3 = text2.length();
                this.formatIndexMax = length3;
                if (this.formatIndex >= length3) {
                    i2 = 1;
                    this.formatIndex = length3 - 1;
                } else {
                    i2 = 1;
                }
                if (text2.toString().charAt(this.formatIndex) == ' ') {
                    this.formatIndex += i2;
                }
                EditText editText2 = this.binding.typeFormatValue;
                int i47 = this.formatIndex;
                editText2.setSelection(i47, i47 + 1);
                this.binding.keyA.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyB.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyC.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyD.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyE.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyF.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyTwo.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 2));
                this.binding.keyThree.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 2));
                this.binding.keyFour.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                this.binding.keyFive.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                this.binding.keySix.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                this.binding.keySeven.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                this.binding.keyEigth.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                this.binding.keyNine.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                if (this.format == 0) {
                    if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                        TriggerParam triggerParam18 = this.param;
                        int i48 = this.formatIndex;
                        triggerParam18.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, i48 - (i48 / 9));
                    } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                        int i49 = this.formatIndex;
                        if (this.param.getDataBits() <= 8 || this.param.getDataBits() > 16) {
                            if (this.param.getDataBits() > 16 && this.param.getDataBits() <= 24) {
                                if (this.formatIndex <= this.param.getDataBits() % 8 || this.formatIndex >= (this.param.getDataBits() % 8) + 9) {
                                }
                                i49--;
                                this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i49);
                            } else {
                                if (this.param.getDataBits() > 24) {
                                    if (this.formatIndex <= this.param.getDataBits() % 8 || this.formatIndex >= (this.param.getDataBits() % 8) + 9) {
                                        if (this.formatIndex <= (this.param.getDataBits() % 8) + 9 || this.formatIndex >= (this.param.getDataBits() % 8) + 18) {
                                            if (this.formatIndex > (this.param.getDataBits() % 8) + 18) {
                                                i49 -= 3;
                                            }
                                        }
                                        i49 -= 2;
                                    }
                                    i49--;
                                }
                                this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i49);
                            }
                        }
                    } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                        if (this.param.getCanDataIdType() == 0) {
                            TriggerParam triggerParam19 = this.param;
                            int i50 = this.formatIndex;
                            triggerParam19.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i50 - (i50 / 9));
                        } else {
                            int i51 = this.formatIndex;
                            if (this.param.getIdExtended()) {
                                int i52 = this.formatIndex;
                                if (i52 < 6 || i52 > 13) {
                                    int i53 = this.formatIndex;
                                    if (i53 < 15 || i53 > 22) {
                                        int i54 = this.formatIndex;
                                        if (i54 >= 24 && i54 <= 31) {
                                            i51 -= 3;
                                        }
                                    } else {
                                        i51 -= 2;
                                    }
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i51);
                                }
                                i51--;
                                this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i51);
                            } else {
                                int i55 = this.formatIndex;
                                if (i55 >= 4) {
                                }
                                this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i51);
                            }
                        }
                    } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                        TriggerParam triggerParam20 = this.param;
                        int i56 = this.formatIndex;
                        triggerParam20.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, i56 - (i56 / 9));
                    } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                        int i57 = this.formatIndex;
                        if (this.param.getWidth() <= 8 || this.param.getWidth() > 16) {
                            if (this.param.getWidth() > 16 && this.param.getWidth() <= 24) {
                                if (this.formatIndex <= this.param.getWidth() % 8 || this.formatIndex >= (this.param.getWidth() % 8) + 9) {
                                }
                                i57--;
                                if (this.param.getI2sDataType() != 0) {
                                }
                            } else {
                                if (this.param.getWidth() > 24) {
                                    if (this.formatIndex <= this.param.getWidth() % 8 || this.formatIndex >= (this.param.getWidth() % 8) + 9) {
                                        if (this.formatIndex <= (this.param.getWidth() % 8) + 9 || this.formatIndex >= (this.param.getWidth() % 8) + 18) {
                                            if (this.formatIndex > (this.param.getWidth() % 8) + 18) {
                                                i57 -= 3;
                                            }
                                        }
                                        i57 -= 2;
                                    }
                                    i57--;
                                }
                                if (this.param.getI2sDataType() != 0) {
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, i57);
                                } else if (this.param.getI2sDataType() == 1) {
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, i57);
                                } else if (this.param.getI2sDataType() == 2) {
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, i57);
                                }
                            }
                        }
                    } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                        if (this.param.getMilstdDataType() == 0) {
                            TriggerParam triggerParam21 = this.param;
                            int i58 = this.formatIndex;
                            triggerParam21.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, i58 - (i58 / 9));
                        } else if (this.param.getMilstdDataType() == 1) {
                            TriggerParam triggerParam22 = this.param;
                            int i59 = this.formatIndex;
                            triggerParam22.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, i59 - (i59 / 9));
                        } else if (this.param.getMilstdDataType() == 2) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, this.formatIndex);
                        } else if (this.param.getMilstdDataType() == 3) {
                            int i60 = this.formatIndex;
                            if (i60 > 3) {
                                i60--;
                            }
                            this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, i60);
                        }
                    }
                } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                    TriggerParam triggerParam23 = this.param;
                    triggerParam23.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, (this.formatIndex + (triggerParam23.getByteLength() * 8)) - (this.formatIndex / 3));
                } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                    String obj4 = text2.toString();
                    for (int i61 = 0; i61 < this.formatIndex; i61++) {
                        if (obj4.charAt(i61) != ' ') {
                            i46++;
                        }
                    }
                    TriggerParam triggerParam24 = this.param;
                    triggerParam24.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i46 + triggerParam24.getDataBits());
                } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                    if (this.param.getCanDataIdType() == 0) {
                        TriggerParam triggerParam25 = this.param;
                        triggerParam25.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, (this.formatIndex + (triggerParam25.getDataByte() * 8)) - (this.formatIndex / 3));
                    } else {
                        TriggerParam triggerParam26 = this.param;
                        triggerParam26.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, (this.formatIndex + triggerParam26.getCanIdBits()) - (this.formatIndex / 3));
                    }
                } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                    TriggerParam triggerParam27 = this.param;
                    triggerParam27.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, (this.formatIndex + (triggerParam27.getLinByte() * 8)) - (this.formatIndex / 3));
                } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                    if (this.param.getI2sDataType() == 0) {
                        TriggerParam triggerParam28 = this.param;
                        triggerParam28.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, (this.formatIndex + triggerParam28.getWidth()) - (this.formatIndex / 2));
                    } else if (this.param.getI2sDataType() == 1) {
                        TriggerParam triggerParam29 = this.param;
                        triggerParam29.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, (this.formatIndex + triggerParam29.getWidth()) - (this.formatIndex / 2));
                    } else if (this.param.getI2sDataType() == 2) {
                        TriggerParam triggerParam30 = this.param;
                        triggerParam30.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, (this.formatIndex + triggerParam30.getWidth()) - (this.formatIndex / 2));
                    }
                } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                    if (this.param.getMilstdDataType() == 0) {
                        TriggerParam triggerParam31 = this.param;
                        int i62 = this.formatIndex;
                        triggerParam31.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, (i62 + 16) - (i62 / 3));
                    } else if (this.param.getMilstdDataType() == 1) {
                        TriggerParam triggerParam32 = this.param;
                        int i63 = this.formatIndex;
                        triggerParam32.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, (i63 + 16) - (i63 / 3));
                    } else if (this.param.getMilstdDataType() == 2) {
                        this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, this.formatIndex + 5);
                    } else if (this.param.getMilstdDataType() == 3) {
                        TriggerParam triggerParam33 = this.param;
                        int i64 = this.formatIndex;
                        triggerParam33.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, (i64 + 11) - (i64 / 2));
                    }
                }
            }
        } else {
            str = "XXXX";
            switch (id) {
                case R.id.key_a /* 2131363212 */:
                case R.id.key_b /* 2131363214 */:
                case R.id.key_c /* 2131363215 */:
                case R.id.key_d /* 2131363217 */:
                case R.id.key_e /* 2131363219 */:
                case R.id.key_eigth /* 2131363220 */:
                case R.id.key_f /* 2131363221 */:
                    switch (view.getId()) {
                        case R.id.key_a /* 2131363212 */:
                            this.strKey = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                            break;
                        case R.id.key_b /* 2131363214 */:
                            this.strKey = "B";
                            break;
                        case R.id.key_c /* 2131363215 */:
                            this.strKey = "C";
                            break;
                        case R.id.key_d /* 2131363217 */:
                            this.strKey = "D";
                            break;
                        case R.id.key_e /* 2131363219 */:
                            this.strKey = ExifInterface.LONGITUDE_EAST;
                            break;
                        case R.id.key_eigth /* 2131363220 */:
                            this.strKey = "8";
                            break;
                        case R.id.key_f /* 2131363221 */:
                            this.strKey = "F";
                            break;
                        case R.id.key_five /* 2131363223 */:
                            this.strKey = "5";
                            break;
                        case R.id.key_four /* 2131363224 */:
                            this.strKey = "4";
                            break;
                        case R.id.key_nine /* 2131363227 */:
                            this.strKey = "9";
                            break;
                        case R.id.key_one /* 2131363229 */:
                            this.strKey = "1";
                            break;
                        case R.id.key_seven /* 2131363233 */:
                            this.strKey = "7";
                            break;
                        case R.id.key_six /* 2131363234 */:
                            this.strKey = "6";
                            break;
                        case R.id.key_three /* 2131363235 */:
                            this.strKey = ExifInterface.GPS_MEASUREMENT_3D;
                            break;
                        case R.id.key_two /* 2131363236 */:
                            this.strKey = ExifInterface.GPS_MEASUREMENT_2D;
                            break;
                        case R.id.key_x /* 2131363237 */:
                            this.strKey = "X";
                            break;
                        case R.id.key_zero /* 2131363238 */:
                            this.strKey = "0";
                            break;
                    }
                    if (this.context instanceof Activity) {
                        Editable text3 = this.binding.typeFormatValue.getText();
                        int length4 = text3.length();
                        this.formatIndexMax = length4;
                        int i65 = this.format;
                        if (i65 == 0) {
                            i3 = 0;
                            int i66 = this.formatIndex;
                            if (i66 >= this.binLengthMax) {
                                ToastUtils.showShort((int) R.string.msg_input_invalid);
                            } else if (i66 < length4) {
                                text3.replace(i66, i66 + 1, this.strKey);
                            }
                            int i67 = this.formatIndex + 1;
                            this.formatIndex = i67;
                            if (i67 < text3.length() && text3.charAt(this.formatIndex) == ' ') {
                                this.formatIndex++;
                            }
                            int i68 = this.formatIndex;
                            int i69 = this.binLengthMax;
                            if (i68 >= i69) {
                                this.formatIndex = i69 - 1;
                            }
                            int length5 = text3.length();
                            this.formatIndexMax = length5;
                            if (this.formatIndex >= length5) {
                                this.formatIndex = length5 - 1;
                            }
                            EditText editText3 = this.binding.typeFormatValue;
                            int i70 = this.formatIndex;
                            editText3.setSelection(i70, i70 + 1);
                        } else if (i65 != 1) {
                            i3 = 0;
                        } else {
                            int i71 = this.formatIndex;
                            if (i71 >= this.hexLengthMax) {
                                ToastUtils.showShort((int) R.string.msg_input_invalid);
                            } else if (i71 < length4) {
                                text3.replace(i71, i71 + 1, this.strKey);
                            }
                            StringBuffer stringBuffer = new StringBuffer(this.binding.binaryValue.getText().toString());
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C || this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN || ((this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN && (this.param.getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data || (this.param.getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data_id && !this.param.getCanDefine()))) || (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553 && this.param.getTrigger_1553_When() == ServiceEnum.Trigger_1553_When.trig_1553_data))) {
                                if (this.strKey.equals("X")) {
                                    binaryString = "XXXX";
                                } else {
                                    binaryString = Integer.toBinaryString(Integer.parseInt(this.strKey, 16));
                                    int length6 = binaryString.length();
                                    if (length6 < 4) {
                                        for (int i72 = 0; i72 < 4 - length6; i72++) {
                                            binaryString = "0" + binaryString;
                                        }
                                    }
                                }
                                int i73 = this.formatIndex;
                                if (i73 % 3 == 0) {
                                    stringBuffer.replace(i73 * 3, (i73 * 3) + 4, binaryString);
                                } else {
                                    stringBuffer.replace((i73 * 3) + 1, (i73 * 3) + 4 + 1, binaryString);
                                }
                                this.binding.binaryValue.setText(stringBuffer.toString());
                            } else {
                                binaryString = "";
                            }
                            int dataBits = this.param.getDataBits();
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                                dataBits = this.param.getWidth();
                            }
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S || this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                                int i74 = dataBits % 8;
                                if (i74 == 0) {
                                    if (this.strKey.equals("X")) {
                                        binaryString = "XXXX";
                                    } else {
                                        binaryString = Integer.toBinaryString(Integer.parseInt(this.strKey, 16));
                                        int length7 = binaryString.length();
                                        if (length7 < 4) {
                                            for (int i75 = 0; i75 < 4 - length7; i75++) {
                                                binaryString = "0" + binaryString;
                                            }
                                        }
                                    }
                                    int i76 = this.formatIndex;
                                    if (i76 % 3 == 0) {
                                        stringBuffer.replace(i76 * 3, (i76 * 3) + 4, binaryString);
                                    } else {
                                        stringBuffer.replace((i76 * 3) + 1, (i76 * 3) + 4 + 1, binaryString);
                                    }
                                }
                                int i77 = dataBits % 4;
                                if (i77 == 0 && i74 != 0) {
                                    if (this.strKey.equals("X")) {
                                        binaryString = "XXXX";
                                    } else {
                                        binaryString = Integer.toBinaryString(Integer.parseInt(this.strKey, 16));
                                        int length8 = binaryString.length();
                                        if (length8 < 4) {
                                            for (int i78 = 0; i78 < 4 - length8; i78++) {
                                                binaryString = "0" + binaryString;
                                            }
                                        } else {
                                            i7 = 4;
                                            if (dataBits == i7) {
                                                stringBuffer.replace(0, i7, binaryString);
                                            }
                                            if (dataBits == 12) {
                                                int i79 = this.formatIndex;
                                                if (i79 == 0) {
                                                    stringBuffer.replace(0, i7, binaryString);
                                                } else if (i79 == 1) {
                                                    stringBuffer.replace(5, 9, binaryString);
                                                } else {
                                                    i8 = 2;
                                                    if (i79 == 2) {
                                                        stringBuffer.replace(9, 13, binaryString);
                                                    }
                                                    if (dataBits == 20) {
                                                        int i80 = this.formatIndex;
                                                        if (i80 == 0) {
                                                            stringBuffer.replace(0, 4, binaryString);
                                                        } else if (i80 == i8) {
                                                            stringBuffer.replace(5, 9, binaryString);
                                                        } else if (i80 == 3) {
                                                            stringBuffer.replace(9, 13, binaryString);
                                                        } else if (i80 == 5) {
                                                            stringBuffer.replace(14, 18, binaryString);
                                                        } else if (i80 == 6) {
                                                            stringBuffer.replace(18, 22, binaryString);
                                                        }
                                                    }
                                                    if (dataBits == 28) {
                                                        int i81 = this.formatIndex;
                                                        if (i81 == 0) {
                                                            stringBuffer.replace(0, 4, binaryString);
                                                        } else if (i81 == 2) {
                                                            stringBuffer.replace(5, 9, binaryString);
                                                        } else if (i81 == 3) {
                                                            stringBuffer.replace(9, 13, binaryString);
                                                        } else if (i81 == 5) {
                                                            stringBuffer.replace(14, 18, binaryString);
                                                        } else if (i81 == 6) {
                                                            stringBuffer.replace(18, 22, binaryString);
                                                        } else if (i81 == 8) {
                                                            stringBuffer.replace(23, 27, binaryString);
                                                        } else if (i81 == 9) {
                                                            stringBuffer.replace(27, 31, binaryString);
                                                        }
                                                    }
                                                    if (i77 != 0) {
                                                        if (this.strKey.equals("X")) {
                                                            if (this.formatIndex == 0) {
                                                                for (int i82 = 0; i82 < i77; i82++) {
                                                                    binaryString = binaryString + "X";
                                                                }
                                                            } else {
                                                                binaryString = "XXXX";
                                                            }
                                                        } else if (this.formatIndex == 0) {
                                                            binaryString = Integer.toBinaryString(Integer.parseInt(this.strKey, 16));
                                                            int length9 = binaryString.length();
                                                            if (length9 < i77) {
                                                                for (int i83 = 0; i83 < i77 - length9; i83++) {
                                                                    binaryString = "0" + binaryString;
                                                                }
                                                            }
                                                        } else {
                                                            binaryString = Integer.toBinaryString(Integer.parseInt(this.strKey, 16));
                                                            int length10 = binaryString.length();
                                                            if (length10 < 4) {
                                                                for (int i84 = 0; i84 < 4 - length10; i84++) {
                                                                    binaryString = "0" + binaryString;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (dataBits != 5 || dataBits == 6 || dataBits == 7) {
                                                        if (this.formatIndex == 0) {
                                                            stringBuffer.replace(0, i77, binaryString);
                                                        } else {
                                                            stringBuffer.replace(i77, i77 + 4, binaryString);
                                                        }
                                                    }
                                                    if (dataBits != 9 || dataBits == 10 || dataBits == 11) {
                                                        i9 = this.formatIndex;
                                                        if (i9 == 0) {
                                                            stringBuffer.replace(0, i77, binaryString);
                                                        } else if (i9 == 2) {
                                                            stringBuffer.replace(i77 + 1, i77 + 5, binaryString);
                                                        } else if (i9 == 3) {
                                                            stringBuffer.replace(i77 + 5, i77 + 9, binaryString);
                                                        }
                                                    }
                                                    if (dataBits != 13 || dataBits == 14 || dataBits == 15) {
                                                        i10 = this.formatIndex;
                                                        if (i10 == 0) {
                                                            stringBuffer.replace(0, i77, binaryString);
                                                        } else if (i10 == 1) {
                                                            stringBuffer.replace(i77, i77 + 4, binaryString);
                                                        } else if (i10 == 3) {
                                                            stringBuffer.replace(i77 + 5, i77 + 9, binaryString);
                                                        } else if (i10 == 4) {
                                                            stringBuffer.replace(i77 + 9, i77 + 13, binaryString);
                                                        }
                                                    }
                                                    if (dataBits != 17 || dataBits == 18 || dataBits == 19) {
                                                        i11 = this.formatIndex;
                                                        if (i11 == 0) {
                                                            stringBuffer.replace(0, i77, binaryString);
                                                        } else if (i11 == 2) {
                                                            stringBuffer.replace(i77 + 1, i77 + 5, binaryString);
                                                        } else if (i11 == 3) {
                                                            stringBuffer.replace(i77 + 5, i77 + 9, binaryString);
                                                        } else if (i11 == 5) {
                                                            stringBuffer.replace(i77 + 10, i77 + 14, binaryString);
                                                        } else if (i11 == 6) {
                                                            stringBuffer.replace(i77 + 14, i77 + 18, binaryString);
                                                        }
                                                    }
                                                    if (dataBits != 21 || dataBits == 22 || dataBits == 23) {
                                                        i12 = this.formatIndex;
                                                        if (i12 == 0) {
                                                            stringBuffer.replace(0, i77, binaryString);
                                                        } else if (i12 == 1) {
                                                            stringBuffer.replace(i77, i77 + 4, binaryString);
                                                        } else if (i12 == 3) {
                                                            stringBuffer.replace(i77 + 5, i77 + 9, binaryString);
                                                        } else if (i12 == 4) {
                                                            stringBuffer.replace(i77 + 9, i77 + 13, binaryString);
                                                        } else if (i12 == 6) {
                                                            stringBuffer.replace(i77 + 14, i77 + 18, binaryString);
                                                        } else if (i12 == 7) {
                                                            stringBuffer.replace(i77 + 18, i77 + 22, binaryString);
                                                        }
                                                    }
                                                    if (dataBits != 25 || dataBits == 26 || dataBits == 27) {
                                                        i13 = this.formatIndex;
                                                        if (i13 == 0) {
                                                            stringBuffer.replace(0, i77, binaryString);
                                                        } else if (i13 == 2) {
                                                            stringBuffer.replace(i77 + 1, i77 + 5, binaryString);
                                                        } else if (i13 == 3) {
                                                            stringBuffer.replace(i77 + 5, i77 + 9, binaryString);
                                                        } else if (i13 == 5) {
                                                            stringBuffer.replace(i77 + 10, i77 + 14, binaryString);
                                                        } else if (i13 == 6) {
                                                            stringBuffer.replace(i77 + 14, i77 + 18, binaryString);
                                                        } else if (i13 == 8) {
                                                            stringBuffer.replace(i77 + 19, i77 + 23, binaryString);
                                                        } else if (i13 == 9) {
                                                            stringBuffer.replace(i77 + 23, i77 + 27, binaryString);
                                                        }
                                                    }
                                                    if (dataBits != 29 || dataBits == 30 || dataBits == 31) {
                                                        i14 = this.formatIndex;
                                                        if (i14 == 0) {
                                                            stringBuffer.replace(0, i77, binaryString);
                                                        } else if (i14 == 1) {
                                                            stringBuffer.replace(i77, i77 + 4, binaryString);
                                                        } else if (i14 == 3) {
                                                            stringBuffer.replace(i77 + 5, i77 + 9, binaryString);
                                                        } else if (i14 == 4) {
                                                            stringBuffer.replace(i77 + 9, i77 + 13, binaryString);
                                                        } else if (i14 == 6) {
                                                            stringBuffer.replace(i77 + 14, i77 + 18, binaryString);
                                                        } else if (i14 == 7) {
                                                            stringBuffer.replace(i77 + 18, i77 + 22, binaryString);
                                                        } else if (i14 == 9) {
                                                            stringBuffer.replace(i77 + 23, i77 + 27, binaryString);
                                                        } else if (i14 == 10) {
                                                            stringBuffer.replace(i77 + 27, i77 + 31, binaryString);
                                                        }
                                                    }
                                                    this.binding.binaryValue.setText(stringBuffer.toString());
                                                }
                                            }
                                            i8 = 2;
                                            if (dataBits == 20) {
                                            }
                                            if (dataBits == 28) {
                                            }
                                            if (i77 != 0) {
                                            }
                                            if (dataBits != 5) {
                                            }
                                            if (this.formatIndex == 0) {
                                            }
                                            if (dataBits != 9) {
                                            }
                                            i9 = this.formatIndex;
                                            if (i9 == 0) {
                                            }
                                            if (dataBits != 13) {
                                            }
                                            i10 = this.formatIndex;
                                            if (i10 == 0) {
                                            }
                                            if (dataBits != 17) {
                                            }
                                            i11 = this.formatIndex;
                                            if (i11 == 0) {
                                            }
                                            if (dataBits != 21) {
                                            }
                                            i12 = this.formatIndex;
                                            if (i12 == 0) {
                                            }
                                            if (dataBits != 25) {
                                            }
                                            i13 = this.formatIndex;
                                            if (i13 == 0) {
                                            }
                                            if (dataBits != 29) {
                                            }
                                            i14 = this.formatIndex;
                                            if (i14 == 0) {
                                            }
                                            this.binding.binaryValue.setText(stringBuffer.toString());
                                        }
                                    }
                                }
                                i7 = 4;
                                if (dataBits == i7) {
                                }
                                if (dataBits == 12) {
                                }
                                i8 = 2;
                                if (dataBits == 20) {
                                }
                                if (dataBits == 28) {
                                }
                                if (i77 != 0) {
                                }
                                if (dataBits != 5) {
                                }
                                if (this.formatIndex == 0) {
                                }
                                if (dataBits != 9) {
                                }
                                i9 = this.formatIndex;
                                if (i9 == 0) {
                                }
                                if (dataBits != 13) {
                                }
                                i10 = this.formatIndex;
                                if (i10 == 0) {
                                }
                                if (dataBits != 17) {
                                }
                                i11 = this.formatIndex;
                                if (i11 == 0) {
                                }
                                if (dataBits != 21) {
                                }
                                i12 = this.formatIndex;
                                if (i12 == 0) {
                                }
                                if (dataBits != 25) {
                                }
                                i13 = this.formatIndex;
                                if (i13 == 0) {
                                }
                                if (dataBits != 29) {
                                }
                                i14 = this.formatIndex;
                                if (i14 == 0) {
                                }
                                this.binding.binaryValue.setText(stringBuffer.toString());
                            }
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN && (this.param.getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_remote_id || this.param.getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_id || (this.param.getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data_id && this.param.getCanDefine()))) {
                                if (this.param.getIdExtended()) {
                                    if (this.formatIndex == 0) {
                                        stringBuffer.replace(0, 1, this.strKey.equals("X") ? "X" : Integer.toBinaryString(Integer.parseInt(this.strKey, 16)));
                                    } else {
                                        if (this.strKey.equals("X")) {
                                            binaryString3 = "XXXX";
                                        } else {
                                            binaryString3 = Integer.toBinaryString(Integer.parseInt(this.strKey, 16));
                                            int length11 = binaryString3.length();
                                            if (length11 < 4) {
                                                for (int i85 = 0; i85 < 4 - length11; i85++) {
                                                    binaryString3 = "0" + binaryString3;
                                                }
                                            }
                                        }
                                        int i86 = this.formatIndex;
                                        if (i86 == 1) {
                                            stringBuffer.replace(1, 5, binaryString3);
                                        } else if (i86 == 3) {
                                            stringBuffer.replace(6, 10, binaryString3);
                                        } else if (i86 == 4) {
                                            stringBuffer.replace(10, 14, binaryString3);
                                        } else if (i86 == 6) {
                                            stringBuffer.replace(15, 19, binaryString3);
                                        } else if (i86 == 7) {
                                            stringBuffer.replace(19, 23, binaryString3);
                                        } else if (i86 == 9) {
                                            stringBuffer.replace(24, 28, binaryString3);
                                        } else if (i86 == 10) {
                                            stringBuffer.replace(28, 32, binaryString3);
                                        }
                                    }
                                } else if (this.formatIndex == 0) {
                                    String binaryString4 = this.strKey.equals("X") ? "XXX" : Integer.toBinaryString(Integer.parseInt(this.strKey, 16));
                                    int length12 = binaryString4.length();
                                    if (length12 < 3) {
                                        for (int i87 = 0; i87 < 3 - length12; i87++) {
                                            binaryString4 = "0" + binaryString4;
                                        }
                                    }
                                    stringBuffer.replace(0, 3, binaryString4);
                                } else {
                                    String binaryString5 = this.strKey.equals("X") ? "XXXX" : Integer.toBinaryString(Integer.parseInt(this.strKey, 16));
                                    int length13 = binaryString5.length();
                                    if (length13 < 4) {
                                        for (int i88 = 0; i88 < 4 - length13; i88++) {
                                            binaryString5 = "0" + binaryString5;
                                        }
                                    }
                                    int i89 = this.formatIndex;
                                    if (i89 == 2) {
                                        stringBuffer.replace(4, 8, binaryString5);
                                    } else if (i89 == 3) {
                                        stringBuffer.replace(8, 12, binaryString5);
                                    }
                                }
                                this.binding.binaryValue.setText(stringBuffer.toString());
                            }
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553 && (this.param.getTrigger_1553_When() == ServiceEnum.Trigger_1553_When.trig_1553_cmd || (this.param.getTrigger_1553_When() == ServiceEnum.Trigger_1553_When.trig_1553_status && this.param.getMilstdDataType() == 2))) {
                                if (this.strKey.equals("X")) {
                                    binaryString2 = this.formatIndex == 0 ? "X" : "XXXX";
                                } else if (this.formatIndex == 0) {
                                    binaryString2 = this.strKey;
                                } else {
                                    binaryString2 = Integer.toBinaryString(Integer.parseInt(this.strKey, 16));
                                    int length14 = binaryString2.length();
                                    if (length14 < 4) {
                                        for (int i90 = 0; i90 < 4 - length14; i90++) {
                                            binaryString2 = "0" + binaryString2;
                                        }
                                    }
                                }
                                if (this.formatIndex == 0) {
                                    stringBuffer.replace(0, 1, binaryString2);
                                } else {
                                    stringBuffer.replace(1, 5, binaryString2);
                                }
                                this.binding.binaryValue.setText(stringBuffer.toString());
                            }
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553 && this.param.getTrigger_1553_When() == ServiceEnum.Trigger_1553_When.trig_1553_status && this.param.getMilstdDataType() == 3) {
                                if (this.strKey.equals("X")) {
                                    if (this.formatIndex == 0) {
                                        str = "XXX";
                                    }
                                } else {
                                    int i91 = this.formatIndex == 0 ? 3 : 4;
                                    String binaryString6 = Integer.toBinaryString(Integer.parseInt(this.strKey, 16));
                                    int length15 = binaryString6.length();
                                    if (length15 < i91) {
                                        for (int i92 = 0; i92 < i91 - length15; i92++) {
                                            binaryString6 = "0" + binaryString6;
                                        }
                                    }
                                    str = binaryString6;
                                }
                                int i93 = this.formatIndex;
                                if (i93 == 0) {
                                    i3 = 0;
                                    stringBuffer.replace(0, 3, str);
                                } else {
                                    i3 = 0;
                                    if (i93 == 2) {
                                        stringBuffer.replace(4, 8, str);
                                    } else if (i93 == 3) {
                                        stringBuffer.replace(8, 12, str);
                                    }
                                }
                                this.binding.binaryValue.setText(stringBuffer.toString());
                            } else {
                                i3 = 0;
                            }
                            int i94 = this.formatIndex + 1;
                            this.formatIndex = i94;
                            if (i94 < text3.length() && text3.charAt(this.formatIndex) == ' ') {
                                this.formatIndex++;
                            }
                            int i95 = this.formatIndex;
                            int i96 = this.hexLengthMax;
                            if (i95 >= i96) {
                                this.formatIndex = i96 - 1;
                            }
                            int length16 = text3.length();
                            this.formatIndexMax = length16;
                            if (this.formatIndex >= length16) {
                                this.formatIndex = length16 - 1;
                            }
                            EditText editText4 = this.binding.typeFormatValue;
                            int i97 = this.formatIndex;
                            editText4.setSelection(i97, i97 + 1);
                        }
                        this.binding.keyA.setEnabled((this.format == 0 || (this.formatIndex == 0 && this.param.isShow() != 0)) ? i3 : 1);
                        this.binding.keyB.setEnabled((this.format == 0 || (this.formatIndex == 0 && this.param.isShow() != 0)) ? i3 : 1);
                        this.binding.keyC.setEnabled((this.format == 0 || (this.formatIndex == 0 && this.param.isShow() != 0)) ? i3 : 1);
                        this.binding.keyD.setEnabled((this.format == 0 || (this.formatIndex == 0 && this.param.isShow() != 0)) ? i3 : 1);
                        this.binding.keyE.setEnabled((this.format == 0 || (this.formatIndex == 0 && this.param.isShow() != 0)) ? i3 : 1);
                        this.binding.keyF.setEnabled((this.format == 0 || (this.formatIndex == 0 && this.param.isShow() != 0)) ? i3 : 1);
                        this.binding.keyTwo.setEnabled((this.format == 0 || (this.param.isShow() != 0 && this.formatIndex == 0 && this.param.isShow() < 2)) ? i3 : 1);
                        this.binding.keyThree.setEnabled((this.format == 0 || (this.param.isShow() != 0 && this.formatIndex == 0 && this.param.isShow() < 2)) ? i3 : 1);
                        this.binding.keyFour.setEnabled((this.format == 0 || (this.param.isShow() != 0 && this.formatIndex == 0 && this.param.isShow() < 3)) ? i3 : 1);
                        this.binding.keyFive.setEnabled((this.format == 0 || (this.param.isShow() != 0 && this.formatIndex == 0 && this.param.isShow() < 3)) ? i3 : 1);
                        this.binding.keySix.setEnabled((this.format == 0 || (this.param.isShow() != 0 && this.formatIndex == 0 && this.param.isShow() < 3)) ? i3 : 1);
                        this.binding.keySeven.setEnabled((this.format == 0 || (this.param.isShow() != 0 && this.formatIndex == 0 && this.param.isShow() < 3)) ? i3 : 1);
                        this.binding.keyEigth.setEnabled((this.format == 0 || (this.formatIndex == 0 && this.param.isShow() != 0)) ? i3 : 1);
                        this.binding.keyNine.setEnabled((this.format == 0 || (this.formatIndex == 0 && this.param.isShow() != 0)) ? i3 : 1);
                        Editable text4 = this.binding.typeFormatValue.getText();
                        String replace = text4.toString().replace("-", "X");
                        int i98 = this.format;
                        if (i98 == 0) {
                            replace = "[bin]" + replace;
                        } else if (i98 == 1) {
                            replace = "[hex]" + replace;
                        }
                        this.formatTransformInterface.FormatTransformListener(replace);
                        if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                            if (this.strKey.equals("X")) {
                                i6 = 41;
                                this.param.postWay(41, MessageID.MSG_TRIGGER_I2C_CODE, 255);
                            } else {
                                i6 = 41;
                                this.param.postWay(41, MessageID.MSG_TRIGGER_I2C_CODE, Integer.parseInt(this.strKey, 16));
                            }
                            if (this.format == 0) {
                                TriggerParam triggerParam34 = this.param;
                                int i99 = this.formatIndex;
                                triggerParam34.postWay(i6, MessageID.MSG_TRIGGER_I2C_CURRBIT, i99 - (i99 / 9));
                                break;
                            } else {
                                TriggerParam triggerParam35 = this.param;
                                triggerParam35.postWay(i6, MessageID.MSG_TRIGGER_I2C_CURRBIT, (this.formatIndex + (triggerParam35.getByteLength() * 8)) - (this.formatIndex / 3));
                                break;
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                            if (this.strKey.equals("X")) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CODE, 255);
                                i5 = 16;
                            } else {
                                i5 = 16;
                                this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CODE, Integer.parseInt(this.strKey, 16));
                            }
                            if (this.format == 0) {
                                int i100 = this.formatIndex;
                                if (this.param.getDataBits() <= 8 || this.param.getDataBits() > i5) {
                                    if (this.param.getDataBits() > 16 && this.param.getDataBits() <= 24) {
                                        if (this.formatIndex <= this.param.getDataBits() % 8 || this.formatIndex >= (this.param.getDataBits() % 8) + 9) {
                                            break;
                                        }
                                        i100--;
                                        this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i100);
                                    } else {
                                        if (this.param.getDataBits() > 24) {
                                            if (this.formatIndex <= this.param.getDataBits() % 8 || this.formatIndex >= (this.param.getDataBits() % 8) + 9) {
                                                if (this.formatIndex <= (this.param.getDataBits() % 8) + 9 || this.formatIndex >= (this.param.getDataBits() % 8) + 18) {
                                                    if (this.formatIndex > (this.param.getDataBits() % 8) + 18) {
                                                        i100 -= 3;
                                                    }
                                                }
                                                i100 -= 2;
                                            }
                                            i100--;
                                        }
                                        this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i100);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                String obj5 = text4.toString();
                                for (int i101 = i3; i101 < this.formatIndex; i101++) {
                                    if (obj5.charAt(i101) != ' ') {
                                        i3++;
                                    }
                                }
                                TriggerParam triggerParam36 = this.param;
                                triggerParam36.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i3 + triggerParam36.getDataBits());
                                break;
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                            if (this.strKey.equals("X")) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CODE, 255);
                            } else {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CODE, Integer.parseInt(this.strKey, 16));
                            }
                            if (this.format == 0) {
                                if (this.param.getCanDataIdType() == 0) {
                                    TriggerParam triggerParam37 = this.param;
                                    int i102 = this.formatIndex;
                                    triggerParam37.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i102 - (i102 / 9));
                                    break;
                                } else {
                                    int i103 = this.formatIndex;
                                    if (this.param.getIdExtended()) {
                                        int i104 = this.formatIndex;
                                        if (i104 < 6 || i104 > 13) {
                                            int i105 = this.formatIndex;
                                            if (i105 < 15 || i105 > 22) {
                                                int i106 = this.formatIndex;
                                                if (i106 >= 24 && i106 <= 31) {
                                                    i103 -= 3;
                                                }
                                            } else {
                                                i103 -= 2;
                                            }
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i103);
                                            break;
                                        }
                                        i103--;
                                        this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i103);
                                    } else {
                                        int i107 = this.formatIndex;
                                        if (i107 >= 4) {
                                            break;
                                        }
                                        this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i103);
                                    }
                                }
                            } else if (this.param.getCanDataIdType() == 0) {
                                TriggerParam triggerParam38 = this.param;
                                triggerParam38.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, (this.formatIndex + (triggerParam38.getDataByte() * 8)) - (this.formatIndex / 3));
                                break;
                            } else {
                                TriggerParam triggerParam39 = this.param;
                                triggerParam39.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, (this.formatIndex + triggerParam39.getCanIdBits()) - ((this.formatIndex + 1) / 3));
                                break;
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                            if (this.strKey.equals("X")) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_LIN_CODE, 255);
                            } else {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_LIN_CODE, Integer.parseInt(this.strKey, 16));
                            }
                            if (this.format == 0) {
                                TriggerParam triggerParam40 = this.param;
                                int i108 = this.formatIndex;
                                triggerParam40.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, i108 - (i108 / 9));
                                break;
                            } else {
                                TriggerParam triggerParam41 = this.param;
                                triggerParam41.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, (this.formatIndex + (triggerParam41.getLinByte() * 8)) - (this.formatIndex / 3));
                                break;
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                            if (this.strKey.equals("X")) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_I2S_CODE, 255);
                                i4 = 16;
                            } else {
                                i4 = 16;
                                this.param.postWay(41, MessageID.MSG_TRIGGER_I2S_CODE, Integer.parseInt(this.strKey, 16));
                            }
                            if (this.format == 0) {
                                int i109 = this.formatIndex;
                                if (this.param.getWidth() <= 8 || this.param.getWidth() > i4) {
                                    if (this.param.getWidth() > 16 && this.param.getWidth() <= 24) {
                                        if (this.formatIndex <= this.param.getWidth() % 8 || this.formatIndex >= (this.param.getWidth() % 8) + 9) {
                                            break;
                                        }
                                        i109--;
                                        if (this.param.getI2sDataType() != 0) {
                                        }
                                    } else {
                                        if (this.param.getWidth() > 24) {
                                            if (this.formatIndex <= this.param.getWidth() % 8 || this.formatIndex >= (this.param.getWidth() % 8) + 9) {
                                                if (this.formatIndex <= (this.param.getWidth() % 8) + 9 || this.formatIndex >= (this.param.getWidth() % 8) + 18) {
                                                    if (this.formatIndex > (this.param.getWidth() % 8) + 18) {
                                                        i109 -= 3;
                                                    }
                                                }
                                                i109 -= 2;
                                            }
                                            i109--;
                                        }
                                        if (this.param.getI2sDataType() != 0) {
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, i109);
                                            break;
                                        } else if (this.param.getI2sDataType() == 1) {
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, i109);
                                            break;
                                        } else if (this.param.getI2sDataType() == 2) {
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, i109);
                                            break;
                                        }
                                    }
                                } else {
                                    break;
                                }
                            } else if (this.param.getI2sDataType() == 0) {
                                TriggerParam triggerParam42 = this.param;
                                triggerParam42.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, (this.formatIndex + triggerParam42.getWidth()) - (this.formatIndex / 2));
                                break;
                            } else if (this.param.getI2sDataType() == 1) {
                                TriggerParam triggerParam43 = this.param;
                                triggerParam43.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, (this.formatIndex + triggerParam43.getWidth()) - (this.formatIndex / 2));
                                break;
                            } else if (this.param.getI2sDataType() == 2) {
                                TriggerParam triggerParam44 = this.param;
                                triggerParam44.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, (this.formatIndex + triggerParam44.getWidth()) - (this.formatIndex / 2));
                                break;
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                            if (this.strKey.equals("X")) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_CODE, 255);
                            } else {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_CODE, Integer.parseInt(this.strKey, 16));
                            }
                            if (this.format == 0) {
                                if (this.param.getMilstdDataType() == 0) {
                                    TriggerParam triggerParam45 = this.param;
                                    int i110 = this.formatIndex;
                                    triggerParam45.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, i110 - (i110 / 9));
                                    break;
                                } else if (this.param.getMilstdDataType() == 1) {
                                    TriggerParam triggerParam46 = this.param;
                                    int i111 = this.formatIndex;
                                    triggerParam46.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, i111 - (i111 / 9));
                                    break;
                                } else if (this.param.getMilstdDataType() == 2) {
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, this.formatIndex);
                                    break;
                                } else if (this.param.getMilstdDataType() == 3) {
                                    int i112 = this.formatIndex;
                                    if (i112 > 3) {
                                        i112--;
                                    }
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, i112);
                                    break;
                                }
                            } else if (this.param.getMilstdDataType() == 0) {
                                TriggerParam triggerParam47 = this.param;
                                int i113 = this.formatIndex;
                                triggerParam47.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, (i113 + 16) - (i113 / 3));
                                break;
                            } else if (this.param.getMilstdDataType() == 1) {
                                TriggerParam triggerParam48 = this.param;
                                int i114 = this.formatIndex;
                                triggerParam48.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, (i114 + 16) - (i114 / 3));
                                break;
                            } else if (this.param.getMilstdDataType() == 2) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, this.formatIndex + 5);
                                break;
                            } else if (this.param.getMilstdDataType() == 3) {
                                TriggerParam triggerParam49 = this.param;
                                int i115 = this.formatIndex;
                                triggerParam49.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, (i115 + 11) - (i115 / 2));
                                break;
                            }
                        }
                    }
                    break;
                case R.id.key_all /* 2131363213 */:
                    if (this.context instanceof Activity) {
                        String obj6 = this.binding.typeFormatValue.getText().toString();
                        this.strKey = obj6.charAt(this.formatIndex) + "";
                        if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                            if (this.strKey.equals("X")) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_I2C_CODE_ALL, 255);
                            } else {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_I2C_CODE_ALL, Integer.parseInt(this.strKey, 16));
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                            if (this.strKey.equals("X")) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CODE_ALL, 255);
                            } else {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CODE_ALL, Integer.parseInt(this.strKey, 16));
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                            if (this.strKey.equals("X")) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CODE_ALL, 255);
                            } else {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_CODE_ALL, Integer.parseInt(this.strKey, 16));
                                this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CODE_ALL, Integer.parseInt(this.strKey, 16));
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                            if (this.strKey.equals("X")) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_LIN_CODE_ALL, 255);
                            } else {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_LIN_CODE_ALL, Integer.parseInt(this.strKey, 16));
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                            if (this.strKey.equals("X")) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_I2S_CODE_ALL, 255);
                            } else {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_I2S_CODE_ALL, Integer.parseInt(this.strKey, 16));
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                            if (this.strKey.equals("X")) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_CODE_ALL, 255);
                            } else {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_CODE_ALL, Integer.parseInt(this.strKey, 16));
                            }
                        }
                        if (this.strKey.equals("X")) {
                            this.binding.binaryValue.setText(this.param.getAllXBinary());
                            if (this.param.getFormat() == 0) {
                                this.binding.typeFormatValue.setText(this.param.getAllXBinary());
                            } else {
                                this.binding.typeFormatValue.setText(this.param.getAllXHex());
                            }
                        } else {
                            try {
                                Thread.sleep(100L);
                            } catch (Exception unused) {
                            }
                            if (this.param.getFormat() == 0) {
                                this.binding.typeFormatValue.setText(this.param.getAllDataBinary());
                            } else {
                                this.binding.typeFormatValue.setText(this.param.getAllDataHex());
                            }
                            this.binding.binaryValue.setText(this.param.getAllDataBinary());
                        }
                        EditText editText5 = this.binding.typeFormatValue;
                        int i116 = this.formatIndex;
                        editText5.setSelection(i116, i116 + 1);
                        this.binding.typeFormatValue.requestFocus();
                        break;
                    }
                    break;
                case R.id.key_clear /* 2131363216 */:
                    if (this.context instanceof Activity) {
                        int i117 = this.format;
                        if (i117 == 0) {
                            String str3 = "";
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                                for (int i118 = 0; i118 < this.param.getByteLength(); i118++) {
                                    str3 = str3 + "XXXXXXXX ";
                                }
                                str3 = str3.trim();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                                for (int i119 = 0; i119 < this.param.getDataBits(); i119++) {
                                    if (i119 % 8 == 0 && i119 != 0) {
                                        str3 = str3 + " ";
                                    }
                                    str3 = str3 + "X";
                                }
                                str3 = new StringBuffer(str3).reverse().toString();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                                if (this.param.getCanDataIdType() == 0) {
                                    for (int i120 = 0; i120 < this.param.getDataByte(); i120++) {
                                        str3 = str3 + "XXXXXXXX ";
                                    }
                                    str3 = str3.trim();
                                } else {
                                    str3 = this.param.getIdExtended() ? "XXXXX XXXXXXXX XXXXXXXX XXXXXXXX" : "XXX XXXXXXXX";
                                }
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                                for (int i121 = 0; i121 < this.param.getLinByte(); i121++) {
                                    str3 = str3 + "XXXXXXX ";
                                }
                                str3 = str3.trim();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                                for (int i122 = 0; i122 < this.param.getWidth(); i122++) {
                                    if (i122 % 8 == 0 && i122 != 0) {
                                        str3 = str3 + " ";
                                    }
                                    str3 = str3 + "X";
                                }
                                str3 = new StringBuffer(str3).reverse().toString();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                                if (this.param.getMilstdDataType() == 0 || this.param.getMilstdDataType() == 1) {
                                    str3 = "XXXXXXXX XXXXXXXX";
                                } else if (this.param.getMilstdDataType() == 2) {
                                    str3 = "XXXXX";
                                } else if (this.param.getMilstdDataType() == 3) {
                                    str3 = "XXX XXXXXXXX";
                                }
                            }
                            this.binding.typeFormatValue.setText(str3);
                        } else if (i117 == 1) {
                            String str4 = "";
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                                for (int i123 = 0; i123 < this.param.getByteLength(); i123++) {
                                    str4 = str4 + "XXXXXXXX ";
                                }
                                str4 = str4.trim();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                                for (int i124 = 0; i124 < this.param.getDataBits(); i124++) {
                                    if (i124 % 8 == 0 && i124 != 0) {
                                        str4 = str4 + " ";
                                    }
                                    str4 = str4 + "X";
                                }
                                str4 = new StringBuffer(str4).reverse().toString();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                                if (this.param.getCanDataIdType() == 0) {
                                    for (int i125 = 0; i125 < this.param.getDataByte(); i125++) {
                                        str4 = str4 + "XXXXXXX ";
                                    }
                                    str4 = str4.trim();
                                } else {
                                    str4 = this.param.getIdExtended() ? "XXXXX XXXXXXXX XXXXXXXX XXXXXXXX" : "XXX XXXXXXXX";
                                }
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                                for (int i126 = 0; i126 < this.param.getLinByte(); i126++) {
                                    str4 = str4 + "XXXXXXX ";
                                }
                                str4 = str4.trim();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                                for (int i127 = 0; i127 < this.param.getWidth(); i127++) {
                                    if (i127 % 8 == 0 && i127 != 0) {
                                        str4 = str4 + " ";
                                    }
                                    str4 = str4 + "X";
                                }
                                str4 = new StringBuffer(str4).reverse().toString();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                                if (this.param.getMilstdDataType() == 0 || this.param.getMilstdDataType() == 1) {
                                    str4 = "XXXXXXXX XXXXXXXX";
                                } else if (this.param.getMilstdDataType() == 2) {
                                    str4 = "XXXXX";
                                } else if (this.param.getMilstdDataType() == 3) {
                                    str4 = "XXX XXXXXXXX";
                                }
                            }
                            this.binding.binaryValue.setText(str4);
                            String str5 = "";
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                                for (int i128 = 0; i128 < this.param.getByteLength(); i128++) {
                                    str5 = str5 + "XX ";
                                }
                                str5 = str5.trim();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                                int dataBits2 = (this.param.getDataBits() / 4) + (this.param.getDataBits() % 4 != 0 ? 1 : 0);
                                for (int i129 = 0; i129 < dataBits2; i129++) {
                                    if (i129 % 2 == 0 && i129 != 0) {
                                        str5 = str5 + " ";
                                    }
                                    str5 = str5 + "X";
                                }
                                str5 = new StringBuffer(str5).reverse().toString();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                                if (this.param.getCanDataIdType() == 0) {
                                    for (int i130 = 0; i130 < this.param.getDataByte(); i130++) {
                                        str5 = str5 + "XX ";
                                    }
                                    str5 = str5.trim();
                                } else {
                                    str5 = this.param.getIdExtended() ? "XX XX XX XX" : "X XX";
                                }
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                                for (int i131 = 0; i131 < this.param.getLinByte(); i131++) {
                                    str5 = str5 + "XX ";
                                }
                                str5 = str5.trim();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                                int width = (this.param.getWidth() / 4) + (this.param.getWidth() % 4 != 0 ? 1 : 0);
                                for (int i132 = 0; i132 < width; i132++) {
                                    if (i132 % 2 == 0 && i132 != 0) {
                                        str5 = str5 + " ";
                                    }
                                    str5 = str5 + "X";
                                }
                                str5 = new StringBuffer(str5).reverse().toString();
                            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                                if (this.param.getMilstdDataType() == 0 || this.param.getMilstdDataType() == 1) {
                                    str5 = "XX XX";
                                } else if (this.param.getMilstdDataType() == 2) {
                                    str5 = "XX";
                                } else if (this.param.getMilstdDataType() == 3) {
                                    str5 = "X XX";
                                }
                            }
                            this.binding.typeFormatValue.setText(str5);
                        }
                        this.binding.typeFormatValue.setSelection(0, 1);
                        this.binding.typeFormatValue.requestFocus();
                        this.formatIndex = 0;
                        this.binding.keyA.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyB.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyC.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyD.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyE.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyF.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyTwo.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 2));
                        this.binding.keyThree.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 2));
                        this.binding.keyFour.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                        this.binding.keyFive.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                        this.binding.keySix.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                        this.binding.keySeven.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                        this.binding.keyEigth.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyNine.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        if (this.format == 0) {
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
                            TriggerParam triggerParam50 = this.param;
                            triggerParam50.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, triggerParam50.getByteLength() * 8);
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                            TriggerParam triggerParam51 = this.param;
                            triggerParam51.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, triggerParam51.getDataBits());
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                            if (this.param.getCanDataIdType() == 0) {
                                TriggerParam triggerParam52 = this.param;
                                triggerParam52.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, triggerParam52.getDataByte() * 8);
                            } else {
                                TriggerParam triggerParam53 = this.param;
                                triggerParam53.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, triggerParam53.getCanIdBits());
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                            TriggerParam triggerParam54 = this.param;
                            triggerParam54.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, triggerParam54.getLinByte() * 8);
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                            if (this.param.getI2sDataType() == 0) {
                                TriggerParam triggerParam55 = this.param;
                                triggerParam55.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, triggerParam55.getWidth());
                            } else if (this.param.getI2sDataType() == 1) {
                                TriggerParam triggerParam56 = this.param;
                                triggerParam56.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, triggerParam56.getWidth());
                            } else if (this.param.getI2sDataType() == 2) {
                                TriggerParam triggerParam57 = this.param;
                                triggerParam57.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, triggerParam57.getWidth());
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
                        String replace2 = this.binding.typeFormatValue.getText().toString().replace("-", "X");
                        int i133 = this.format;
                        if (i133 == 0) {
                            replace2 = "[bin]" + replace2;
                        } else if (i133 == 1) {
                            replace2 = "[hex]" + replace2;
                        }
                        this.formatTransformInterface.FormatTransformListener(replace2);
                        if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_I2C_CODE_ALL, 255);
                            break;
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CODE_ALL, 255);
                            break;
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CODE_ALL, 255);
                            break;
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_LIN_CODE_ALL, 255);
                            break;
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_I2S_CODE_ALL, 255);
                            break;
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_CODE_ALL, 255);
                            break;
                        }
                    }
                    break;
                case R.id.key_delete /* 2131363218 */:
                    if (this.context instanceof Activity) {
                        Editable text5 = this.binding.typeFormatValue.getText();
                        int i134 = this.formatIndex;
                        text5.replace(i134, i134 + 1, "X");
                        StringBuffer stringBuffer2 = new StringBuffer(this.binding.binaryValue.getText().toString());
                        if (this.param.getFormat() == 1) {
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C || this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN || ((this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN && (this.param.getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data || (this.param.getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data_id && !this.param.getCanDefine()))) || (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553 && this.param.getTrigger_1553_When() == ServiceEnum.Trigger_1553_When.trig_1553_data))) {
                                int i135 = this.formatIndex;
                                if (i135 % 3 == 0) {
                                    stringBuffer2.replace(i135 * 3, (i135 * 3) + 4, "XXXX");
                                } else {
                                    stringBuffer2.replace((i135 * 3) + 1, (i135 * 3) + 4 + 1, "XXXX");
                                }
                                this.binding.binaryValue.setText(stringBuffer2.toString());
                                str2 = "XXXX";
                            } else {
                                str2 = "";
                            }
                            int dataBits3 = this.param.getDataBits();
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                                dataBits3 = this.param.getWidth();
                            }
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S || this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                                int i136 = dataBits3 % 8;
                                if (i136 == 0) {
                                    int i137 = this.formatIndex;
                                    if (i137 % 3 == 0) {
                                        stringBuffer2.replace(i137 * 3, (i137 * 3) + 4, "XXXX");
                                    } else {
                                        stringBuffer2.replace((i137 * 3) + 1, (i137 * 3) + 4 + 1, "XXXX");
                                    }
                                    str2 = "XXXX";
                                }
                                int i138 = dataBits3 % 4;
                                if (i138 == 0 && i136 != 0) {
                                    str2 = "XXXX";
                                }
                                if (dataBits3 == 4) {
                                    stringBuffer2.replace(0, 4, str2);
                                }
                                if (dataBits3 == 12) {
                                    int i139 = this.formatIndex;
                                    if (i139 == 0) {
                                        stringBuffer2.replace(0, 4, str2);
                                    } else if (i139 == 1) {
                                        stringBuffer2.replace(5, 9, str2);
                                    } else {
                                        i15 = 2;
                                        if (i139 == 2) {
                                            stringBuffer2.replace(9, 13, str2);
                                        }
                                        if (dataBits3 == 20) {
                                            int i140 = this.formatIndex;
                                            if (i140 == 0) {
                                                stringBuffer2.replace(0, 4, str2);
                                            } else if (i140 == i15) {
                                                stringBuffer2.replace(5, 9, str2);
                                            } else if (i140 == 3) {
                                                stringBuffer2.replace(9, 13, str2);
                                            } else if (i140 == 5) {
                                                stringBuffer2.replace(14, 18, str2);
                                            } else if (i140 == 6) {
                                                stringBuffer2.replace(18, 22, str2);
                                            }
                                        }
                                        if (dataBits3 == 28) {
                                            int i141 = this.formatIndex;
                                            if (i141 == 0) {
                                                stringBuffer2.replace(0, 4, str2);
                                            } else if (i141 == 2) {
                                                stringBuffer2.replace(5, 9, str2);
                                            } else if (i141 == 3) {
                                                stringBuffer2.replace(9, 13, str2);
                                            } else if (i141 == 5) {
                                                stringBuffer2.replace(14, 18, str2);
                                            } else if (i141 == 6) {
                                                stringBuffer2.replace(18, 22, str2);
                                            } else if (i141 == 8) {
                                                stringBuffer2.replace(23, 27, str2);
                                            } else if (i141 == 9) {
                                                stringBuffer2.replace(27, 31, str2);
                                            }
                                        }
                                        if (i138 != 0) {
                                            if (this.formatIndex == 0) {
                                                for (int i142 = 0; i142 < i138; i142++) {
                                                    str2 = str2 + "X";
                                                }
                                            } else {
                                                str2 = "XXXX";
                                            }
                                        }
                                        if (dataBits3 != 5 || dataBits3 == 6 || dataBits3 == 7) {
                                            if (this.formatIndex != 0) {
                                                stringBuffer2.replace(0, i138, str2);
                                            } else {
                                                stringBuffer2.replace(i138, i138 + 4, str2);
                                            }
                                        }
                                        if (dataBits3 != 9 || dataBits3 == 10 || dataBits3 == 11) {
                                            i16 = this.formatIndex;
                                            if (i16 != 0) {
                                                stringBuffer2.replace(0, i138, str2);
                                            } else if (i16 == 2) {
                                                stringBuffer2.replace(i138 + 1, i138 + 5, str2);
                                            } else if (i16 == 3) {
                                                stringBuffer2.replace(i138 + 5, i138 + 9, str2);
                                            }
                                        }
                                        if (dataBits3 != 13 || dataBits3 == 14 || dataBits3 == 15) {
                                            i17 = this.formatIndex;
                                            if (i17 != 0) {
                                                stringBuffer2.replace(0, i138, str2);
                                            } else if (i17 == 1) {
                                                stringBuffer2.replace(i138, i138 + 4, str2);
                                            } else if (i17 == 3) {
                                                stringBuffer2.replace(i138 + 5, i138 + 9, str2);
                                            } else if (i17 == 4) {
                                                stringBuffer2.replace(i138 + 9, i138 + 13, str2);
                                            }
                                        }
                                        if (dataBits3 != 17 || dataBits3 == 18 || dataBits3 == 19) {
                                            i18 = this.formatIndex;
                                            if (i18 != 0) {
                                                stringBuffer2.replace(0, i138, str2);
                                            } else if (i18 == 2) {
                                                stringBuffer2.replace(i138 + 1, i138 + 5, str2);
                                            } else if (i18 == 3) {
                                                stringBuffer2.replace(i138 + 5, i138 + 9, str2);
                                            } else if (i18 == 5) {
                                                stringBuffer2.replace(i138 + 10, i138 + 14, str2);
                                            } else if (i18 == 6) {
                                                stringBuffer2.replace(i138 + 14, i138 + 18, str2);
                                            }
                                        }
                                        if (dataBits3 != 21 || dataBits3 == 22 || dataBits3 == 23) {
                                            i19 = this.formatIndex;
                                            if (i19 != 0) {
                                                stringBuffer2.replace(0, i138, str2);
                                            } else if (i19 == 1) {
                                                stringBuffer2.replace(i138, i138 + 4, str2);
                                            } else if (i19 == 3) {
                                                stringBuffer2.replace(i138 + 5, i138 + 9, str2);
                                            } else if (i19 == 4) {
                                                stringBuffer2.replace(i138 + 9, i138 + 13, str2);
                                            } else if (i19 == 6) {
                                                stringBuffer2.replace(i138 + 14, i138 + 18, str2);
                                            } else if (i19 == 7) {
                                                stringBuffer2.replace(i138 + 18, i138 + 22, str2);
                                            }
                                        }
                                        if (dataBits3 != 25 || dataBits3 == 26 || dataBits3 == 27) {
                                            i20 = this.formatIndex;
                                            if (i20 != 0) {
                                                stringBuffer2.replace(0, i138, str2);
                                            } else if (i20 == 2) {
                                                stringBuffer2.replace(i138 + 1, i138 + 5, str2);
                                            } else if (i20 == 3) {
                                                stringBuffer2.replace(i138 + 5, i138 + 9, str2);
                                            } else if (i20 == 5) {
                                                stringBuffer2.replace(i138 + 10, i138 + 14, str2);
                                            } else if (i20 == 6) {
                                                stringBuffer2.replace(i138 + 14, i138 + 18, str2);
                                            } else if (i20 == 8) {
                                                stringBuffer2.replace(i138 + 19, i138 + 23, str2);
                                            } else if (i20 == 9) {
                                                stringBuffer2.replace(i138 + 23, i138 + 27, str2);
                                            }
                                        }
                                        if (dataBits3 != 29 || dataBits3 == 30 || dataBits3 == 31) {
                                            i21 = this.formatIndex;
                                            if (i21 != 0) {
                                                stringBuffer2.replace(0, i138, str2);
                                            } else if (i21 == 1) {
                                                stringBuffer2.replace(i138, i138 + 4, str2);
                                            } else if (i21 == 3) {
                                                stringBuffer2.replace(i138 + 5, i138 + 9, str2);
                                            } else if (i21 == 4) {
                                                stringBuffer2.replace(i138 + 9, i138 + 13, str2);
                                            } else if (i21 == 6) {
                                                stringBuffer2.replace(i138 + 14, i138 + 18, str2);
                                            } else if (i21 == 7) {
                                                stringBuffer2.replace(i138 + 18, i138 + 22, str2);
                                            } else if (i21 == 9) {
                                                stringBuffer2.replace(i138 + 23, i138 + 27, str2);
                                            } else if (i21 == 10) {
                                                stringBuffer2.replace(i138 + 27, i138 + 31, str2);
                                            }
                                        }
                                        this.binding.binaryValue.setText(stringBuffer2.toString());
                                    }
                                }
                                i15 = 2;
                                if (dataBits3 == 20) {
                                }
                                if (dataBits3 == 28) {
                                }
                                if (i138 != 0) {
                                }
                                if (dataBits3 != 5) {
                                }
                                if (this.formatIndex != 0) {
                                }
                                if (dataBits3 != 9) {
                                }
                                i16 = this.formatIndex;
                                if (i16 != 0) {
                                }
                                if (dataBits3 != 13) {
                                }
                                i17 = this.formatIndex;
                                if (i17 != 0) {
                                }
                                if (dataBits3 != 17) {
                                }
                                i18 = this.formatIndex;
                                if (i18 != 0) {
                                }
                                if (dataBits3 != 21) {
                                }
                                i19 = this.formatIndex;
                                if (i19 != 0) {
                                }
                                if (dataBits3 != 25) {
                                }
                                i20 = this.formatIndex;
                                if (i20 != 0) {
                                }
                                if (dataBits3 != 29) {
                                }
                                i21 = this.formatIndex;
                                if (i21 != 0) {
                                }
                                this.binding.binaryValue.setText(stringBuffer2.toString());
                            }
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN && (this.param.getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_remote_id || this.param.getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_id || (this.param.getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data_id && this.param.getCanDefine()))) {
                                if (this.param.getIdExtended()) {
                                    int i143 = this.formatIndex;
                                    if (i143 == 0) {
                                        stringBuffer2.replace(0, 1, "X");
                                    } else if (i143 == 1) {
                                        stringBuffer2.replace(1, 5, "XXXX");
                                    } else if (i143 == 3) {
                                        stringBuffer2.replace(6, 10, "XXXX");
                                    } else if (i143 == 4) {
                                        stringBuffer2.replace(10, 14, "XXXX");
                                    } else if (i143 == 6) {
                                        stringBuffer2.replace(15, 19, "XXXX");
                                    } else if (i143 == 7) {
                                        stringBuffer2.replace(19, 23, "XXXX");
                                    } else if (i143 == 9) {
                                        stringBuffer2.replace(24, 28, "XXXX");
                                    } else if (i143 == 10) {
                                        stringBuffer2.replace(28, 32, "XXXX");
                                    }
                                } else {
                                    int i144 = this.formatIndex;
                                    if (i144 == 0) {
                                        stringBuffer2.replace(0, 3, "XXX");
                                    } else if (i144 == 2) {
                                        stringBuffer2.replace(4, 8, "XXXX");
                                    } else if (i144 == 3) {
                                        stringBuffer2.replace(8, 12, "XXXX");
                                    }
                                }
                                this.binding.binaryValue.setText(stringBuffer2.toString());
                            }
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553 && (this.param.getTrigger_1553_When() == ServiceEnum.Trigger_1553_When.trig_1553_cmd || (this.param.getTrigger_1553_When() == ServiceEnum.Trigger_1553_When.trig_1553_status && this.param.getMilstdDataType() == 2))) {
                                String str6 = this.formatIndex == 0 ? "X" : "XXXX";
                                if (this.formatIndex == 0) {
                                    stringBuffer2.replace(0, 1, str6);
                                } else {
                                    stringBuffer2.replace(1, 5, str6);
                                }
                                this.binding.binaryValue.setText(stringBuffer2.toString());
                            }
                            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553 && this.param.getTrigger_1553_When() == ServiceEnum.Trigger_1553_When.trig_1553_status && this.param.getMilstdDataType() == 3) {
                                str = this.formatIndex == 0 ? "XXX" : "XXXX";
                                int i145 = this.formatIndex;
                                if (i145 == 0) {
                                    stringBuffer2.replace(0, 3, str);
                                } else if (i145 == 2) {
                                    stringBuffer2.replace(4, 8, str);
                                } else if (i145 == 3) {
                                    stringBuffer2.replace(8, 12, str);
                                }
                                this.binding.binaryValue.setText(stringBuffer2.toString());
                            }
                        }
                        String replace3 = text5.toString().replace("-", "X");
                        int i146 = this.format;
                        if (i146 == 0) {
                            replace3 = "[bin]" + replace3;
                        } else if (i146 == 1) {
                            replace3 = "[hex]" + replace3;
                        }
                        this.formatTransformInterface.FormatTransformListener(replace3);
                        int i147 = this.formatIndex - 1;
                        this.formatIndex = i147;
                        if (i147 < 0) {
                            this.formatIndex = 0;
                        }
                        if (text5.charAt(this.formatIndex) == ' ') {
                            this.formatIndex--;
                        }
                        EditText editText6 = this.binding.typeFormatValue;
                        int i148 = this.formatIndex;
                        editText6.setSelection(i148, i148 + 1);
                        this.binding.keyA.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyB.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyC.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyD.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyE.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyF.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyTwo.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 2));
                        this.binding.keyThree.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 2));
                        this.binding.keyFour.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                        this.binding.keyFive.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                        this.binding.keySix.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                        this.binding.keySeven.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                        this.binding.keyEigth.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        this.binding.keyNine.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                        if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_I2C_CODE, 255);
                            if (this.format == 0) {
                                TriggerParam triggerParam58 = this.param;
                                int i149 = this.formatIndex;
                                triggerParam58.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, i149 - (i149 / 9));
                                break;
                            } else {
                                TriggerParam triggerParam59 = this.param;
                                triggerParam59.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, (this.formatIndex + (triggerParam59.getByteLength() * 8)) - (this.formatIndex / 3));
                                break;
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CODE, 255);
                            if (this.format == 0) {
                                int i150 = this.formatIndex;
                                if (this.param.getDataBits() <= 8 || this.param.getDataBits() > 16) {
                                    if (this.param.getDataBits() > 16 && this.param.getDataBits() <= 24) {
                                        if (this.formatIndex <= this.param.getDataBits() % 8 || this.formatIndex >= (this.param.getDataBits() % 8) + 9) {
                                            break;
                                        }
                                        i150--;
                                        this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i150);
                                    } else {
                                        if (this.param.getDataBits() > 24) {
                                            if (this.formatIndex <= this.param.getDataBits() % 8 || this.formatIndex >= (this.param.getDataBits() % 8) + 9) {
                                                if (this.formatIndex <= (this.param.getDataBits() % 8) + 9 || this.formatIndex >= (this.param.getDataBits() % 8) + 18) {
                                                    if (this.formatIndex > (this.param.getDataBits() % 8) + 18) {
                                                        i150 -= 3;
                                                    }
                                                }
                                                i150 -= 2;
                                            }
                                            i150--;
                                        }
                                        this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i150);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                String obj7 = text5.toString();
                                int i151 = 0;
                                for (int i152 = 0; i152 < this.formatIndex; i152++) {
                                    if (obj7.charAt(i152) != ' ') {
                                        i151++;
                                    }
                                }
                                TriggerParam triggerParam60 = this.param;
                                triggerParam60.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i151 + triggerParam60.getDataBits());
                                break;
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CODE, 255);
                            if (this.format == 0) {
                                if (this.param.getCanDataIdType() == 0) {
                                    TriggerParam triggerParam61 = this.param;
                                    int i153 = this.formatIndex;
                                    triggerParam61.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i153 - (i153 / 9));
                                    break;
                                } else {
                                    int i154 = this.formatIndex;
                                    if (this.param.getIdExtended()) {
                                        int i155 = this.formatIndex;
                                        if (i155 < 6 || i155 > 13) {
                                            int i156 = this.formatIndex;
                                            if (i156 < 15 || i156 > 22) {
                                                int i157 = this.formatIndex;
                                                if (i157 >= 24 && i157 <= 31) {
                                                    i154 -= 3;
                                                }
                                            } else {
                                                i154 -= 2;
                                            }
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i154);
                                            break;
                                        }
                                        i154--;
                                        this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i154);
                                    } else {
                                        int i158 = this.formatIndex;
                                        if (i158 >= 4) {
                                            break;
                                        }
                                        this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i154);
                                    }
                                }
                            } else if (this.param.getCanDataIdType() == 0) {
                                TriggerParam triggerParam62 = this.param;
                                triggerParam62.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, (this.formatIndex + (triggerParam62.getDataByte() * 8)) - (this.formatIndex / 3));
                                break;
                            } else {
                                TriggerParam triggerParam63 = this.param;
                                triggerParam63.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, (this.formatIndex + triggerParam63.getCanIdBits()) - (this.formatIndex / 3));
                                break;
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_LIN_CODE, 255);
                            if (this.format == 0) {
                                TriggerParam triggerParam64 = this.param;
                                int i159 = this.formatIndex;
                                triggerParam64.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, i159 - (i159 / 9));
                                break;
                            } else {
                                TriggerParam triggerParam65 = this.param;
                                triggerParam65.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, (this.formatIndex + (triggerParam65.getLinByte() * 8)) - (this.formatIndex / 3));
                                break;
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_I2S_CODE, 255);
                            if (this.format == 0) {
                                int i160 = this.formatIndex;
                                if (this.param.getWidth() <= 8 || this.param.getWidth() > 16) {
                                    if (this.param.getWidth() > 16 && this.param.getWidth() <= 24) {
                                        if (this.formatIndex <= this.param.getWidth() % 8 || this.formatIndex >= (this.param.getWidth() % 8) + 9) {
                                            break;
                                        }
                                        i160--;
                                        if (this.param.getI2sDataType() != 0) {
                                        }
                                    } else {
                                        if (this.param.getWidth() > 24) {
                                            if (this.formatIndex <= this.param.getWidth() % 8 || this.formatIndex >= (this.param.getWidth() % 8) + 9) {
                                                if (this.formatIndex <= (this.param.getWidth() % 8) + 9 || this.formatIndex >= (this.param.getWidth() % 8) + 18) {
                                                    if (this.formatIndex > (this.param.getWidth() % 8) + 18) {
                                                        i160 -= 3;
                                                    }
                                                }
                                                i160 -= 2;
                                            }
                                            i160--;
                                        }
                                        if (this.param.getI2sDataType() != 0) {
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, i160);
                                            break;
                                        } else if (this.param.getI2sDataType() == 1) {
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, i160);
                                            break;
                                        } else if (this.param.getI2sDataType() == 2) {
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, i160);
                                            break;
                                        }
                                    }
                                } else {
                                    break;
                                }
                            } else if (this.param.getI2sDataType() == 0) {
                                TriggerParam triggerParam66 = this.param;
                                triggerParam66.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, (this.formatIndex + triggerParam66.getWidth()) - (this.formatIndex / 2));
                                break;
                            } else if (this.param.getI2sDataType() == 1) {
                                TriggerParam triggerParam67 = this.param;
                                triggerParam67.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, (this.formatIndex + triggerParam67.getWidth()) - (this.formatIndex / 2));
                                break;
                            } else if (this.param.getI2sDataType() == 2) {
                                TriggerParam triggerParam68 = this.param;
                                triggerParam68.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, (this.formatIndex + triggerParam68.getWidth()) - (this.formatIndex / 2));
                                break;
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_CODE, 255);
                            if (this.format == 0) {
                                if (this.param.getMilstdDataType() == 0) {
                                    TriggerParam triggerParam69 = this.param;
                                    int i161 = this.formatIndex;
                                    triggerParam69.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, i161 - (i161 / 9));
                                    break;
                                } else if (this.param.getMilstdDataType() == 1) {
                                    TriggerParam triggerParam70 = this.param;
                                    int i162 = this.formatIndex;
                                    triggerParam70.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, i162 - (i162 / 9));
                                    break;
                                } else if (this.param.getMilstdDataType() == 2) {
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, this.formatIndex);
                                    break;
                                } else if (this.param.getMilstdDataType() == 3) {
                                    int i163 = this.formatIndex;
                                    if (i163 > 3) {
                                        i163--;
                                    }
                                    this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, i163);
                                    break;
                                }
                            } else if (this.param.getMilstdDataType() == 0) {
                                TriggerParam triggerParam71 = this.param;
                                int i164 = this.formatIndex;
                                triggerParam71.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, (i164 + 16) - (i164 / 3));
                                break;
                            } else if (this.param.getMilstdDataType() == 1) {
                                TriggerParam triggerParam72 = this.param;
                                int i165 = this.formatIndex;
                                triggerParam72.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, (i165 + 16) - (i165 / 3));
                                break;
                            } else if (this.param.getMilstdDataType() == 2) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, this.formatIndex + 5);
                                break;
                            } else if (this.param.getMilstdDataType() == 3) {
                                TriggerParam triggerParam73 = this.param;
                                int i166 = this.formatIndex;
                                triggerParam73.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, (i166 + 11) - (i166 / 2));
                                break;
                            }
                        }
                    }
                    break;
                default:
                    switch (id) {
                        case R.id.key_five /* 2131363223 */:
                        case R.id.key_four /* 2131363224 */:
                            break;
                        case R.id.key_left /* 2131363225 */:
                            if (this.context instanceof Activity) {
                                this.formatIndex--;
                                String obj8 = this.binding.typeFormatValue.getText().toString();
                                int i167 = this.formatIndex;
                                if (i167 > 0 && obj8.charAt(i167) == ' ') {
                                    this.formatIndex--;
                                }
                                if (this.formatIndex < 0) {
                                    this.formatIndex = 0;
                                }
                                int length17 = this.binding.typeFormatValue.getText().length();
                                this.formatIndexMax = length17;
                                if (this.formatIndex >= length17) {
                                    this.formatIndex = length17 - 1;
                                }
                                EditText editText7 = this.binding.typeFormatValue;
                                int i168 = this.formatIndex;
                                editText7.setSelection(i168, i168 + 1);
                                this.binding.keyA.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                                this.binding.keyB.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                                this.binding.keyC.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                                this.binding.keyD.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                                this.binding.keyE.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                                this.binding.keyF.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                                this.binding.keyTwo.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 2));
                                this.binding.keyThree.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 2));
                                this.binding.keyFour.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                                this.binding.keyFive.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                                this.binding.keySix.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                                this.binding.keySeven.setEnabled(this.format != 0 && (this.param.isShow() == 0 || this.formatIndex != 0 || this.param.isShow() >= 3));
                                this.binding.keyEigth.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                                this.binding.keyNine.setEnabled(this.format != 0 && (this.formatIndex != 0 || this.param.isShow() == 0));
                                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                                    if (this.format == 0) {
                                        TriggerParam triggerParam74 = this.param;
                                        int i169 = this.formatIndex;
                                        triggerParam74.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, i169 - (i169 / 9));
                                    } else {
                                        TriggerParam triggerParam75 = this.param;
                                        triggerParam75.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, (this.formatIndex + (triggerParam75.getByteLength() * 8)) - (this.formatIndex / 3));
                                    }
                                }
                                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                                    if (this.format == 0) {
                                        int i170 = this.formatIndex;
                                        if (this.param.getDataBits() > 8 && this.param.getDataBits() <= 16) {
                                            break;
                                        } else if (this.param.getDataBits() > 16 && this.param.getDataBits() <= 24) {
                                            if (this.formatIndex <= this.param.getDataBits() % 8 || this.formatIndex >= (this.param.getDataBits() % 8) + 9) {
                                                break;
                                            }
                                            i170--;
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i170);
                                        } else {
                                            if (this.param.getDataBits() > 24) {
                                                if (this.formatIndex <= this.param.getDataBits() % 8 || this.formatIndex >= (this.param.getDataBits() % 8) + 9) {
                                                    if (this.formatIndex <= (this.param.getDataBits() % 8) + 9 || this.formatIndex >= (this.param.getDataBits() % 8) + 18) {
                                                        if (this.formatIndex > (this.param.getDataBits() % 8) + 18) {
                                                            i170 -= 3;
                                                        }
                                                    }
                                                    i170 -= 2;
                                                }
                                                i170--;
                                            }
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i170);
                                        }
                                    } else {
                                        int i171 = 0;
                                        for (int i172 = 0; i172 < this.formatIndex; i172++) {
                                            if (obj8.charAt(i172) != ' ') {
                                                i171++;
                                            }
                                        }
                                        TriggerParam triggerParam76 = this.param;
                                        triggerParam76.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, i171 + triggerParam76.getDataBits());
                                    }
                                }
                                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                                    if (this.format == 0) {
                                        if (this.param.getCanDataIdType() == 0) {
                                            TriggerParam triggerParam77 = this.param;
                                            int i173 = this.formatIndex;
                                            triggerParam77.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i173 - (i173 / 9));
                                        } else {
                                            int i174 = this.formatIndex;
                                            if (this.param.getIdExtended()) {
                                                int i175 = this.formatIndex;
                                                if (i175 < 6 || i175 > 13) {
                                                    int i176 = this.formatIndex;
                                                    if (i176 < 15 || i176 > 22) {
                                                        int i177 = this.formatIndex;
                                                        if (i177 >= 24 && i177 <= 31) {
                                                            i174 -= 3;
                                                        }
                                                    } else {
                                                        i174 -= 2;
                                                    }
                                                    this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i174);
                                                }
                                                i174--;
                                                this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i174);
                                            } else {
                                                int i178 = this.formatIndex;
                                                if (i178 >= 4) {
                                                    break;
                                                }
                                                this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, i174);
                                            }
                                        }
                                    } else if (this.param.getCanDataIdType() == 0) {
                                        TriggerParam triggerParam78 = this.param;
                                        triggerParam78.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, (this.formatIndex + (triggerParam78.getDataByte() * 8)) - (this.formatIndex / 3));
                                    } else {
                                        TriggerParam triggerParam79 = this.param;
                                        triggerParam79.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, (this.formatIndex + triggerParam79.getCanIdBits()) - (this.formatIndex / 3));
                                    }
                                }
                                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                                    if (this.format == 0) {
                                        TriggerParam triggerParam80 = this.param;
                                        int i179 = this.formatIndex;
                                        triggerParam80.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, i179 - (i179 / 9));
                                    } else {
                                        TriggerParam triggerParam81 = this.param;
                                        triggerParam81.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, (this.formatIndex + (triggerParam81.getLinByte() * 8)) - (this.formatIndex / 3));
                                    }
                                }
                                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                                    if (this.format == 0) {
                                        int i180 = this.formatIndex;
                                        if (this.param.getWidth() > 8 && this.param.getWidth() <= 16) {
                                            break;
                                        } else if (this.param.getWidth() > 16 && this.param.getWidth() <= 24) {
                                            if (this.formatIndex <= this.param.getWidth() % 8 || this.formatIndex >= (this.param.getWidth() % 8) + 9) {
                                                break;
                                            }
                                            i180--;
                                            if (this.param.getI2sDataType() != 0) {
                                            }
                                        } else {
                                            if (this.param.getWidth() > 24) {
                                                if (this.formatIndex <= this.param.getWidth() % 8 || this.formatIndex >= (this.param.getWidth() % 8) + 9) {
                                                    if (this.formatIndex <= (this.param.getWidth() % 8) + 9 || this.formatIndex >= (this.param.getWidth() % 8) + 18) {
                                                        if (this.formatIndex > (this.param.getWidth() % 8) + 18) {
                                                            i180 -= 3;
                                                        }
                                                    }
                                                    i180 -= 2;
                                                }
                                                i180--;
                                            }
                                            if (this.param.getI2sDataType() != 0) {
                                                this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, i180);
                                            } else if (this.param.getI2sDataType() == 1) {
                                                this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, i180);
                                            } else if (this.param.getI2sDataType() == 2) {
                                                this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, i180);
                                            }
                                        }
                                    } else if (this.param.getI2sDataType() == 0) {
                                        TriggerParam triggerParam82 = this.param;
                                        triggerParam82.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, (this.formatIndex + triggerParam82.getWidth()) - (this.formatIndex / 2));
                                    } else if (this.param.getI2sDataType() == 1) {
                                        TriggerParam triggerParam83 = this.param;
                                        triggerParam83.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, (this.formatIndex + triggerParam83.getWidth()) - (this.formatIndex / 2));
                                    } else if (this.param.getI2sDataType() == 2) {
                                        TriggerParam triggerParam84 = this.param;
                                        triggerParam84.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, (this.formatIndex + triggerParam84.getWidth()) - (this.formatIndex / 2));
                                    }
                                }
                                if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                                    if (this.format == 0) {
                                        if (this.param.getMilstdDataType() == 0) {
                                            TriggerParam triggerParam85 = this.param;
                                            int i181 = this.formatIndex;
                                            triggerParam85.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, i181 - (i181 / 9));
                                            break;
                                        } else if (this.param.getMilstdDataType() == 1) {
                                            TriggerParam triggerParam86 = this.param;
                                            int i182 = this.formatIndex;
                                            triggerParam86.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, i182 - (i182 / 9));
                                            break;
                                        } else if (this.param.getMilstdDataType() == 2) {
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, this.formatIndex);
                                            break;
                                        } else if (this.param.getMilstdDataType() == 3) {
                                            int i183 = this.formatIndex;
                                            if (i183 > 3) {
                                                i183--;
                                            }
                                            this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, i183);
                                            break;
                                        }
                                    } else if (this.param.getMilstdDataType() == 0) {
                                        TriggerParam triggerParam87 = this.param;
                                        int i184 = this.formatIndex;
                                        triggerParam87.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, (i184 + 16) - (i184 / 3));
                                        break;
                                    } else if (this.param.getMilstdDataType() == 1) {
                                        TriggerParam triggerParam88 = this.param;
                                        int i185 = this.formatIndex;
                                        triggerParam88.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, (i185 + 16) - (i185 / 3));
                                        break;
                                    } else if (this.param.getMilstdDataType() == 2) {
                                        this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, this.formatIndex + 5);
                                        break;
                                    } else if (this.param.getMilstdDataType() == 3) {
                                        TriggerParam triggerParam89 = this.param;
                                        int i186 = this.formatIndex;
                                        triggerParam89.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, (i186 + 11) - (i186 / 2));
                                        break;
                                    }
                                }
                            }
                            break;
                        default:
                            switch (id) {
                                case R.id.key_nine /* 2131363227 */:
                                case R.id.key_one /* 2131363229 */:
                                    break;
                                case R.id.key_ok /* 2131363228 */:
                                    if (this.context instanceof Activity) {
                                        String replace4 = this.binding.typeFormatValue.getText().toString().replace("-", "X");
                                        int i187 = this.format;
                                        if (i187 == 0) {
                                            replace4 = "[bin]" + replace4;
                                        } else if (i187 == 1) {
                                            replace4 = "[hex]" + replace4;
                                        }
                                        this.formatTransformInterface.FormatTransformListener(replace4);
                                        dismiss();
                                        break;
                                    }
                                    break;
                                default:
                                    switch (id) {
                                    }
                            }
                    }
            }
        }
        if (this.format == 0) {
            this.binding.binaryValue.setText(this.binding.typeFormatValue.getText().toString());
        }
        this.param.setTriggerBinaryData(this.binding.binaryValue.getText().toString());
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
