package com.rigol.scope.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.pinyinkeyboard.CandiateViewAdapter;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.pinyinkeyboard.PinyinIme;
import com.rigol.pinyinkeyboard.TypeWritingInterface;
import com.rigol.pinyinkeyboard.TypeWritingUtils;
import com.rigol.scope.R;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.util.ToastUtils;
import java.io.IOException;

/* loaded from: classes2.dex */
public class TypeWritingPop extends BasePopupView implements View.OnClickListener {
    private static EditText edInputMessage;
    private AssetManager assetManager;
    private boolean bCaps;
    private boolean bNums;
    private Button btn1;
    private Button btn10;
    private Button btn11;
    private Button btn12;
    private Button btn13;
    private Button btn14;
    private Button btn15;
    private Button btn16;
    private Button btn17;
    private Button btn18;
    private Button btn19;
    private Button btn2;
    private Button btn20;
    private Button btn21;
    private Button btn22;
    private Button btn23;
    private Button btn24;
    private Button btn25;
    private Button btn26;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private ImageButton btnBack;
    private Button btnCaps;
    private Button btnNumSwitch;
    private Button btnOk;
    private Button btnPoint;
    private Button btnSpace;
    private Button btnSwitch;
    private RecyclerView candiateMsgRecView;
    private AssetFileDescriptor fileDescriptor;
    private int inputMaxLength;
    private long length;
    private Activity mActivity;
    private CandiateViewAdapter mCandiateViewAdapter;
    private final Context mContext;
    private ExternalInterface mExternalInterface;
    private TypeWritingUtils.TKeyBoardTypeEnum mKeyBoardTypeEnum;
    private TypeWritingUtils.TKeyboardInputModeEnum mKeyboardInputModeEnum;
    private LinearLayoutManager mLinearLayoutManager;
    private TypeWritingInterface mTypeWritingInterface;
    private long startOffset;
    private String strInputText;
    private int sysFd;
    private TextView tvTypeMessage;
    private int typeMaxLength;

    public static TypeWritingPop create(Context context, Activity activity, String str) {
        return new TypeWritingPop(context, activity, str);
    }

    private TypeWritingPop(Context context, Activity activity, String str) {
        super((int) R.style.App_PopupWindow_PinKeyboard);
        this.bCaps = false;
        this.bNums = false;
        this.mTypeWritingInterface = new TypeWritingInterface() { // from class: com.rigol.scope.views.TypeWritingPop.1
            @Override // com.rigol.pinyinkeyboard.TypeWritingInterface
            public void updateInputMessage(String str2) {
                int length = TypeWritingPop.edInputMessage.getText().toString().length();
                if (str2.length() + length <= TypeWritingPop.this.inputMaxLength) {
                    TypeWritingPop.edInputMessage.getText().insert(TypeWritingPop.edInputMessage.getSelectionStart(), str2);
                    TypeWritingPop.this.tvTypeMessage.setText("");
                    TypeWritingPop typeWritingPop = TypeWritingPop.this;
                    typeWritingPop.updateDicShow(typeWritingPop.tvTypeMessage.getText().toString());
                } else if (length >= TypeWritingPop.this.inputMaxLength || str2.length() + length <= TypeWritingPop.this.inputMaxLength) {
                    ToastUtils.showShort(TypeWritingPop.this.context.getResources().getString(R.string.err_ime_length_over));
                    Log.d("kbd", "输入超出长度");
                } else {
                    TypeWritingPop.edInputMessage.getText().insert(TypeWritingPop.edInputMessage.getSelectionStart(), str2.substring(0, TypeWritingPop.this.inputMaxLength - length));
                    TypeWritingPop.this.tvTypeMessage.setText("");
                    TypeWritingPop typeWritingPop2 = TypeWritingPop.this;
                    typeWritingPop2.updateDicShow(typeWritingPop2.tvTypeMessage.getText().toString());
                }
            }
        };
        this.mKeyboardInputModeEnum = TypeWritingUtils.TKeyboardInputModeEnum.GRAPH;
        this.mKeyBoardTypeEnum = TypeWritingUtils.TKeyBoardTypeEnum.ENGLISH;
        this.inputMaxLength = 26;
        this.typeMaxLength = 16;
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ce_keyboard, (ViewGroup) null);
        setContentView(inflate);
        this.mActivity = activity;
        this.strInputText = str;
        findView(inflate);
        setFocusable(false);
        this.inputMaxLength = 64;
        setEnglishButtonMessage(this.bCaps);
        edInputMessage.setText(str);
        EditText editText = edInputMessage;
        editText.setSelection(editText.getText().toString().length());
        configure();
    }

    public TypeWritingPop setTypeWritingListener(ExternalInterface externalInterface) {
        this.mExternalInterface = externalInterface;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_1) {
            btnClickKey(this.btn1);
        } else if (id == R.id.btn_2) {
            btnClickKey(this.btn2);
        } else if (id == R.id.btn_3) {
            btnClickKey(this.btn3);
        } else if (id == R.id.btn_4) {
            btnClickKey(this.btn4);
        } else if (id == R.id.btn_5) {
            btnClickKey(this.btn5);
        } else if (id == R.id.btn_6) {
            btnClickKey(this.btn6);
        } else if (id == R.id.btn_7) {
            btnClickKey(this.btn7);
        } else if (id == R.id.btn_8) {
            btnClickKey(this.btn8);
        } else if (id == R.id.btn_9) {
            btnClickKey(this.btn9);
        } else if (id == R.id.btn_10) {
            btnClickKey(this.btn10);
        } else if (id == R.id.btn_11) {
            btnClickKey(this.btn11);
        } else if (id == R.id.btn_12) {
            btnClickKey(this.btn12);
        } else if (id == R.id.btn_13) {
            btnClickKey(this.btn13);
        } else if (id == R.id.btn_14) {
            btnClickKey(this.btn14);
        } else if (id == R.id.btn_15) {
            btnClickKey(this.btn15);
        } else if (id == R.id.btn_16) {
            btnClickKey(this.btn16);
        } else if (id == R.id.btn_17) {
            btnClickKey(this.btn17);
        } else if (id == R.id.btn_18) {
            btnClickKey(this.btn18);
        } else if (id == R.id.btn_19) {
            btnClickKey(this.btn19);
        } else if (id == R.id.btn_20) {
            btnClickKey(this.btn20);
        } else if (id == R.id.btn_21) {
            btnClickKey(this.btn21);
        } else if (id == R.id.btn_22) {
            btnClickKey(this.btn22);
        } else if (id == R.id.btn_23) {
            btnClickKey(this.btn23);
        } else if (id == R.id.btn_24) {
            btnClickKey(this.btn24);
        } else if (id == R.id.btn_25) {
            btnClickKey(this.btn25);
        } else if (id == R.id.btn_26) {
            btnClickKey(this.btn26);
        } else if (id == R.id.btn_caps) {
            if (TypeWritingUtils.TKeyboardInputModeEnum.GRAPH == this.mKeyboardInputModeEnum && TypeWritingUtils.TKeyBoardTypeEnum.ENGLISH == this.mKeyBoardTypeEnum) {
                if (true == this.bCaps) {
                    this.bCaps = false;
                } else {
                    this.bCaps = true;
                }
                setEnglishButtonMessage(this.bCaps);
            }
        } else if (id == R.id.btn_language_switch) {
            if (TypeWritingUtils.TKeyboardInputModeEnum.GRAPH == this.mKeyboardInputModeEnum) {
                if (TypeWritingUtils.TKeyBoardTypeEnum.ENGLISH == this.mKeyBoardTypeEnum) {
                    this.mKeyBoardTypeEnum = TypeWritingUtils.TKeyBoardTypeEnum.SIMPLIFY_CHINESE;
                    this.bCaps = false;
                    setEnglishButtonMessage(false);
                    this.btnCaps.setBackground(this.mContext.getResources().getDrawable(R.drawable.func_no_select, null));
                    this.btnSwitch.setText("中/En");
                    return;
                } else if (TypeWritingUtils.TKeyBoardTypeEnum.SIMPLIFY_CHINESE == this.mKeyBoardTypeEnum) {
                    this.mKeyBoardTypeEnum = TypeWritingUtils.TKeyBoardTypeEnum.ENGLISH;
                    this.btnSwitch.setText("En/中");
                    this.btnCaps.setBackground(this.mContext.getResources().getDrawable(R.drawable.func_bg_normal, null));
                    return;
                } else {
                    return;
                }
            }
            this.bNums = false;
            this.mKeyboardInputModeEnum = TypeWritingUtils.TKeyboardInputModeEnum.GRAPH;
            setNumButtonMessage(this.bNums);
            if (TypeWritingUtils.TKeyBoardTypeEnum.ENGLISH == this.mKeyBoardTypeEnum) {
                this.mKeyBoardTypeEnum = TypeWritingUtils.TKeyBoardTypeEnum.SIMPLIFY_CHINESE;
                this.btnSwitch.setText("中/En");
            } else if (TypeWritingUtils.TKeyBoardTypeEnum.SIMPLIFY_CHINESE == this.mKeyBoardTypeEnum) {
                this.mKeyBoardTypeEnum = TypeWritingUtils.TKeyBoardTypeEnum.ENGLISH;
                this.btnSwitch.setText("En/中");
            }
            this.bCaps = false;
            setEnglishButtonMessage(false);
            this.btnCaps.setBackground(this.mContext.getResources().getDrawable(R.drawable.func_bg_normal, null));
        } else if (id != R.id.btn_back) {
            if (id == R.id.btn_num_switch) {
                if (true == this.bNums) {
                    this.bNums = false;
                    this.mKeyboardInputModeEnum = TypeWritingUtils.TKeyboardInputModeEnum.GRAPH;
                } else {
                    this.bNums = true;
                    this.mKeyboardInputModeEnum = TypeWritingUtils.TKeyboardInputModeEnum.NUMBER;
                }
                setNumButtonMessage(this.bNums);
            } else if (id == R.id.btn_space) {
                if (edInputMessage.getText().toString().length() < this.inputMaxLength) {
                    edInputMessage.getText().insert(edInputMessage.getSelectionStart(), " ");
                    return;
                }
                ToastUtils.showShort(this.context.getResources().getString(R.string.err_ime_length_over));
                Log.d("kbd", "输入超出长度");
            } else if (id != R.id.btn_point) {
                if (id == R.id.btn_ok) {
                    this.mExternalInterface.resultShow(edInputMessage.getText().toString());
                    dismiss();
                }
            } else if (edInputMessage.getText().toString().length() < this.inputMaxLength) {
                edInputMessage.getText().insert(edInputMessage.getSelectionStart(), this.btnPoint.getText().toString());
            } else {
                ToastUtils.showShort(this.context.getResources().getString(R.string.err_ime_length_over));
                Log.d("kbd", "输入超出长度");
            }
        } else if (TypeWritingUtils.TKeyboardInputModeEnum.GRAPH == this.mKeyboardInputModeEnum) {
            if (TypeWritingUtils.TKeyBoardTypeEnum.ENGLISH == this.mKeyBoardTypeEnum) {
                if (edInputMessage.getText() == null || edInputMessage.getText().length() <= 0) {
                    return;
                }
                int selectionStart = edInputMessage.getSelectionStart();
                int selectionEnd = edInputMessage.getSelectionEnd();
                if (selectionStart == selectionEnd && selectionStart != 0) {
                    edInputMessage.getText().delete(selectionStart - 1, selectionStart);
                } else {
                    edInputMessage.getText().delete(selectionStart, selectionEnd);
                }
            } else if (TypeWritingUtils.TKeyBoardTypeEnum.SIMPLIFY_CHINESE == this.mKeyBoardTypeEnum) {
                String charSequence = this.tvTypeMessage.getText().toString();
                String obj = edInputMessage.getText().toString();
                if (charSequence.equals("")) {
                    if (!obj.equals("")) {
                        edInputMessage.setText(obj.substring(0, edInputMessage.length() - 1));
                    }
                    EditText editText = edInputMessage;
                    editText.setSelection(editText.getText().toString().length());
                } else {
                    charSequence = charSequence.substring(0, charSequence.length() - 1);
                    this.tvTypeMessage.setText(charSequence);
                }
                updateDicShow(charSequence);
            }
        } else if (edInputMessage.getText() == null || edInputMessage.getText().length() <= 0) {
        } else {
            int selectionStart2 = edInputMessage.getSelectionStart();
            int selectionEnd2 = edInputMessage.getSelectionEnd();
            if (selectionStart2 == selectionEnd2 && selectionStart2 != 0) {
                edInputMessage.getText().delete(selectionStart2 - 1, selectionStart2);
            } else {
                edInputMessage.getText().delete(selectionStart2, selectionEnd2);
            }
        }
    }

    private void btnClickKey(Button button) {
        if (TypeWritingUtils.TKeyboardInputModeEnum.GRAPH == this.mKeyboardInputModeEnum) {
            if (TypeWritingUtils.TKeyBoardTypeEnum.ENGLISH == this.mKeyBoardTypeEnum) {
                if (edInputMessage.getText().toString().length() < this.inputMaxLength) {
                    edInputMessage.getText().insert(edInputMessage.getSelectionStart(), button.getText());
                    return;
                }
                ToastUtils.showShort(this.context.getResources().getString(R.string.err_ime_length_over));
                Log.d("kbd", "输入超出长度");
            } else if (TypeWritingUtils.TKeyBoardTypeEnum.SIMPLIFY_CHINESE == this.mKeyBoardTypeEnum) {
                if (this.tvTypeMessage.getText().toString().length() < this.typeMaxLength) {
                    String charSequence = this.tvTypeMessage.getText().toString();
                    TextView textView = this.tvTypeMessage;
                    textView.setText(charSequence + button.getText().toString());
                    updateDicShow(this.tvTypeMessage.getText().toString());
                    return;
                }
                ToastUtils.showShort(this.context.getResources().getString(R.string.err_ime_length_over));
                Log.d("kbd", "输入超出长度");
            } else {
                TypeWritingUtils.TKeyBoardTypeEnum tKeyBoardTypeEnum = TypeWritingUtils.TKeyBoardTypeEnum.CHINESE;
                TypeWritingUtils.TKeyBoardTypeEnum tKeyBoardTypeEnum2 = this.mKeyBoardTypeEnum;
            }
        } else if (edInputMessage.getText().toString().length() < this.inputMaxLength) {
            edInputMessage.getText().insert(edInputMessage.getSelectionStart(), button.getText());
        } else {
            ToastUtils.showShort(this.context.getResources().getString(R.string.err_ime_length_over));
            Log.d("kbd", "输入超出长度");
        }
    }

    private void configure() {
        AssetManager assets = this.mContext.getAssets();
        this.assetManager = assets;
        try {
            AssetFileDescriptor openFd = assets.openFd("raw/dict_pinyin.dat");
            this.fileDescriptor = openFd;
            this.startOffset = openFd.getStartOffset();
            this.length = this.fileDescriptor.getLength();
            this.sysFd = this.fileDescriptor.getParcelFileDescriptor().detachFd();
            this.fileDescriptor.close();
        } catch (IOException e) {
            Log.e("sss", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDicShow(String str) {
        PinyinIme.openDecoderFromAssets("raw/dict_pinyin.dat", this.mContext);
        PinyinIme.enableShmAsSzm(true);
        PinyinIme.resetSearch();
        String[] searchAll = PinyinIme.searchAll(str);
        if (searchAll == null) {
            Log.d("kdb", "error");
            searchAll = new String[]{""};
        }
        updateCandiateView(searchAll);
    }

    private void updateCandiateView(String[] strArr) {
        CandiateViewAdapter candiateViewAdapter = new CandiateViewAdapter(this.mContext, strArr, this.mTypeWritingInterface);
        this.mCandiateViewAdapter = candiateViewAdapter;
        this.candiateMsgRecView.setAdapter(candiateViewAdapter);
    }

    private void findView(View view) {
        if (view == null) {
            return;
        }
        this.btn1 = (Button) view.findViewById(R.id.btn_1);
        this.btn2 = (Button) view.findViewById(R.id.btn_2);
        this.btn3 = (Button) view.findViewById(R.id.btn_3);
        this.btn4 = (Button) view.findViewById(R.id.btn_4);
        this.btn5 = (Button) view.findViewById(R.id.btn_5);
        this.btn6 = (Button) view.findViewById(R.id.btn_6);
        this.btn7 = (Button) view.findViewById(R.id.btn_7);
        this.btn8 = (Button) view.findViewById(R.id.btn_8);
        this.btn9 = (Button) view.findViewById(R.id.btn_9);
        this.btn10 = (Button) view.findViewById(R.id.btn_10);
        this.btn11 = (Button) view.findViewById(R.id.btn_11);
        this.btn12 = (Button) view.findViewById(R.id.btn_12);
        this.btn13 = (Button) view.findViewById(R.id.btn_13);
        this.btn14 = (Button) view.findViewById(R.id.btn_14);
        this.btn15 = (Button) view.findViewById(R.id.btn_15);
        this.btn16 = (Button) view.findViewById(R.id.btn_16);
        this.btn17 = (Button) view.findViewById(R.id.btn_17);
        this.btn18 = (Button) view.findViewById(R.id.btn_18);
        this.btn19 = (Button) view.findViewById(R.id.btn_19);
        this.btn20 = (Button) view.findViewById(R.id.btn_20);
        this.btn21 = (Button) view.findViewById(R.id.btn_21);
        this.btn22 = (Button) view.findViewById(R.id.btn_22);
        this.btn23 = (Button) view.findViewById(R.id.btn_23);
        this.btn24 = (Button) view.findViewById(R.id.btn_24);
        this.btn25 = (Button) view.findViewById(R.id.btn_25);
        this.btn26 = (Button) view.findViewById(R.id.btn_26);
        this.btn1.setClickable(true);
        this.btnBack = (ImageButton) view.findViewById(R.id.btn_back);
        this.btnCaps = (Button) view.findViewById(R.id.btn_caps);
        this.btnSwitch = (Button) view.findViewById(R.id.btn_language_switch);
        this.btnNumSwitch = (Button) view.findViewById(R.id.btn_num_switch);
        this.btnSpace = (Button) view.findViewById(R.id.btn_space);
        this.btnPoint = (Button) view.findViewById(R.id.btn_point);
        this.btnOk = (Button) view.findViewById(R.id.btn_ok);
        ((TextView) view.findViewById(R.id.title)).setText(R.string.msg_app_keyboard);
        View findViewById = view.findViewById(R.id.close);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.-$$Lambda$TypeWritingPop$VCK8JA24Eg6KHaZCzV3sa96LfAU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TypeWritingPop.this.lambda$findView$0$TypeWritingPop(view2);
                }
            });
        }
        this.btn1.setOnClickListener(this);
        this.btn2.setOnClickListener(this);
        this.btn3.setOnClickListener(this);
        this.btn4.setOnClickListener(this);
        this.btn5.setOnClickListener(this);
        this.btn6.setOnClickListener(this);
        this.btn7.setOnClickListener(this);
        this.btn8.setOnClickListener(this);
        this.btn9.setOnClickListener(this);
        this.btn10.setOnClickListener(this);
        this.btn11.setOnClickListener(this);
        this.btn12.setOnClickListener(this);
        this.btn13.setOnClickListener(this);
        this.btn14.setOnClickListener(this);
        this.btn15.setOnClickListener(this);
        this.btn16.setOnClickListener(this);
        this.btn17.setOnClickListener(this);
        this.btn18.setOnClickListener(this);
        this.btn19.setOnClickListener(this);
        this.btn20.setOnClickListener(this);
        this.btn21.setOnClickListener(this);
        this.btn22.setOnClickListener(this);
        this.btn23.setOnClickListener(this);
        this.btn24.setOnClickListener(this);
        this.btn25.setOnClickListener(this);
        this.btn26.setOnClickListener(this);
        this.btnBack.setOnClickListener(this);
        this.btnCaps.setOnClickListener(this);
        this.btnSwitch.setOnClickListener(this);
        this.btnNumSwitch.setOnClickListener(this);
        this.btnSpace.setOnClickListener(this);
        this.btnPoint.setOnClickListener(this);
        this.btnOk.setOnClickListener(this);
        edInputMessage = (EditText) view.findViewById(R.id.ed_message);
        this.tvTypeMessage = (TextView) view.findViewById(R.id.tv_type_in);
        this.candiateMsgRecView = (RecyclerView) view.findViewById(R.id.candidate_rec_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        this.mLinearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.candiateMsgRecView.setLayoutManager(this.mLinearLayoutManager);
        TypeWritingUtils.hideSystemSoftware(this.mActivity, edInputMessage);
        EditText editText = edInputMessage;
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.rigol.scope.views.TypeWritingPop.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TextUtils.isEmpty(editable)) {
                        if (TypeWritingPop.this.btnOk != null) {
                            TypeWritingPop.this.btnOk.setAlpha(ContextUtil.getAlpha(false));
                            TypeWritingPop.this.btnOk.setEnabled(false);
                        }
                    } else if (TypeWritingPop.this.btnOk != null) {
                        TypeWritingPop.this.btnOk.setAlpha(ContextUtil.getAlpha(true));
                        TypeWritingPop.this.btnOk.setEnabled(true);
                    }
                }
            });
        }
    }

    public /* synthetic */ void lambda$findView$0$TypeWritingPop(View view) {
        dismiss();
    }

    private void setEnglishButtonMessage(boolean z) {
        if (z) {
            this.btn1.setText(R.string.Q);
            this.btn2.setText(R.string.W);
            this.btn3.setText(R.string.E);
            this.btn4.setText(R.string.R);
            this.btn5.setText(R.string.T);
            this.btn6.setText(R.string.Y);
            this.btn7.setText(R.string.U);
            this.btn8.setText(R.string.I);
            this.btn9.setText(R.string.O);
            this.btn10.setText(R.string.P);
            this.btn11.setText(R.string.A);
            this.btn12.setText(R.string.S);
            this.btn13.setText(R.string.D);
            this.btn14.setText(R.string.F);
            this.btn15.setText(R.string.G);
            this.btn16.setText(R.string.H);
            this.btn17.setText(R.string.J);
            this.btn18.setText(R.string.K);
            this.btn19.setText(R.string.L);
            this.btn20.setText(R.string.Z);
            this.btn21.setText(R.string.X);
            this.btn22.setText(R.string.C);
            this.btn23.setText(R.string.V);
            this.btn24.setText(R.string.B);
            this.btn25.setText(R.string.N);
            this.btn26.setText(R.string.M);
            this.btnCaps.setBackground(this.mContext.getResources().getDrawable(R.drawable.func_bg_selected, null));
        } else {
            this.btn1.setText(R.string.q);
            this.btn2.setText(R.string.w);
            this.btn3.setText(R.string.e);
            this.btn4.setText(R.string.r);
            this.btn5.setText(R.string.t);
            this.btn6.setText(R.string.y);
            this.btn7.setText(R.string.u);
            this.btn8.setText(R.string.i);
            this.btn9.setText(R.string.o);
            this.btn10.setText(R.string.p);
            this.btn11.setText(R.string.a);
            this.btn12.setText(R.string.s);
            this.btn13.setText(R.string.d);
            this.btn14.setText(R.string.f);
            this.btn15.setText(R.string.g);
            this.btn16.setText(R.string.h);
            this.btn17.setText(R.string.j);
            this.btn18.setText(R.string.k);
            this.btn19.setText(R.string.l);
            this.btn20.setText(R.string.z);
            this.btn21.setText(R.string.x);
            this.btn22.setText(R.string.c);
            this.btn23.setText(R.string.v);
            this.btn24.setText(R.string.b);
            this.btn25.setText(R.string.n);
            this.btn26.setText(R.string.m);
            if (TypeWritingUtils.TKeyBoardTypeEnum.SIMPLIFY_CHINESE == this.mKeyBoardTypeEnum) {
                this.btnCaps.setBackground(this.mContext.getResources().getDrawable(R.drawable.func_no_select, null));
            } else {
                this.btnCaps.setBackground(this.mContext.getResources().getDrawable(R.drawable.func_bg_normal, null));
            }
        }
        this.btnNumSwitch.setText("?123");
    }

    private void setNumButtonMessage(boolean z) {
        if (z) {
            this.btn1.setText(R.string.one);
            this.btn2.setText(R.string.two);
            this.btn3.setText(R.string.three);
            this.btn4.setText(R.string.four);
            this.btn5.setText(R.string.five);
            this.btn6.setText(R.string.six);
            this.btn7.setText(R.string.seven);
            this.btn8.setText(R.string.eight);
            this.btn9.setText(R.string.nine);
            this.btn10.setText(R.string.zero);
            this.btn11.setText(R.string.gantan);
            this.btn12.setText(R.string.appoint);
            this.btn13.setText(R.string.pound);
            this.btn14.setText(R.string.dollar);
            this.btn15.setText(R.string.percent);
            this.btn16.setText(R.string.leftbraces);
            this.btn17.setText(R.string.rightbraces);
            this.btn18.setText(R.string.underline);
            this.btn19.setText(R.string.xiegang);
            this.btn20.setText(R.string.leftbrackets);
            this.btn21.setText(R.string.rightbrackets);
            this.btn22.setText(R.string.colon);
            this.btn23.setText(R.string.mark);
            this.btn24.setText(R.string.comma);
            this.btn25.setText(R.string.div);
            this.btn26.setText(R.string.question);
            this.btnNumSwitch.setText("abc");
            this.btnCaps.setBackground(this.mContext.getResources().getDrawable(R.drawable.func_no_select, null));
            return;
        }
        setEnglishButtonMessage(this.bCaps);
        this.btnNumSwitch.setText("?123");
    }

    public static EditText getEditText() {
        return edInputMessage;
    }

    public void setEnglishKeyBoard() {
        this.mKeyBoardTypeEnum = TypeWritingUtils.TKeyBoardTypeEnum.ENGLISH;
        this.btnSwitch.setText("En/中");
        this.btnSwitch.setAlpha(ContextUtil.getAlpha(false));
        this.btnSwitch.setEnabled(false);
        this.btnSwitch.setVisibility(4);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        super.onDismiss();
        if (this.refView != null) {
            this.refView.removeOnAttachStateChangeListener(this.onAttachStateChangeListener);
        }
    }
}
