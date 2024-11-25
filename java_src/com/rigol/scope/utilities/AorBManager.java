package com.rigol.scope.utilities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.MutableLiveData;
import com.blankj.utilcode.util.LogUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.ChanSpinnerAdapter;
import com.rigol.scope.adapters.MultiItemTypeAdapter;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.KeyBean;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.PopupviewKeyboardBinding;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.ViewStateViewModel;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public abstract class AorBManager {
    Context context;
    List<AorBParam> list_aorbParam;
    OnTextReset onReset;
    OnSetTextById onSetTextById;
    OnSetTextByTriggerLevelRoll onSetTextByTriggerLevelRoll;
    PanelKeyViewModel panelKeyViewModel;
    TextView textA;
    TextView textB;
    ViewStateViewModel viewStateViewModel;
    public int aorBParam_a = 0;
    public int aorBParam_b = 1;
    int switch_num = 0;
    boolean is_switch = false;
    int MAX_SWITCH = 2;
    String chanString = "CH1";
    private Drawable keyBoardBgSelectedDrawable = null;
    private Drawable keyBoardBgUnSelectedDrawable = null;
    private Drawable keyDrawable1 = null;
    private Drawable keyDrawable2 = null;
    private SyncDataViewModel syncDataViewModel = null;
    private KeyEvent keyEvent = null;

    /* loaded from: classes2.dex */
    public interface OnAOrBManagerListener {
        void onCall(AorBManager aorBManager);
    }

    /* loaded from: classes2.dex */
    public interface OnKeyboardItemChangeListener {
        void onCall(KeyboardPopupView keyboardPopupView);
    }

    /* loaded from: classes2.dex */
    public interface OnNotifySubAdapterListener {
        void onCall();
    }

    /* loaded from: classes2.dex */
    public interface OnOutOrInAdapterClickChangeListener {
        void onChange(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface OnSetTextById {
        void onViewIdCallback(KeyEvent keyEvent, int i, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface OnSetTextByTriggerLevelRoll {
        void onTriggerLevelRollCallback(KeyEvent keyEvent, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface OnSpinnerAdapterListener {
        void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List<MappingObject> list, View view);
    }

    /* loaded from: classes2.dex */
    public interface OnSpinnerClickListener<T> {
        void onSpinnerClick(T t);
    }

    /* loaded from: classes2.dex */
    public interface OnSpinnerItemChangeListener {
        void onCall(int i, MappingObject mappingObject);
    }

    /* loaded from: classes2.dex */
    public interface OnTextReset {
        void onResetDefault(int i);
    }

    protected abstract void setSwitch_num(int i);

    protected abstract void setrecovery_num(int i);

    public AorBManager(Context context, List<AorBParam> list) {
        this.context = context;
        this.list_aorbParam = list;
    }

    public AorBManager(Context context, List<AorBParam> list, OnSetTextById onSetTextById, OnTextReset onTextReset) {
        if (this.panelKeyViewModel == null) {
            this.panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        }
        this.onSetTextById = onSetTextById;
        this.onReset = onTextReset;
        this.list_aorbParam = list;
        this.context = context;
    }

    public AorBManager(Context context, List<AorBParam> list, OnSetTextById onSetTextById, OnTextReset onTextReset, OnSetTextByTriggerLevelRoll onSetTextByTriggerLevelRoll) {
        if (this.panelKeyViewModel == null) {
            this.panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        }
        this.onSetTextById = onSetTextById;
        this.onReset = onTextReset;
        this.onSetTextByTriggerLevelRoll = onSetTextByTriggerLevelRoll;
        this.list_aorbParam = list;
        this.context = context;
    }

    public void initView() {
        if (this.keyDrawable1 == null) {
            this.keyDrawable1 = ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.ic_bg_key_1, null);
        }
        if (this.keyDrawable2 == null) {
            this.keyDrawable2 = ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.ic_bg_key_2, null);
        }
    }

    public List<AorBParam> getList_aorbParam() {
        List<AorBParam> list = this.list_aorbParam;
        return list == null ? new ArrayList() : list;
    }

    public void setList_aorbParam(List<AorBParam> list) {
        this.list_aorbParam = list;
    }

    public int getAorBParam_a() {
        return this.aorBParam_a;
    }

    public void setAorBParam_a(int i) {
        this.aorBParam_a = i;
    }

    public int getAorBParam_b() {
        return this.aorBParam_b;
    }

    public void setAorBParam_b(int i) {
        this.aorBParam_b = i;
    }

    public TextView getTextA() {
        return this.textA;
    }

    public void setTextA(TextView textView) {
        this.textA = textView;
    }

    public TextView getTextB() {
        return this.textB;
    }

    public void setTextB(TextView textView) {
        this.textB = textView;
    }

    public boolean setClick_showab(int i) {
        int i2;
        int i3;
        this.switch_num++;
        for (int i4 = 0; i4 < this.list_aorbParam.size(); i4++) {
            if (this.list_aorbParam.get(i4).getEditText() != null && this.list_aorbParam.get(i4).getEditText().getId() == i && i4 != (i2 = this.aorBParam_a) && i4 != (i3 = this.aorBParam_b)) {
                if (this.switch_num % 2 == 1) {
                    this.list_aorbParam.get(i2).setIs_show(false);
                    this.list_aorbParam.get(i4).setIs_show(true);
                    setrecovery_num(this.aorBParam_a);
                    this.list_aorbParam.get(i4).setAorb(ViewUtil.KEY_A);
                    setSwitch_num(i4);
                    this.aorBParam_a = i4;
                    setTextA(getView(this.list_aorbParam.get(i4)));
                } else {
                    this.list_aorbParam.get(i3).setIs_show(false);
                    this.list_aorbParam.get(i4).setIs_show(true);
                    setrecovery_num(this.aorBParam_b);
                    this.list_aorbParam.get(i4).setAorb(ViewUtil.KEY_B);
                    setSwitch_num(i4);
                    this.aorBParam_b = i4;
                    setTextB(getView(this.list_aorbParam.get(i4)));
                }
                return false;
            } else if (this.list_aorbParam.get(i4).getEditText() != null && this.list_aorbParam.get(i4).getEditText().getId() == i && this.list_aorbParam.get(i4).isIs_show()) {
                return true;
            }
        }
        return false;
    }

    private TextView getView(AorBParam aorBParam) {
        if (aorBParam == null) {
            return null;
        }
        if (aorBParam.getEditText() != null) {
            return aorBParam.getEditText();
        }
        if (aorBParam.getTextView() != null) {
            return aorBParam.getTextView();
        }
        return null;
    }

    public boolean setClick_showab_textview(int i) {
        int i2;
        int i3;
        this.switch_num++;
        for (int i4 = 0; i4 < this.list_aorbParam.size(); i4++) {
            if (this.list_aorbParam.get(i4).getTextView() != null && this.list_aorbParam.get(i4).getTextView().getId() == i && i4 != (i2 = this.aorBParam_a) && i4 != (i3 = this.aorBParam_b)) {
                if (this.switch_num % 2 == 1) {
                    this.list_aorbParam.get(i2).setIs_show(false);
                    this.list_aorbParam.get(i4).setIs_show(true);
                    setrecovery_num(this.aorBParam_a);
                    this.list_aorbParam.get(i4).setAorb(ViewUtil.KEY_A);
                    setSwitch_num(i4);
                    this.aorBParam_a = i4;
                    setTextA(getView(this.list_aorbParam.get(i4)));
                } else {
                    this.list_aorbParam.get(i3).setIs_show(false);
                    this.list_aorbParam.get(i4).setIs_show(true);
                    setrecovery_num(this.aorBParam_b);
                    this.list_aorbParam.get(i4).setAorb(ViewUtil.KEY_B);
                    setSwitch_num(i4);
                    this.aorBParam_b = i4;
                    setTextB(getView(this.list_aorbParam.get(i4)));
                }
                return false;
            } else if (this.list_aorbParam.get(i4).getTextView() != null && this.list_aorbParam.get(i4).getTextView().getId() == i && this.list_aorbParam.get(i4).isIs_show()) {
                return true;
            }
        }
        return false;
    }

    public void setClick_list(List<AorBParam> list) {
        this.list_aorbParam = list;
    }

    public void set_switch_show(int i) {
        if (this.list_aorbParam.get(this.aorBParam_a).getSup_id() == 1 || this.list_aorbParam.get(this.aorBParam_a).getSup_id() == 0) {
            this.list_aorbParam.get(this.aorBParam_a).setIs_show(false);
            setrecovery_num(this.aorBParam_a);
            this.list_aorbParam.get(0).setIs_show(true);
            this.list_aorbParam.get(0).setAorb(ViewUtil.KEY_A);
            setSwitch_num(0);
            this.aorBParam_a = 0;
        }
        if (this.list_aorbParam.get(this.aorBParam_b).getSup_id() == 1 || this.list_aorbParam.get(this.aorBParam_b).getSup_id() == 0) {
            int i2 = this.aorBParam_b;
            if (i2 != 0) {
                this.list_aorbParam.get(i2).setIs_show(false);
                setrecovery_num(this.aorBParam_b);
            }
            this.list_aorbParam.get(1).setIs_show(true);
            this.list_aorbParam.get(1).setAorb(ViewUtil.KEY_B);
            setSwitch_num(1);
            this.aorBParam_b = 1;
        }
    }

    public void set_RadioButton() {
        if (this.list_aorbParam.get(this.aorBParam_a).getSup_id() == 3) {
            this.list_aorbParam.get(this.aorBParam_a).setIs_show(false);
            this.list_aorbParam.get(0).setIs_show(true);
            setrecovery_num(this.aorBParam_a);
            this.list_aorbParam.get(0).setAorb(ViewUtil.KEY_A);
            setSwitch_num(0);
            this.aorBParam_a = 0;
        }
        if (this.list_aorbParam.get(this.aorBParam_b).getSup_id() == 3) {
            this.list_aorbParam.get(this.aorBParam_b).setIs_show(false);
            this.list_aorbParam.get(1).setIs_show(true);
            setrecovery_num(this.aorBParam_b);
            this.list_aorbParam.get(1).setAorb(ViewUtil.KEY_B);
            setSwitch_num(1);
            this.aorBParam_b = 1;
        }
    }

    public void set_RadioButton(int i, int i2) {
        if (this.list_aorbParam.get(i).getSup_id() == 3) {
            this.list_aorbParam.get(this.aorBParam_a).setIs_show(false);
            setrecovery_num(this.aorBParam_a);
            this.list_aorbParam.get(i).setIs_show(true);
            this.list_aorbParam.get(i).setAorb(ViewUtil.KEY_A);
            setSwitch_num(i);
            this.aorBParam_a = i;
        }
        if (this.list_aorbParam.get(i2).getSup_id() == 3) {
            this.list_aorbParam.get(this.aorBParam_b).setIs_show(false);
            setrecovery_num(this.aorBParam_b);
            this.list_aorbParam.get(i2).setIs_show(true);
            this.list_aorbParam.get(i2).setAorb(ViewUtil.KEY_B);
            setSwitch_num(i2);
            this.aorBParam_b = i2;
        }
    }

    public void showKey(Context context, EditText editText, boolean z, String str) {
        Drawable drawable;
        if (editText == null) {
            return;
        }
        if (ViewUtil.KEY_A.equals(str)) {
            drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_bg_key_1, null);
        } else {
            drawable = ViewUtil.KEY_B.equals(str) ? ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_bg_key_2, null) : null;
        }
        if (drawable == null) {
            return;
        }
        controlLight(editText, ViewUtil.KEY_A.equals(str), z);
        if (z) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            editText.setCompoundDrawables(null, null, drawable, null);
            checkView(editText, ViewUtil.KEY_A.equals(str));
        } else {
            drawable.setBounds(0, 0, 0, 0);
            editText.setCompoundDrawables(null, null, null, null);
        }
        editText.setCompoundDrawablePadding(0);
    }

    public void showKey(Context context, TextView textView, boolean z, String str) {
        Drawable drawable;
        if (textView == null) {
            return;
        }
        if (ViewUtil.KEY_A.equals(str)) {
            drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_bg_key_1, null);
        } else {
            drawable = ViewUtil.KEY_B.equals(str) ? ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_bg_key_2, null) : null;
        }
        if (drawable == null) {
            return;
        }
        controlLight(textView, ViewUtil.KEY_A.equals(str), z);
        if (z) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
            checkView(textView, ViewUtil.KEY_A.equals(str));
        } else {
            drawable.setBounds(0, 0, 0, 0);
            textView.setCompoundDrawables(null, null, null, null);
        }
        textView.setCompoundDrawablePadding(0);
    }

    private void checkView(TextView textView, boolean z) {
        if (z) {
            TextView textView2 = this.textA;
            if (textView2 == null) {
                this.textA = textView;
                return;
            } else if (textView2.getId() != textView.getId()) {
                this.textA = textView;
                return;
            } else {
                return;
            }
        }
        TextView textView3 = this.textB;
        if (textView3 == null) {
            this.textB = textView;
        } else if (textView3.getId() != textView.getId()) {
            this.textB = textView;
        }
    }

    public int getViewId(int i) {
        List<AorBParam> list = this.list_aorbParam;
        if (list != null && list.size() - 1 >= i) {
            EditText editText = this.list_aorbParam.get(i).getEditText();
            TextView textView = this.list_aorbParam.get(i).getTextView();
            if (editText != null) {
                return editText.getId();
            }
            if (textView != null) {
                return textView.getId();
            }
        }
        return 0;
    }

    private void moveCurrentItem(View view, List<MappingObject> list, MultiItemTypeAdapter<List<MappingObject>> multiItemTypeAdapter, boolean z) {
        String str;
        if (view instanceof TextView) {
            if (this.viewStateViewModel.getIsFirstShow() != null && this.viewStateViewModel.getIsFirstShow().getValue() != null && this.viewStateViewModel.getIsFirstShow().getValue().booleanValue()) {
                str = ((TextView) view).getText().toString();
                this.viewStateViewModel.resetIsFirstShow();
            } else {
                str = this.chanString;
            }
            int indexOf = MappingObject.indexOf(list, str);
            if (!z) {
                indexOf = indexOf > 0 ? indexOf - 1 : 0;
            } else if (indexOf < list.size() - 1) {
                indexOf++;
            }
            if (indexOf != -1) {
                multiItemTypeAdapter.setCurrentItem(indexOf);
                multiItemTypeAdapter.notifyDataSetChanged();
                if (indexOf < 0 || indexOf > list.size() - 1) {
                    return;
                }
                this.chanString = String.valueOf(list.get(indexOf).getStr());
            }
        }
    }

    public void rollA(KeyEvent keyEvent, View view, PopupSpinner popupSpinner, List<MappingObject> list, SpinnerAdapter spinnerAdapter, boolean z, KeyboardPopupView keyboardPopupView, OnKeyboardItemChangeListener onKeyboardItemChangeListener) {
        this.viewStateViewModel = ViewUtil.getViewStateViewModel();
        LogUtils.e("aorBParam_a", Log.getStackTraceString(new Throwable()));
        if (this.viewStateViewModel.getViewState().getValue() == null) {
            this.viewStateViewModel.getViewState().setValue(1);
        }
        if (this.viewStateViewModel.getViewState().getValue().intValue() == 2) {
            if (popupSpinner == null || !popupSpinner.isShowing()) {
                return;
            }
            for (int i = 0; i < this.list_aorbParam.size(); i++) {
                if (view != null && this.list_aorbParam.get(i).getTextView() != null && view.getId() == this.list_aorbParam.get(i).getTextView().getId() && spinnerAdapter != null) {
                    moveCurrentItem(view, list, spinnerAdapter, z);
                }
            }
        } else if (this.viewStateViewModel.getViewState().getValue().intValue() == 1) {
            OnSetTextById onSetTextById = this.onSetTextById;
            if (onSetTextById != null) {
                onSetTextById.onViewIdCallback(keyEvent, getViewId(this.aorBParam_a), z);
            }
        } else if (this.viewStateViewModel.getViewState().getValue().intValue() == 3 && keyboardPopupView != null) {
            keyboardPopupView.setSelectedBean(moveKeyView(keyboardPopupView.getSelectedBean(), keyboardPopupView.getKeyBeans(), z));
            if (onKeyboardItemChangeListener != null) {
                onKeyboardItemChangeListener.onCall(keyboardPopupView);
            }
        }
    }

    public void rollB(KeyEvent keyEvent, View view, PopupSpinner popupSpinner, List<MappingObject> list, SpinnerAdapter spinnerAdapter, boolean z, KeyboardPopupView keyboardPopupView, OnKeyboardItemChangeListener onKeyboardItemChangeListener) {
        ViewStateViewModel viewStateViewModel = ViewUtil.getViewStateViewModel();
        this.viewStateViewModel = viewStateViewModel;
        if (viewStateViewModel.getViewState().getValue() == null) {
            this.viewStateViewModel.getViewState().setValue(1);
        }
        if (this.viewStateViewModel.getViewState().getValue().intValue() == 2) {
            if (popupSpinner == null || !popupSpinner.isShowing()) {
                return;
            }
            for (int i = 0; i < this.list_aorbParam.size(); i++) {
                if (view != null && this.list_aorbParam.get(i).getTextView() != null && view.getId() == this.list_aorbParam.get(i).getTextView().getId() && spinnerAdapter != null) {
                    moveCurrentItem(view, list, spinnerAdapter, z);
                }
            }
        } else if (this.viewStateViewModel.getViewState().getValue().intValue() == 1) {
            OnSetTextById onSetTextById = this.onSetTextById;
            if (onSetTextById != null) {
                onSetTextById.onViewIdCallback(keyEvent, getViewId(this.aorBParam_b), z);
            }
        } else if (this.viewStateViewModel.getViewState().getValue().intValue() == 3 && keyboardPopupView != null) {
            keyboardPopupView.setSelectedBean(moveKeyView(keyboardPopupView.getSelectedBean(), keyboardPopupView.getKeyBeans(), z));
            if (onKeyboardItemChangeListener != null) {
                onKeyboardItemChangeListener.onCall(keyboardPopupView);
            }
        }
    }

    public void rollTrigger(KeyEvent keyEvent, boolean z) {
        OnSetTextByTriggerLevelRoll onSetTextByTriggerLevelRoll = this.onSetTextByTriggerLevelRoll;
        if (onSetTextByTriggerLevelRoll != null) {
            onSetTextByTriggerLevelRoll.onTriggerLevelRollCallback(keyEvent, z);
        }
    }

    private void setSpinnerAdapterItemTextColor(View view, List<MappingObject> list, MultiItemTypeAdapter<List<MappingObject>> multiItemTypeAdapter, int i) {
        TextView textView = (TextView) view;
        textView.setTextColor(-1);
        if (multiItemTypeAdapter instanceof ChanSpinnerAdapter) {
            int color = ColorUtil.getColor(this.context, ServiceEnum.getChanFromValue1(list.get(i).getValue()));
            if (color != -1) {
                textView.setTextColor(color);
            } else {
                textView.setTextColor(-1);
            }
        } else if (multiItemTypeAdapter instanceof SpinnerAdapter) {
            textView.setTextColor(-1);
        }
    }

    public void selectA(View view, PopupSpinner popupSpinner, List<MappingObject> list, MultiItemTypeAdapter<List<MappingObject>> multiItemTypeAdapter, KeyboardPopupView keyboardPopupView, OnKeyboardItemChangeListener onKeyboardItemChangeListener, OnSpinnerItemChangeListener onSpinnerItemChangeListener) {
        ViewStateViewModel viewStateViewModel = ViewUtil.getViewStateViewModel();
        this.viewStateViewModel = viewStateViewModel;
        if (viewStateViewModel.getViewState().getValue() == null) {
            this.viewStateViewModel.getViewState().setValue(1);
        }
        if (this.viewStateViewModel.getViewState().getValue().intValue() == 2) {
            if (view instanceof TextView) {
                int indexOf = MappingObject.indexOf(list, this.chanString);
                if (indexOf == -1) {
                    indexOf = MappingObject.indexOf(list, ((TextView) view).getText().toString());
                }
                if (indexOf != -1) {
                    if (multiItemTypeAdapter != null) {
                        multiItemTypeAdapter.setCurrentItem(indexOf);
                        multiItemTypeAdapter.notifyDataSetChanged();
                        if (indexOf >= 0 && indexOf <= list.size() - 1) {
                            ((TextView) view).setText(String.valueOf(list.get(indexOf).getStr()));
                            setSpinnerAdapterItemTextColor(view, list, multiItemTypeAdapter, indexOf);
                        }
                        if (onSpinnerItemChangeListener != null) {
                            onSpinnerItemChangeListener.onCall(indexOf, list.get(indexOf));
                        }
                    }
                    if (popupSpinner != null) {
                        popupSpinner.dismiss();
                    }
                }
            }
        } else if (this.viewStateViewModel.getViewState().getValue().intValue() == 1) {
            OnTextReset onTextReset = this.onReset;
            if (onTextReset != null) {
                onTextReset.onResetDefault(getViewId(this.aorBParam_a));
            }
        } else if (this.viewStateViewModel.getViewState().getValue().intValue() != 3 || keyboardPopupView == null || keyboardPopupView.getSelectedBean() == null || keyboardPopupView.getSelectedBean().getView() == null) {
        } else {
            keyboardPopupView.onClick(keyboardPopupView.getSelectedBean().getView());
            if (onKeyboardItemChangeListener != null) {
                onKeyboardItemChangeListener.onCall(keyboardPopupView);
            }
        }
    }

    public void selectB(View view, PopupSpinner popupSpinner, List<MappingObject> list, MultiItemTypeAdapter<List<MappingObject>> multiItemTypeAdapter, KeyboardPopupView keyboardPopupView, OnKeyboardItemChangeListener onKeyboardItemChangeListener, OnSpinnerItemChangeListener onSpinnerItemChangeListener) {
        ViewStateViewModel viewStateViewModel = ViewUtil.getViewStateViewModel();
        this.viewStateViewModel = viewStateViewModel;
        if (viewStateViewModel.getViewState().getValue() == null) {
            this.viewStateViewModel.getViewState().setValue(1);
        }
        if (this.viewStateViewModel.getViewState().getValue().intValue() == 2) {
            if (view instanceof TextView) {
                int indexOf = MappingObject.indexOf(list, this.chanString);
                if (indexOf == -1) {
                    indexOf = MappingObject.indexOf(list, ((TextView) view).getText().toString());
                }
                if (indexOf != -1) {
                    if (multiItemTypeAdapter != null) {
                        multiItemTypeAdapter.setCurrentItem(indexOf);
                        multiItemTypeAdapter.notifyDataSetChanged();
                        if (indexOf >= 0 && indexOf <= list.size() - 1) {
                            ((TextView) view).setText(String.valueOf(list.get(indexOf).getStr()));
                            setSpinnerAdapterItemTextColor(view, list, multiItemTypeAdapter, indexOf);
                        }
                        if (onSpinnerItemChangeListener != null) {
                            onSpinnerItemChangeListener.onCall(indexOf, list.get(indexOf));
                        }
                    }
                    if (popupSpinner != null) {
                        popupSpinner.dismiss();
                    }
                }
            }
        } else if (this.viewStateViewModel.getViewState().getValue().intValue() == 1) {
            OnTextReset onTextReset = this.onReset;
            if (onTextReset != null) {
                onTextReset.onResetDefault(getViewId(this.aorBParam_b));
            }
        } else if (this.viewStateViewModel.getViewState().getValue().intValue() != 3 || keyboardPopupView == null || keyboardPopupView.getSelectedBean() == null || keyboardPopupView.getSelectedBean().getView() == null) {
        } else {
            keyboardPopupView.onClick(keyboardPopupView.getSelectedBean().getView());
            if (onKeyboardItemChangeListener != null) {
                onKeyboardItemChangeListener.onCall(keyboardPopupView);
            }
        }
    }

    public KeyBean resetViewAndSelectView(KeyBean keyBean, KeyBean keyBean2) {
        Context context;
        Context context2;
        if (this.keyBoardBgUnSelectedDrawable == null && (context2 = this.context) != null) {
            this.keyBoardBgUnSelectedDrawable = ResourcesCompat.getDrawable(context2.getResources(), R.drawable.bg_rectangle_normal_gray, null);
        }
        if (this.keyBoardBgSelectedDrawable == null && (context = this.context) != null) {
            this.keyBoardBgSelectedDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.bg_rectangle_selected_gray, null);
        }
        if (keyBean != null && keyBean2 != null) {
            if (keyBean.getIndex() == keyBean2.getIndex()) {
                return keyBean;
            }
            if (keyBean.getView() != null) {
                keyBean.getView().setBackground(this.keyBoardBgUnSelectedDrawable);
                keyBean.setChecked(false);
            }
            if (keyBean2.getView() != null) {
                keyBean2.getView().setBackground(this.keyBoardBgSelectedDrawable);
                keyBean2.setChecked(true);
            }
        }
        return keyBean2;
    }

    public KeyBean moveKeyView(KeyBean keyBean, List<KeyBean> list, boolean z) {
        KeyBean keyBean2;
        KeyBean keyBean3 = null;
        if (keyBean == null) {
            return null;
        }
        if (list != null && list.size() > 0 && list.size() <= 24) {
            int index = keyBean.getIndex();
            if (z) {
                if (index >= 0 && index < 23) {
                    int i = index + 1;
                    if (list.get(i).getView().isEnabled()) {
                        keyBean2 = list.get(i);
                    } else {
                        keyBean2 = moveKeyView(list.get(i), list, true);
                    }
                } else {
                    if (index == 23 && list.get(index).getView().isEnabled()) {
                        keyBean2 = list.get(index);
                    }
                    resetViewAndSelectView(keyBean, keyBean3);
                }
                keyBean3 = keyBean2;
                resetViewAndSelectView(keyBean, keyBean3);
            } else {
                if (index >= 1 && index <= 24) {
                    int i2 = index - 1;
                    if (list.get(i2).getView().isEnabled()) {
                        keyBean2 = list.get(i2);
                    } else {
                        keyBean2 = moveKeyView(list.get(i2), list, false);
                    }
                } else {
                    if (index == 0 && list.get(index).getView().isEnabled()) {
                        keyBean2 = list.get(index);
                    }
                    resetViewAndSelectView(keyBean, keyBean3);
                }
                keyBean3 = keyBean2;
                resetViewAndSelectView(keyBean, keyBean3);
            }
        }
        return keyBean3;
    }

    public List<KeyBean> getKeyboardBeans(PopupviewKeyboardBinding popupviewKeyboardBinding) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= 24) {
                break;
            }
            if (i != 0) {
                z = false;
            }
            arrayList.add(new KeyBean(i, z));
            i++;
        }
        if (popupviewKeyboardBinding != null) {
            ((KeyBean) arrayList.get(0)).setView(popupviewKeyboardBinding.btnOne);
            ((KeyBean) arrayList.get(1)).setView(popupviewKeyboardBinding.btnTwo);
            ((KeyBean) arrayList.get(2)).setView(popupviewKeyboardBinding.btnThree);
            ((KeyBean) arrayList.get(3)).setView(popupviewKeyboardBinding.btnUnit1);
            ((KeyBean) arrayList.get(4)).setView(popupviewKeyboardBinding.btnDelete);
            ((KeyBean) arrayList.get(5)).setView(popupviewKeyboardBinding.btnFour);
            ((KeyBean) arrayList.get(6)).setView(popupviewKeyboardBinding.btnFive);
            ((KeyBean) arrayList.get(7)).setView(popupviewKeyboardBinding.btnSix);
            ((KeyBean) arrayList.get(8)).setView(popupviewKeyboardBinding.btnUnit2);
            ((KeyBean) arrayList.get(9)).setView(popupviewKeyboardBinding.btnMax);
            ((KeyBean) arrayList.get(10)).setView(popupviewKeyboardBinding.btnSeven);
            ((KeyBean) arrayList.get(11)).setView(popupviewKeyboardBinding.btnEight);
            ((KeyBean) arrayList.get(12)).setView(popupviewKeyboardBinding.btnNine);
            ((KeyBean) arrayList.get(13)).setView(popupviewKeyboardBinding.btnUnit3);
            ((KeyBean) arrayList.get(14)).setView(popupviewKeyboardBinding.btnMin);
            ((KeyBean) arrayList.get(15)).setView(popupviewKeyboardBinding.btnDecimalPoint);
            ((KeyBean) arrayList.get(16)).setView(popupviewKeyboardBinding.btnZero);
            ((KeyBean) arrayList.get(17)).setView(popupviewKeyboardBinding.btnPositiveOrNegative);
            ((KeyBean) arrayList.get(18)).setView(popupviewKeyboardBinding.btnUnit4);
            ((KeyBean) arrayList.get(19)).setView(popupviewKeyboardBinding.btnDef);
            ((KeyBean) arrayList.get(20)).setView(popupviewKeyboardBinding.btnExp);
            ((KeyBean) arrayList.get(21)).setView(popupviewKeyboardBinding.btnOk);
            ((KeyBean) arrayList.get(22)).setView(popupviewKeyboardBinding.btnUnit5);
            ((KeyBean) arrayList.get(23)).setView(popupviewKeyboardBinding.btnCls);
        }
        return arrayList;
    }

    public long getLongStep(long j, MessageAttr messageAttr, boolean z, KeyEvent keyEvent) {
        long j2;
        long j3;
        int i = 1;
        if (keyEvent != null) {
            try {
                int repeatCount = keyEvent.getRepeatCount();
                if (KeyCodeUtil.getPanelKey(keyEvent.getKeyCode()) == 16 && Math.abs(repeatCount) > 1) {
                    repeatCount *= 2;
                }
                i = repeatCount;
                releaseCurrentKeyEvent(keyEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        }
        long j4 = 1;
        if (messageAttr != null) {
            long maxLongValue = messageAttr.getMaxLongValue();
            long minLongValue = messageAttr.getMinLongValue();
            j4 = messageAttr.getStepValue();
            j3 = minLongValue;
            j2 = maxLongValue;
        } else {
            j2 = 1000;
            j3 = 1;
        }
        long j5 = z ? j + (j4 * i) : j - (j4 * i);
        return j5 > j2 ? j2 : j5 < j3 ? j3 : j5;
    }

    public int getIntStep(long j, MessageAttr messageAttr, boolean z, KeyEvent keyEvent) {
        long j2;
        long j3;
        long j4;
        int i = 1;
        if (keyEvent != null) {
            try {
                int repeatCount = keyEvent.getRepeatCount();
                if (KeyCodeUtil.getPanelKey(keyEvent.getKeyCode()) == 16 && Math.abs(repeatCount) > 1) {
                    repeatCount *= 2;
                }
                i = repeatCount;
                releaseCurrentKeyEvent(keyEvent);
            } catch (Exception e) {
                e.printStackTrace();
                j2 = 0;
            }
        }
        long j5 = 1;
        if (messageAttr != null) {
            long maxLongValue = messageAttr.getMaxLongValue();
            long minLongValue = messageAttr.getMinLongValue();
            j5 = messageAttr.getStepValue();
            j4 = minLongValue;
            j3 = maxLongValue;
        } else {
            j3 = 1000;
            j4 = 1;
        }
        j2 = z ? j + (j5 * i) : j - (j5 * i);
        if (j2 > j3) {
            j2 = j3;
        } else if (j2 < j4) {
            j2 = j4;
        }
        return Integer.parseInt(String.valueOf(j2));
    }

    public int getIntDef(MessageAttr messageAttr) {
        if (messageAttr != null) {
            try {
                return messageAttr.getDefIntValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 500;
            }
        }
        return 500;
    }

    public long getLongDef(MessageAttr messageAttr) {
        if (messageAttr != null) {
            try {
                return messageAttr.getDefLongValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 500L;
            }
        }
        return 500L;
    }

    public long getMeasureLongDef(MessageAttr messageAttr, ServiceEnum.ThreType threType, String str) {
        long defHighLongValue;
        if (messageAttr != null) {
            try {
                if (ServiceEnum.ThreType.TH_TYPE_PER == threType) {
                    defHighLongValue = messageAttr.getDefLongValue();
                } else if ("LOW".equalsIgnoreCase(str)) {
                    defHighLongValue = messageAttr.getDefLowLongValue();
                } else if ("MID".equalsIgnoreCase(str)) {
                    defHighLongValue = messageAttr.getDefMidLongValue();
                } else {
                    defHighLongValue = messageAttr.getDefHighLongValue();
                }
                return defHighLongValue;
            } catch (Exception e) {
                e.printStackTrace();
                return 500L;
            }
        }
        return 500L;
    }

    public double getDoubleDef(MessageAttr messageAttr) {
        if (messageAttr != null) {
            try {
                return messageAttr.getDefDoubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 500.0d;
            }
        }
        return 500.0d;
    }

    public void controlLight(TextView textView, boolean z, boolean z2) {
        if (textView == null || textView.getText() == null) {
            return;
        }
        String charSequence = textView.getText().toString();
        if (!isNumeric(charSequence)) {
            if (charSequence.endsWith("Vrms") ? false : charSequence.endsWith("s") || charSequence.endsWith("Hz") || charSequence.endsWith("bps") || charSequence.endsWith("%") || charSequence.endsWith("b/s")) {
                controlHorizontal(textView, z, z2);
            } else {
                controlVertical(textView, z, z2);
            }
        } else if (!TextUtils.isEmpty(textView.getText().toString())) {
            controlVertical(textView, z, z2);
        } else {
            if (TextUtils.isEmpty(textView.getText().toString())) {
            }
        }
    }

    private void controlHorizontal(TextView textView, boolean z, boolean z2) {
        PopupViewManager.getInstance().closeDefaultLight();
        if (z2) {
            if (z) {
                setTextA(textView);
                PopupViewManager.getInstance().closeDefaultLight();
                PopupViewManager.getInstance().closeAVerticalLight();
                PopupViewManager.getInstance().AHorizontalLight_Open();
                return;
            }
            setTextB(textView);
            PopupViewManager.getInstance().closeDefaultLight();
            PopupViewManager.getInstance().closeBVerticalLight();
            PopupViewManager.getInstance().BHorizontalLight_Open();
        }
    }

    private void controlVertical(TextView textView, boolean z, boolean z2) {
        PopupViewManager.getInstance().closeDefaultLight();
        if (z2) {
            if (z) {
                setTextA(textView);
                PopupViewManager.getInstance().closeDefaultLight();
                PopupViewManager.getInstance().closeAHorizontalLight();
                PopupViewManager.getInstance().AVerticalLight_Open();
                return;
            }
            setTextB(textView);
            PopupViewManager.getInstance().closeDefaultLight();
            PopupViewManager.getInstance().closeBHorizontalLight();
            PopupViewManager.getInstance().BVerticalLight_Open();
        }
    }

    private boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private void releaseCurrentKeyEvent(KeyEvent keyEvent) {
        MutableLiveData<KeyEvent> onKeyUpData;
        if (this.keyEvent == null) {
            this.keyEvent = new KeyEvent(keyEvent.getDownTime(), keyEvent.getEventTime(), keyEvent.getAction(), 0, keyEvent.getScanCode(), 0, -1, 0, keyEvent.getFlags(), keyEvent.getSource());
        }
        if (this.panelKeyViewModel == null) {
            this.panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        }
        PanelKeyViewModel panelKeyViewModel = this.panelKeyViewModel;
        if (panelKeyViewModel == null || (onKeyUpData = panelKeyViewModel.getOnKeyUpData()) == null) {
            return;
        }
        onKeyUpData.setValue(this.keyEvent);
    }
}
