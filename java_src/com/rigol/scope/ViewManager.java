package com.rigol.scope;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.rigol.scope.adapters.MultiItemTypeAdapter;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.data.KeyBean;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.PopupviewKeyboardBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ViewManager {
    private static Context context;
    private static ViewManager instance;

    /* loaded from: classes.dex */
    public interface OnSpinnerClickListener {
        void onSpinnerClick(View view, int i, SpinnerAdapter spinnerAdapter);
    }

    private ViewManager() {
    }

    public static ViewManager getInstance(Context context2) {
        context = context2;
        if (instance == null) {
            synchronized (ViewManager.class) {
                instance = new ViewManager();
            }
        }
        return instance;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List] */
    public void handleSpinnerClick(View view, int i, int i2, PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, OnSpinnerClickListener onSpinnerClickListener) {
        if (spinnerAdapter == null) {
            spinnerAdapter = new SpinnerAdapter(context, ViewUtil.getList(i), view.getWidth());
            popupSpinner.setAdapter(spinnerAdapter);
        } else if (i != i2 && spinnerAdapter.getItems() != 0) {
            spinnerAdapter.getItems().clear();
            spinnerAdapter = new SpinnerAdapter(context, ViewUtil.getList(i), view.getWidth());
        }
        if (onSpinnerClickListener != null) {
            onSpinnerClickListener.onSpinnerClick(view, i, spinnerAdapter);
        }
    }

    public void roll(View view, int i, SpinnerAdapter spinnerAdapter, boolean z) {
        if (view == null || spinnerAdapter == null) {
            return;
        }
        moveCurrentItem(view, ViewUtil.getList(i), spinnerAdapter, z);
    }

    public void moveCurrentItem(View view, List<MappingObject> list, MultiItemTypeAdapter<List<MappingObject>> multiItemTypeAdapter, boolean z) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            int indexOf = MappingObject.indexOf(list, textView.getText().toString());
            if (!z) {
                indexOf = indexOf > 0 ? indexOf - 1 : 0;
            } else if (indexOf < list.size() - 1) {
                indexOf++;
            }
            if (indexOf != -1) {
                multiItemTypeAdapter.setCurrentItem(indexOf);
                if (list.size() - 1 >= indexOf && indexOf >= 0) {
                    textView.setText(String.valueOf(list.get(indexOf).getStr()));
                }
                multiItemTypeAdapter.notifyDataSetChanged();
            }
        }
    }

    public KeyBean resetViewAndSelectView(KeyBean keyBean, KeyBean keyBean2) {
        if (keyBean != null && keyBean.getView() != null) {
            keyBean.getView().setBackground(context.getDrawable(R.drawable.bg_rectangle_normal_gray));
            keyBean.setChecked(false);
        }
        if (keyBean2 != null && keyBean2.getView() != null) {
            keyBean2.getView().setBackground(context.getDrawable(R.drawable.bg_rectangle_selected_gray));
            keyBean2.setChecked(true);
        }
        return keyBean2;
    }

    public KeyBean moveKeyView(KeyBean keyBean, List<KeyBean> list, boolean z) {
        KeyBean moveKeyView;
        KeyBean keyBean2 = null;
        if (keyBean == null) {
            return null;
        }
        if (list != null && list.size() > 0 && list.size() <= 24) {
            int index = keyBean.getIndex();
            if (z) {
                if (index >= 0 && index < 23) {
                    int i = index + 1;
                    if (list.get(i).getView().isEnabled()) {
                        moveKeyView = list.get(i);
                    } else {
                        moveKeyView = moveKeyView(list.get(i), list, z);
                    }
                    keyBean2 = moveKeyView;
                }
                resetViewAndSelectView(keyBean, keyBean2);
            } else {
                if (index >= 1 && index <= 24) {
                    int i2 = index - 1;
                    if (list.get(i2).getView().isEnabled()) {
                        moveKeyView = list.get(i2);
                    } else {
                        moveKeyView = moveKeyView(list.get(i2), list, z);
                    }
                    keyBean2 = moveKeyView;
                }
                resetViewAndSelectView(keyBean, keyBean2);
            }
        }
        return keyBean2;
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
}
