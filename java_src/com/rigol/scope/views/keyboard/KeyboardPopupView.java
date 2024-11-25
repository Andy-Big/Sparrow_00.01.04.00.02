package com.rigol.scope.views.keyboard;

import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import androidx.exifinterface.media.ExifInterface;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.KeyBean;
import com.rigol.scope.data.KeyboardParam;
import com.rigol.scope.databinding.PopupviewKeyboardBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.ViewStateViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class KeyboardPopupView extends BasePopupView implements View.OnClickListener {
    private final String IPDefaultValues;
    private final String IPMaxValues;
    private final String IPMinValues;
    private AorBManager aorBManager;
    private final PopupviewKeyboardBinding binding;
    private final long defaultValue;
    private final long editTextDefaultValue;
    private boolean editTextSelectAll;
    private Editable editable;
    private final int inputMaxLength;
    private final String ipEditTextDefaultValue;
    private List<KeyBean> keyBeans;
    private final KeyboardListener mKeyboardListener;
    private boolean maxBtnClick;
    private final long maxValue;
    private boolean minBtnClick;
    private long minUnitValue;
    private final long minValue;
    private final KeyboardParam param;
    private KeyBean selectedBean;
    private final List<View> unitButtons;
    private boolean unitClick;
    private final ServiceEnum.Unit unitType;
    private ViewStateViewModel viewStateViewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$new$0(View view) {
        return true;
    }

    public List<KeyBean> getKeyBeans() {
        List<KeyBean> list = this.keyBeans;
        return list == null ? new ArrayList() : list;
    }

    public KeyBean getSelectedBean() {
        return this.selectedBean;
    }

    public void setSelectedBean(KeyBean keyBean) {
        this.selectedBean = keyBean;
    }

    public KeyboardPopupView(Builder builder) {
        super((int) R.style.App_PopupWindow_Keyboard);
        this.editTextSelectAll = true;
        this.unitClick = false;
        this.maxBtnClick = false;
        this.minBtnClick = false;
        this.minUnitValue = 0L;
        this.unitButtons = new ArrayList();
        this.keyBeans = new ArrayList();
        this.inputMaxLength = 16;
        this.unitType = builder.unitType;
        this.maxValue = builder.maxValue;
        this.IPMaxValues = builder.IPMaxValues;
        this.minValue = builder.minValue;
        this.IPMinValues = builder.IPMinValues;
        this.defaultValue = builder.defaultValue;
        this.IPDefaultValues = builder.IPDefaultValues;
        this.mKeyboardListener = builder.keyboardListener;
        this.ipEditTextDefaultValue = builder.ipEditTextDefaultValue;
        this.editTextDefaultValue = builder.editTextDefaultValue;
        PopupviewKeyboardBinding inflate = PopupviewKeyboardBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        this.unitButtons.add(inflate.btnUnit1);
        this.unitButtons.add(this.binding.btnUnit2);
        this.unitButtons.add(this.binding.btnUnit3);
        this.unitButtons.add(this.binding.btnUnit4);
        this.unitButtons.add(this.binding.btnUnit5);
        setContentView(this.binding.getRoot());
        KeyboardParam keyboardParam = new KeyboardParam(this.unitType);
        this.param = keyboardParam;
        keyboardParam.setupBaseSi(this.unitType);
        this.param.setUnitSi();
        this.binding.setParam(this.param);
        setButtonDisable();
        this.binding.edtValue.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.rigol.scope.views.keyboard.-$$Lambda$KeyboardPopupView$uinZhcpFs-U7KnzulhYC_7ez0Ok
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return KeyboardPopupView.lambda$new$0(view);
            }
        });
        this.binding.edtValue.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.keyboard.-$$Lambda$KeyboardPopupView$yiMlCbiLyBgDEYDdJ5xV2hvxlnM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeyboardPopupView.this.lambda$new$1$KeyboardPopupView(view);
            }
        });
        setEditText(this.ipEditTextDefaultValue, this.editTextDefaultValue);
        this.binding.edtValue.clearFocus();
        this.binding.edtValue.requestFocus();
        this.binding.edtValue.selectAll();
        this.editTextSelectAll = true;
        this.editable = this.binding.edtValue.getText();
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new AorBParam(this.binding.edtValue, 0, true, ViewUtil.KEY_A, 0));
        AorBManager aorBManager = new AorBManager(this.context, arrayList) { // from class: com.rigol.scope.views.keyboard.KeyboardPopupView.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                KeyboardPopupView.this.aorBManager.showKey(KeyboardPopupView.this.context, ((AorBParam) arrayList.get(i)).getEditText(), true, ((AorBParam) arrayList.get(i)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        List<KeyBean> keyboardBeans = aorBManager.getKeyboardBeans(this.binding);
        this.keyBeans = keyboardBeans;
        if (keyboardBeans != null && keyboardBeans.size() > 0) {
            this.selectedBean = this.keyBeans.get(0);
        }
        this.selectedBean = this.aorBManager.resetViewAndSelectView(null, this.selectedBean);
        this.binding.btnZero.setOnClickListener(this);
        this.binding.btnOne.setOnClickListener(this);
        this.binding.btnTwo.setOnClickListener(this);
        this.binding.btnThree.setOnClickListener(this);
        this.binding.btnFour.setOnClickListener(this);
        this.binding.btnFive.setOnClickListener(this);
        this.binding.btnSix.setOnClickListener(this);
        this.binding.btnSeven.setOnClickListener(this);
        this.binding.btnEight.setOnClickListener(this);
        this.binding.btnNine.setOnClickListener(this);
        this.binding.btnUnit1.setOnClickListener(this);
        this.binding.btnUnit2.setOnClickListener(this);
        this.binding.btnUnit3.setOnClickListener(this);
        this.binding.btnUnit4.setOnClickListener(this);
        this.binding.btnUnit5.setOnClickListener(this);
        this.binding.btnDelete.setOnClickListener(this);
        this.binding.btnMax.setOnClickListener(this);
        this.binding.btnMin.setOnClickListener(this);
        this.binding.btnDef.setOnClickListener(this);
        this.binding.btnCls.setOnClickListener(this);
        this.binding.btnOk.setOnClickListener(this);
        this.binding.btnDecimalPoint.setOnClickListener(this);
        this.binding.btnPositiveOrNegative.setOnClickListener(this);
        this.binding.btnExp.setOnClickListener(this);
        ViewStateViewModel viewStateViewModel = ViewUtil.getViewStateViewModel();
        this.viewStateViewModel = viewStateViewModel;
        viewStateViewModel.getViewState().setValue(3);
    }

    public /* synthetic */ void lambda$new$1$KeyboardPopupView(View view) {
        this.editTextSelectAll = false;
    }

    private void setEditText(String str, long j) {
        double d;
        String str2;
        if (this.unitType == ServiceEnum.Unit.Unit_ip) {
            this.binding.edtValue.setText(str);
        } else if (this.unitType == ServiceEnum.Unit.Unit_number || this.unitType == ServiceEnum.Unit.Unit_percent) {
            this.param.getFormat().setPattern(UnitFormat.PATTERN_SIGN);
            this.binding.edtValue.setText(String.valueOf(j));
        } else if (this.unitType == ServiceEnum.Unit.Unit_hz) {
            UnitFormat format = this.param.getFormat();
            format.setPattern("0.##########");
            this.binding.edtValue.setText(format.convert(j, this.param.getUnit()));
        } else if (this.unitType == ServiceEnum.Unit.Unit_db || this.unitType == ServiceEnum.Unit.Unit_dbm || this.unitType == ServiceEnum.Unit.Unit_dBmV || this.unitType == ServiceEnum.Unit.Unit_dBuV || this.unitType == ServiceEnum.Unit.Unit_dbV) {
            if (Math.abs((j * 1.0d) / 1.0E9d) > 1000.0d) {
                str2 = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(j, this.param.getUnit());
            } else {
                str2 = ViewUtil.subNumber(String.valueOf(d), 5) + this.param.getUnit().value2;
            }
            this.binding.edtValue.setText(str2);
        } else {
            this.binding.edtValue.setText(this.param.getFormat().convert(j, this.param.getUnit()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.keyboard.KeyboardPopupView$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit;

        static {
            int[] iArr = new int[ServiceEnum.Unit.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit = iArr;
            try {
                iArr[ServiceEnum.Unit.Unit_oum.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_password.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_ip.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_percent.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_U.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_Div.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_db.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_dbm.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_dbV.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_Vrms.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_dBmV.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_dBuV.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_number.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_decimal.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    private void setButtonDisable() {
        switch (AnonymousClass2.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[this.unitType.ordinal()]) {
            case 1:
                this.binding.btnExp.setText("");
                this.binding.btnExp.setEnabled(false);
                this.binding.btnPositiveOrNegative.setText("");
                this.binding.btnPositiveOrNegative.setEnabled(false);
                this.binding.btnDecimalPoint.setText("");
                this.binding.btnDecimalPoint.setEnabled(false);
                return;
            case 2:
                this.binding.btnExp.setText("");
                this.binding.btnExp.setEnabled(false);
                this.binding.btnPositiveOrNegative.setText("");
                this.binding.btnPositiveOrNegative.setEnabled(false);
                this.binding.btnDecimalPoint.setText("");
                this.binding.btnDecimalPoint.setEnabled(false);
                this.binding.btnMax.setText("");
                this.binding.btnMax.setEnabled(false);
                this.binding.btnMin.setText("");
                this.binding.btnMin.setEnabled(false);
                this.binding.btnCls.setText("");
                this.binding.btnCls.setEnabled(false);
                return;
            case 3:
                this.binding.btnUnit1.setEnabled(false);
                this.binding.btnUnit2.setEnabled(false);
                this.binding.btnUnit3.setEnabled(false);
                this.binding.btnUnit4.setEnabled(false);
                this.binding.btnUnit5.setEnabled(false);
                this.binding.btnExp.setText("");
                this.binding.btnExp.setEnabled(false);
                this.binding.btnPositiveOrNegative.setText("");
                this.binding.btnPositiveOrNegative.setEnabled(false);
                return;
            case 4:
                this.binding.btnDecimalPoint.setText("");
                this.binding.btnDecimalPoint.setEnabled(false);
                this.binding.btnUnit2.setEnabled(false);
                this.binding.btnUnit3.setEnabled(false);
                this.binding.btnUnit4.setEnabled(false);
                this.binding.btnUnit5.setEnabled(false);
                return;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                this.binding.btnUnit3.setEnabled(false);
                this.binding.btnUnit4.setEnabled(false);
                this.binding.btnUnit5.setEnabled(false);
                return;
            case 13:
                this.binding.btnDecimalPoint.setText("");
                this.binding.btnDecimalPoint.setEnabled(false);
                this.binding.btnUnit1.setEnabled(false);
                this.binding.btnUnit2.setEnabled(false);
                this.binding.btnUnit3.setEnabled(false);
                this.binding.btnUnit4.setEnabled(false);
                this.binding.btnUnit5.setEnabled(false);
                return;
            case 14:
                this.binding.btnUnit1.setEnabled(false);
                this.binding.btnUnit2.setEnabled(false);
                this.binding.btnUnit3.setEnabled(false);
                this.binding.btnUnit4.setEnabled(false);
                this.binding.btnUnit5.setEnabled(false);
                return;
            default:
                return;
        }
    }

    public void setBaseSI(UnitFormat.SI si) {
        KeyboardParam keyboardParam = this.param;
        if (keyboardParam != null) {
            keyboardParam.setBaseSi(si);
            setEditText(this.ipEditTextDefaultValue, this.editTextDefaultValue);
        }
    }

    public void setPattern(String str) {
        KeyboardParam keyboardParam = this.param;
        if (keyboardParam != null) {
            keyboardParam.getFormat().setPattern(str);
            setEditText(this.ipEditTextDefaultValue, this.editTextDefaultValue);
        }
    }

    public void setPattern(String str, int i) {
        KeyboardParam keyboardParam = this.param;
        if (keyboardParam != null) {
            keyboardParam.getFormat().setPattern(str);
            this.binding.edtValue.setText(ViewUtil.subNumber(this.param.getFormat().convert(this.editTextDefaultValue, this.param.getUnit()), i));
        }
    }

    public KeyboardParam getParam() {
        return this.param;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        KeyBean keyBean;
        Iterator<KeyBean> it = this.keyBeans.iterator();
        while (true) {
            if (!it.hasNext()) {
                keyBean = null;
                break;
            }
            keyBean = it.next();
            if (keyBean.getView() == view) {
                break;
            }
        }
        this.selectedBean = this.aorBManager.resetViewAndSelectView(this.selectedBean, keyBean);
        int selectionStart = this.binding.edtValue.getSelectionStart();
        int selectionEnd = this.binding.edtValue.getSelectionEnd();
        this.editable = this.binding.edtValue.getText();
        int id = view.getId();
        if (id != R.id.btn_ok) {
            this.maxBtnClick = false;
            this.minBtnClick = false;
        }
        if (id == R.id.btn_one) {
            btnClickNum(this.binding.btnOne);
        } else if (id == R.id.btn_two) {
            btnClickNum(this.binding.btnTwo);
        } else if (id == R.id.btn_three) {
            btnClickNum(this.binding.btnThree);
        } else if (id == R.id.btn_four) {
            btnClickNum(this.binding.btnFour);
        } else if (id == R.id.btn_five) {
            btnClickNum(this.binding.btnFive);
        } else if (id == R.id.btn_six) {
            btnClickNum(this.binding.btnSix);
        } else if (id == R.id.btn_seven) {
            btnClickNum(this.binding.btnSeven);
        } else if (id == R.id.btn_eight) {
            btnClickNum(this.binding.btnEight);
        } else if (id == R.id.btn_nine) {
            btnClickNum(this.binding.btnNine);
        } else if (id == R.id.btn_zero) {
            btnClickNum(this.binding.btnZero);
        } else if (id == R.id.btn_delete) {
            Editable editable = this.editable;
            if (editable == null || editable.length() <= 0) {
                return;
            }
            if (selectionStart == selectionEnd && selectionStart != 0) {
                this.editable.delete(selectionStart - 1, selectionStart);
                return;
            }
            this.editable.delete(selectionStart, selectionEnd);
            this.editTextSelectAll = false;
        } else if (id == R.id.btn_max) {
            this.unitClick = true;
            this.maxBtnClick = true;
            setEditText(this.IPMaxValues, this.maxValue);
            this.minUnitValue = this.maxValue;
            this.binding.edtValue.clearFocus();
            this.binding.edtValue.requestFocus();
            this.binding.edtValue.selectAll();
            this.editTextSelectAll = true;
        } else if (id == R.id.btn_min) {
            this.unitClick = true;
            this.minBtnClick = true;
            setEditText(this.IPMinValues, this.minValue);
            this.minUnitValue = this.minValue;
            this.binding.edtValue.clearFocus();
            this.binding.edtValue.requestFocus();
            this.binding.edtValue.selectAll();
            this.editTextSelectAll = true;
        } else if (id == R.id.btn_cls) {
            this.binding.edtValue.setText("");
        } else if (id == R.id.btn_def) {
            this.unitClick = true;
            setEditText(this.IPDefaultValues, this.defaultValue);
            this.minUnitValue = this.defaultValue;
            this.binding.edtValue.clearFocus();
            this.binding.edtValue.requestFocus();
            this.binding.edtValue.selectAll();
            this.editTextSelectAll = true;
        } else if (id == R.id.btn_ok) {
            String charSequence = this.binding.btnUnit1.getText().toString();
            String charSequence2 = this.binding.btnUnit2.getText().toString();
            String charSequence3 = this.binding.btnUnit3.getText().toString();
            String charSequence4 = this.binding.btnUnit4.getText().toString();
            String charSequence5 = this.binding.btnUnit5.getText().toString();
            String replace = this.binding.edtValue.getText().toString().replace("e", "").replace(".", "");
            char[] charArray = replace.toCharArray();
            Pattern compile = Pattern.compile("^[-\\+]?[\\d]*$");
            int i = 0;
            for (char c : charArray) {
                if (!compile.matcher(String.valueOf(c)).matches()) {
                    i++;
                }
            }
            String substring = replace.substring(replace.length() - i);
            if (replace.length() <= 0) {
                dismiss();
            } else if (substring.equals(charSequence)) {
                btnUnitClick(charSequence);
            } else if (substring.equals(charSequence2)) {
                btnUnitClick(charSequence2);
            } else if (substring.equals(charSequence3)) {
                btnUnitClick(charSequence3);
            } else if (substring.equals(charSequence4)) {
                btnUnitClick(charSequence4);
            } else if (substring.equals(charSequence5)) {
                btnUnitClick(charSequence5);
            } else {
                char charAt = replace.charAt(replace.length() - 1);
                if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                    btnclickOk();
                } else if (charSequence.equals("s") || charSequence.equals("U") || charSequence.equals("dBm") || charSequence.equals("°") || charSequence.equals("%") || charSequence.equals("dB") || charSequence.equals("dBV") || charSequence.equals("Vrms") || charSequence.equals("") || charSequence.equals("div") || charSequence.equals("dBmV") || charSequence.equals("dBμV")) {
                    btnUnitClick(charSequence);
                } else if (charSequence2.equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) || charSequence2.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) || charSequence2.equals("V*s")) {
                    btnUnitClick(charSequence2);
                } else if (charSequence3.equals(ExifInterface.LONGITUDE_WEST) || charSequence3.equals("V/s")) {
                    btnUnitClick(charSequence3);
                } else if (charSequence4.equals("Hz") || charSequence4.equals("Sa/s") || charSequence4.equals("")) {
                    btnUnitClick(charSequence4);
                }
            }
        } else if (id == R.id.btn_decimalPoint) {
            decimalPointMethod(selectionStart, selectionEnd);
        } else if (id == R.id.btn_PositiveOrNegative) {
            if (this.binding.edtValue.getText().toString().endsWith("e")) {
                this.editable.insert(this.binding.edtValue.getSelectionStart(), "-");
                return;
            }
            if (!this.binding.edtValue.getText().toString().equals("") && this.editTextSelectAll) {
                this.binding.edtValue.setText("");
                this.editable = this.binding.edtValue.getText();
                this.editTextSelectAll = false;
            }
            if (this.editable.toString().startsWith("-")) {
                this.binding.edtValue.setText(this.binding.edtValue.getText().toString().replaceFirst("-", ""));
                this.editable = this.binding.edtValue.getText();
                this.binding.edtValue.setSelection(this.editable.length());
            } else if (this.binding.edtValue.getText().toString().length() < this.inputMaxLength) {
                this.editable.insert(0, "-");
            } else {
                ToastUtils.showShort(this.context.getResources().getString(R.string.err_ime_length_over));
            }
        } else if (id == R.id.btn_exp) {
            if (this.editTextSelectAll) {
                this.binding.edtValue.setText("");
            }
            if (this.binding.edtValue.getText().toString().contains("e") || "".equals(this.binding.edtValue.getText().toString())) {
                return;
            }
            if (this.binding.edtValue.getText().toString().endsWith(".")) {
                this.editable.insert(selectionEnd, "0e");
            } else {
                this.editable.insert(selectionEnd, "e");
            }
        } else if (id == R.id.btn_unit1) {
            KeyboardParam keyboardParam = this.param;
            onUnitButtonClick(keyboardParam, keyboardParam.getUnitSiList().get(0));
            this.unitClick = true;
        } else if (id == R.id.btn_unit2) {
            this.param.getUnitSiList().get(1);
            KeyboardParam keyboardParam2 = this.param;
            onUnitButtonClick(keyboardParam2, keyboardParam2.getUnitSiList().get(1));
            this.unitClick = true;
        } else if (id == R.id.btn_unit3) {
            this.param.getUnitSiList().get(2);
            KeyboardParam keyboardParam3 = this.param;
            onUnitButtonClick(keyboardParam3, keyboardParam3.getUnitSiList().get(2));
            this.unitClick = true;
        } else if (id == R.id.btn_unit4) {
            this.param.getUnitSiList().get(3);
            KeyboardParam keyboardParam4 = this.param;
            onUnitButtonClick(keyboardParam4, keyboardParam4.getUnitSiList().get(3));
            this.unitClick = true;
        } else if (id == R.id.btn_unit5) {
            this.param.getUnitSiList().get(4);
            KeyboardParam keyboardParam5 = this.param;
            onUnitButtonClick(keyboardParam5, keyboardParam5.getUnitSiList().get(4));
            this.unitClick = true;
        }
    }

    private void onUnitButtonClick(KeyboardParam keyboardParam, UnitFormat.SI si) {
        String obj = this.binding.edtValue.getText().toString();
        double number = getNumber(obj);
        if (si != null) {
            this.minUnitValue = (long) keyboardParam.getValue(number, si);
            onButtonClickEnd(obj);
        }
    }

    private void decimalPointMethod(int i, int i2) {
        if (this.unitType == ServiceEnum.Unit.Unit_ip) {
            if (this.editable.toString().length() - this.editable.toString().replace(".", "").trim().length() <= 3) {
                this.editable.insert(i2, this.binding.btnDecimalPoint.getText());
            } else {
                ToastUtils.showShort(this.context.getResources().getString(R.string.err_invalid_input));
            }
        } else if ("".equalsIgnoreCase(this.editable.toString())) {
            Editable editable = this.editable;
            editable.insert(i, "0" + ((Object) this.binding.btnDecimalPoint.getText()));
            this.binding.edtValue.getSelectionEnd();
        } else if (this.editable.toString().contains(".") || this.editable.toString().contains("e")) {
        } else {
            this.editable.insert(i2, this.binding.btnDecimalPoint.getText());
        }
    }

    private void btnclickOk() {
        if (!this.unitClick) {
            String obj = this.binding.edtValue.getText().toString();
            if (!"".equalsIgnoreCase(obj) && obj.contains("e")) {
                String[] split = obj.split("e");
                int parseInt = split.length > 1 ? Integer.parseInt(split[1]) + 0 : 0;
                try {
                    split[0] = split[0].replaceAll("[a-zA-Z]", "").trim();
                    this.minUnitValue = (long) (Double.parseDouble(split[0]) * Math.pow(10.0d, parseInt));
                } catch (NumberFormatException e) {
                    Timber.e("数字转换异常：%s", e.getMessage());
                    e.printStackTrace();
                }
            } else if (!"".equalsIgnoreCase(obj) && !obj.contains("e")) {
                try {
                    obj = obj.replaceAll("[a-zA-Z]", "").trim();
                    this.minUnitValue = (long) (Double.parseDouble(obj) * Math.pow(10.0d, 0));
                } catch (NumberFormatException e2) {
                    Timber.e("数字转换异常：%s", e2.getMessage());
                    e2.printStackTrace();
                }
            }
            if (this.mKeyboardListener != null) {
                if (this.unitType == ServiceEnum.Unit.Unit_ip) {
                    if (ViewUtil.checkIp(obj)) {
                        this.mKeyboardListener.resultMinUnitValueListener(obj);
                        dismiss();
                        this.binding.edtValue.setText("");
                        return;
                    }
                    ToastUtils.showShort(this.context.getResources().getString(R.string.err_invalid_input));
                    return;
                }
                long j = this.minUnitValue;
                if (j < this.minValue) {
                    ToastUtils.showShort(this.context.getResources().getString(R.string.err_over_low_range));
                    this.mKeyboardListener.resultMinUnitValueListener(Long.valueOf(this.minValue));
                } else if (j > this.maxValue) {
                    ToastUtils.showShort(this.context.getResources().getString(R.string.err_over_upper_range));
                    this.mKeyboardListener.resultMinUnitValueListener(Long.valueOf(this.maxValue));
                } else {
                    KeyboardListener keyboardListener = this.mKeyboardListener;
                    if (keyboardListener != null) {
                        keyboardListener.resultMinUnitValueListener(Long.valueOf(j));
                    }
                }
                dismiss();
                this.binding.edtValue.setText("");
            }
        } else if (this.unitType == ServiceEnum.Unit.Unit_ip) {
            String obj2 = this.binding.edtValue.getText().toString();
            if (ViewUtil.checkIp(obj2)) {
                this.mKeyboardListener.resultMinUnitValueListener(obj2);
                dismiss();
                this.binding.edtValue.setText("");
                return;
            }
            ToastUtils.showShort(this.context.getResources().getString(R.string.err_invalid_input));
        } else {
            this.mKeyboardListener.resultMinUnitValueListener(Long.valueOf(this.minUnitValue));
            dismiss();
            this.binding.edtValue.setText("");
        }
    }

    private void btnUnitClick(String str) {
        int i;
        int i2;
        String obj;
        if (!TextUtils.isEmpty(str)) {
            String substring = str.substring(0, 1);
            if (substring.matches("[PTGMkmμnpf]")) {
                Timber.d("unitPrefix:%s", substring);
                i = UnitFormat.SI.get(substring).scale * 3;
                i2 = i - (this.param.getBaseSi().scale * 3);
                obj = this.binding.edtValue.getText().toString();
                if ("".equalsIgnoreCase(obj) && obj.contains("e")) {
                    String[] split = obj.split("e");
                    if (split.length > 1) {
                        i2 += Integer.parseInt(split[1]);
                    }
                    try {
                        split[0] = split[0].replaceAll("[a-zA-Z]", "").trim();
                        this.minUnitValue = (long) (Double.parseDouble(split[0]) * Math.pow(10.0d, i2));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                } else if (!"".equalsIgnoreCase(obj) && !obj.contains("e")) {
                    try {
                        obj = obj.replaceAll("[a-zA-Zμ%*/]", "").trim();
                        this.minUnitValue = (long) (Double.parseDouble(obj) * Math.pow(10.0d, i2));
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                onButtonClickEnd(obj);
            }
        }
        i = 0;
        i2 = i - (this.param.getBaseSi().scale * 3);
        obj = this.binding.edtValue.getText().toString();
        if ("".equalsIgnoreCase(obj)) {
        }
        if (!"".equalsIgnoreCase(obj)) {
            obj = obj.replaceAll("[a-zA-Zμ%*/]", "").trim();
            this.minUnitValue = (long) (Double.parseDouble(obj) * Math.pow(10.0d, i2));
        }
        onButtonClickEnd(obj);
    }

    private void onButtonClickEnd(String str) {
        if (this.mKeyboardListener != null) {
            if (this.unitType == ServiceEnum.Unit.Unit_ip) {
                if (ViewUtil.checkIp(str)) {
                    this.mKeyboardListener.resultMinUnitValueListener(str);
                    dismiss();
                    this.binding.edtValue.setText("");
                    return;
                }
                ToastUtils.showShort(this.context.getResources().getString(R.string.err_invalid_input));
                return;
            }
            long j = this.minUnitValue;
            long j2 = this.minValue;
            if (j < j2) {
                if (!this.minBtnClick) {
                    ToastUtils.showShort(this.context.getResources().getString(R.string.err_over_low_range));
                }
                this.mKeyboardListener.resultMinUnitValueListener(Long.valueOf(this.minValue));
            } else {
                long j3 = this.maxValue;
                if (j > j3) {
                    if (!this.maxBtnClick) {
                        ToastUtils.showShort(this.context.getResources().getString(R.string.err_over_upper_range));
                    }
                    this.mKeyboardListener.resultMinUnitValueListener(Long.valueOf(this.maxValue));
                } else if (this.minBtnClick) {
                    this.mKeyboardListener.resultMinUnitValueListener(Long.valueOf(j2));
                } else if (this.maxBtnClick) {
                    this.mKeyboardListener.resultMinUnitValueListener(Long.valueOf(j3));
                } else {
                    this.mKeyboardListener.resultMinUnitValueListener(Long.valueOf(j));
                }
            }
            dismiss();
            this.binding.edtValue.setText("");
        }
    }

    private double getNumber(String str) {
        if (!"".equalsIgnoreCase(str) && str.contains("e")) {
            String[] split = str.split("e");
            if (split.length > 1) {
                return Double.parseDouble(split[0]) * Math.pow(10.0d, Integer.parseInt(split[1]));
            }
        }
        try {
            String trim = str.replaceAll("[a-zA-Z]", "").trim();
            if (trim.contains("%")) {
                trim = trim.replace("%", "");
            }
            if (trim.contains("μ")) {
                trim = trim.replace("μ", "");
            }
            return Double.parseDouble(trim);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.0d;
        }
    }

    private void btnClickNum(Button button) {
        if (!this.binding.edtValue.getText().toString().equals("") && this.editTextSelectAll) {
            this.binding.edtValue.setText("");
            this.editable = this.binding.edtValue.getText();
            this.editTextSelectAll = false;
        }
        if (this.unitType != ServiceEnum.Unit.Unit_ip && isContainUnit() && this.binding.edtValue.getSelectionEnd() == this.binding.edtValue.getText().length() && !this.binding.edtValue.getText().toString().equals("")) {
            this.binding.edtValue.setText("");
            this.editTextSelectAll = false;
        }
        if (this.binding.edtValue.getText().toString().length() < this.inputMaxLength) {
            this.editable.insert(this.binding.edtValue.getSelectionStart(), button.getText());
            this.editTextSelectAll = false;
            return;
        }
        ToastUtils.showShort(this.context.getResources().getString(R.string.err_ime_length_over));
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private String IPDefaultValues;
        private String IPMaxValues;
        private String IPMinValues;
        private long defaultValue;
        private long editTextDefaultValue;
        private final int inputMaxLength = 16;
        private String ipEditTextDefaultValue;
        private KeyboardListener keyboardListener;
        private long maxValue;
        private long minValue;
        private final ServiceEnum.Unit unitType;

        public Builder(ServiceEnum.Unit unit, long j, long j2, long j3) {
            this.unitType = unit;
            this.maxValue = j;
            this.minValue = j2;
            this.defaultValue = j3;
        }

        public Builder(ServiceEnum.Unit unit, long j, long j2, long j3, long j4) {
            this.unitType = unit;
            this.maxValue = j;
            this.minValue = j2;
            this.defaultValue = j3;
            this.editTextDefaultValue = j4;
        }

        public Builder(ServiceEnum.Unit unit, String str, String str2, String str3, String str4) {
            this.unitType = unit;
            this.IPMaxValues = str;
            this.IPMinValues = str2;
            this.IPDefaultValues = str3;
            this.ipEditTextDefaultValue = str4;
        }

        public Builder setKeyboardListener(KeyboardListener keyboardListener) {
            this.keyboardListener = keyboardListener;
            return this;
        }

        public KeyboardPopupView build() {
            return new KeyboardPopupView(this);
        }
    }

    public boolean isContainUnit() {
        String obj = this.binding.edtValue.getText().toString();
        String charSequence = this.binding.btnUnit1.getText().toString();
        String charSequence2 = this.binding.btnUnit2.getText().toString();
        String charSequence3 = this.binding.btnUnit3.getText().toString();
        String charSequence4 = this.binding.btnUnit4.getText().toString();
        String charSequence5 = this.binding.btnUnit5.getText().toString();
        if (obj.replace(".", "").matches("[0-9]+")) {
            return false;
        }
        if (!obj.contains(charSequence) || charSequence.equals("")) {
            if (!obj.contains(charSequence2) || charSequence2.equals("")) {
                if (!obj.contains(charSequence3) || charSequence3.equals("")) {
                    if (!obj.contains(charSequence4) || charSequence4.equals("")) {
                        return obj.contains(charSequence5) && !charSequence5.equals("");
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        super.onDismiss();
        if (this.refView != null) {
            this.refView.removeOnAttachStateChangeListener(this.onAttachStateChangeListener);
        }
        this.viewStateViewModel.getViewState().setValue(1);
    }

    public PopupviewKeyboardBinding getBinding() {
        return this.binding;
    }

    public List<View> getUnitButtons() {
        return this.unitButtons;
    }
}
