package com.rigol.scope.views.baseview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DisplayParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.data.UtilityParamKt;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.DragViewUtil;
import com.rigol.scope.utilities.KeyCodeUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.DisplayViewModel;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.LoadingPopupView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class BasePopupView extends PopupWindow implements PopupWindow.OnDismissListener, View.OnTouchListener, Observer<KeyEvent> {
    private static final boolean CLIPPING_ENABLED_DEFAULT_VALUE = false;
    private static final boolean CLOSE_ENABLED_DEFAULT_VALUE = true;
    private static final boolean DISMISS_OTHERS_DEFAULT_VALUE = true;
    private static final boolean DROP_DOWN_DEFAULT_VALUE = false;
    private static final boolean OUTSIDE_TOUCHABLE_DEFAULT_VALUE = true;
    private static final boolean PANEL_KEY_ENABLED_DEFAULT_VALUE = true;
    protected View anchor;
    private final int[] anchorLocation;
    private final Rect anchorRect;
    List<MappingObject> baseListCH;
    protected boolean closeEnabled;
    protected Context context;
    protected boolean dismissOthers;
    protected DisplayParam displayParam;
    protected int gravity;
    protected boolean isDropdown;
    protected final View.OnAttachStateChangeListener onAttachStateChangeListener;
    private OptionParam optionParam;
    public final int[] originLocation;
    private final int[] outLocationOnScreen;
    private final List<Rect> outsideEnableClickRects;
    private final List<Rect> outsideExceptClickRects;
    protected boolean panelKeyEnabled;
    private final PanelKeyViewModel panelKeyViewModel;
    private final int[] popupLocation;
    private final Rect popupRect;
    private DragViewUtil.PopupWindowTouchListener popupWindowTouchListener;
    protected View refView;
    private final SyncDataViewModel syncDataViewModel;
    private final CharSequence title;
    private final int titleId;
    protected TextView titleView;
    private VerticalViewModel verticalViewModel;
    private final int[] waveLocation;
    private final Rect waveRect;
    protected int xoff;
    protected int yoff;

    protected View findAnchor() {
        return null;
    }

    public int getTitle() {
        return -1;
    }

    public BasePopupView(int i) {
        this(ActivityUtils.getTopActivity(), i);
    }

    public BasePopupView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BasePopupView(Context context, int i) {
        this(context, null, 0, i);
    }

    public BasePopupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BasePopupView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.style.App_PopupWindow);
    }

    public BasePopupView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.titleView = null;
        this.outsideEnableClickRects = new ArrayList();
        this.outsideExceptClickRects = new ArrayList();
        this.baseListCH = new ArrayList();
        this.onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.rigol.scope.views.baseview.BasePopupView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                Timber.d("onViewAttachedToWindow, v:%s", view);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                Timber.d("onViewDetachedFromWindow, v:%s", view);
                BasePopupView.this.dismiss();
            }
        };
        this.outLocationOnScreen = new int[2];
        this.waveRect = new Rect();
        this.waveLocation = new int[2];
        this.anchorRect = new Rect();
        this.anchorLocation = new int[2];
        this.popupRect = new Rect();
        this.popupLocation = new int[2];
        this.originLocation = new int[2];
        this.context = context;
        PopupWindowCompat.setWindowLayoutType(this, 1005);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BasePopupView, i, i2 == 0 ? R.style.App_PopupWindow : i2);
        this.titleId = obtainStyledAttributes.getResourceId(9, getTitle());
        this.title = obtainStyledAttributes.getText(9);
        setWidth(obtainStyledAttributes.getLayoutDimension(0, -1));
        setHeight(obtainStyledAttributes.getLayoutDimension(1, -2));
        setOutsideTouchable(obtainStyledAttributes.getBoolean(7, true));
        setClippingEnabled(obtainStyledAttributes.getBoolean(2, false));
        this.closeEnabled = obtainStyledAttributes.getBoolean(3, true);
        this.panelKeyEnabled = obtainStyledAttributes.getBoolean(8, true);
        this.dismissOthers = obtainStyledAttributes.getBoolean(4, true);
        this.isDropdown = obtainStyledAttributes.getBoolean(6, false);
        this.gravity = obtainStyledAttributes.getInteger(5, BadgeDrawable.TOP_START);
        this.xoff = obtainStyledAttributes.getInteger(10, 0);
        this.yoff = obtainStyledAttributes.getInteger(11, 0);
        obtainStyledAttributes.recycle();
        DisplayViewModel displayViewModel = (DisplayViewModel) ContextUtil.getAppViewModel(DisplayViewModel.class);
        if (displayViewModel != null) {
            this.displayParam = displayViewModel.getLiveData().getValue();
            setBackgroundAlpha();
        }
        this.panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        this.syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        this.optionParam = ((OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class)).getLiveData().getValue();
        setOnDismissListener(this);
        setTouchInterceptor(this);
    }

    @Override // android.widget.PopupWindow
    public void setContentView(View view) {
        int i;
        super.setContentView(view);
        setAnimationStyle(16973826);
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.title);
            this.titleView = textView;
            if (textView != null && (i = this.titleId) != -1) {
                textView.setText(i);
            }
            View findViewById = view.findViewById(R.id.close);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.baseview.BasePopupView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (((UtilityParam) Objects.requireNonNull(((UtilityViewModel) Objects.requireNonNull((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class))).getLiveData().getValue())).readReadInputKeyboard()) {
                            return;
                        }
                        BasePopupView.this.dismiss();
                    }
                });
            }
            this.popupWindowTouchListener = new DragViewUtil.PopupWindowTouchListener(this);
            View findViewById2 = view.findViewById(R.id.title);
            if (findViewById2 != null) {
                findViewById2.setOnTouchListener(this.popupWindowTouchListener);
            }
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setOnKeyListener(new View.OnKeyListener() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BasePopupView$vhVYsnug0oMN1ozZFmlILYXYpoE
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view2, int i2, KeyEvent keyEvent) {
                    return BasePopupView.this.lambda$setContentView$0$BasePopupView(view2, i2, keyEvent);
                }
            });
        }
    }

    public /* synthetic */ boolean lambda$setContentView$0$BasePopupView(View view, int i, KeyEvent keyEvent) {
        PanelKeyViewModel panelKeyViewModel;
        PanelKeyViewModel panelKeyViewModel2;
        int panelKey = KeyCodeUtil.getPanelKey(i);
        int action = keyEvent.getAction();
        if (action == 0) {
            if (panelKey <= 0 || (panelKeyViewModel = this.panelKeyViewModel) == null) {
                return false;
            }
            panelKeyViewModel.getOnKeyDownData().setValue(keyEvent);
            return false;
        } else if (action == 1 && panelKey > 0 && (panelKeyViewModel2 = this.panelKeyViewModel) != null) {
            panelKeyViewModel2.getOnKeyUpData().setValue(keyEvent);
            UtilityParamKt.saveTone();
            return false;
        } else {
            return false;
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        onPrepare();
        DragViewUtil.PopupWindowTouchListener popupWindowTouchListener = this.popupWindowTouchListener;
        if (popupWindowTouchListener != null) {
            popupWindowTouchListener.setAtLocation(false);
        }
        super.showAsDropDown(view, i, i2, i3);
        this.anchor = view;
        onShow();
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        onPrepare();
        DragViewUtil.PopupWindowTouchListener popupWindowTouchListener = this.popupWindowTouchListener;
        if (popupWindowTouchListener != null) {
            popupWindowTouchListener.setAtLocation(true);
        }
        super.showAtLocation(view, i, i2, i3);
        this.anchor = view;
        onShow();
        PopupViewManager.getInstance().showCurrentWindowLight(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPrepare() {
        PanelKeyViewModel panelKeyViewModel;
        UtilityParam value;
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (utilityViewModel != null && (value = utilityViewModel.getLiveData().getValue()) != null) {
            setTouchable(!value.getLockKeyboard());
        }
        if (!this.panelKeyEnabled && (panelKeyViewModel = this.panelKeyViewModel) != null) {
            panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, this);
        }
        SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
        if (syncDataViewModel != null) {
            syncDataViewModel.get(26, MessageID.MSG_WINDOW_TRANSPARENCY).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BasePopupView$mXqPccZVAvshQ-pDuT_ZKwqRFNk
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BasePopupView.this.lambda$onPrepare$1$BasePopupView(obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onPrepare$1$BasePopupView(Object obj) {
        setBackgroundAlpha();
    }

    private void setBackgroundAlpha() {
        Drawable background;
        if (this.displayParam == null || (background = getBackground()) == null) {
            return;
        }
        background.setAlpha((int) this.displayParam.getWindowTransparency255());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onShow() {
        getContentView().post(new Runnable() { // from class: com.rigol.scope.views.baseview.-$$Lambda$XB59PgQ2du8sQuGY1EDwZXuSmCc
            @Override // java.lang.Runnable
            public final void run() {
                BasePopupView.this.updateOriginLocation();
            }
        });
    }

    public void updateOriginLocation() {
        int appScreenWidth = ScreenUtils.getAppScreenWidth();
        int appScreenHeight = ScreenUtils.getAppScreenHeight();
        int i = this.gravity;
        if (i == 17) {
            this.originLocation[0] = (int) ((appScreenWidth - getContentView().getWidth()) / 2.0f);
            this.originLocation[1] = (int) ((appScreenHeight - getContentView().getHeight()) / 2.0f);
        } else if (i == 48) {
            this.originLocation[0] = (int) ((appScreenWidth - getContentView().getWidth()) / 2.0f);
            this.originLocation[1] = 0;
        } else {
            int[] iArr = this.originLocation;
            iArr[0] = 0;
            iArr[1] = 0;
        }
    }

    public void attachRefView(View view) {
        view.addOnAttachStateChangeListener(this.onAttachStateChangeListener);
        this.refView = view;
    }

    public void showAsDropDown(View view, View view2, int i, int i2, int i3) {
        attachRefView(view2);
        int[] offset = getOffset(view, view2, i3);
        PopupWindowCompat.showAsDropDown(this, view, offset[0] + i, offset[1] + i2, i3);
    }

    public static int[] getOffset(View view, View view2, int i) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int[] iArr3 = new int[2];
        if (i == 8388613) {
            int width = view.getWidth();
            iArr3[0] = ((iArr[0] - iArr2[0]) - width) + view2.getWidth();
        } else {
            iArr3[0] = iArr[0] - iArr2[0];
        }
        int height = view.getHeight();
        iArr3[1] = ((iArr[1] - iArr2[1]) - height) + view2.getHeight();
        return iArr3;
    }

    public static int[] getOffset(View view, View view2) {
        return getOffset(view, view2, GravityCompat.START);
    }

    public void onPanelKeyUp(int i, KeyEvent keyEvent) {
        Timber.d("onPanelkeyUp, panelKey:" + i + ", keyEvent.getRepeatCount():" + keyEvent.getRepeatCount() + ", toString():" + keyEvent.toString(), new Object[0]);
    }

    public void onPanelKeyDown(int i, KeyEvent keyEvent) {
        Timber.d("onPanelkeyDown, panelKey:" + i + ", keyEvent.getRepeatCount():" + keyEvent.getRepeatCount() + ", toString():" + keyEvent.toString(), new Object[0]);
    }

    public void onLocaleChanged() {
        int i;
        TextView textView = this.titleView;
        if (textView == null || (i = this.titleId) == -1) {
            return;
        }
        try {
            textView.setText(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notifyDataSetChanged() {
        Timber.d("notifyDataSetChanged", new Object[0]);
    }

    public void onDismiss() {
        PanelKeyViewModel panelKeyViewModel = this.panelKeyViewModel;
        if (panelKeyViewModel != null) {
            panelKeyViewModel.getOnKeyUpData().removeObserver(this);
        }
        PopupViewManager.getInstance().dismissBasePopupView(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((this instanceof LoadingPopupView) || !PopupViewManager.getInstance().isLoadingClassShowing()) && !ViewUtil.getTouchLock()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 4) {
                PopupViewManager.getInstance().setShowingWhenClickDown(true);
                view.getLocationOnScreen(this.outLocationOnScreen);
                float x = this.outLocationOnScreen[0] + motionEvent.getX();
                float y = this.outLocationOnScreen[1] + motionEvent.getY();
                for (Rect rect : this.outsideExceptClickRects) {
                    if (rect != null && x >= rect.left && x <= rect.right && y >= rect.top && y <= rect.bottom) {
                        return false;
                    }
                }
                for (Rect rect2 : this.outsideEnableClickRects) {
                    if (rect2 != null && x >= rect2.left && x <= rect2.right && y >= rect2.top && y <= rect2.bottom) {
                        return true;
                    }
                }
            } else if (actionMasked == 1) {
                UtilityParamKt.saveTone();
            }
            return false;
        }
        return true;
    }

    public List<Rect> getOutsideEnableClickRects() {
        return this.outsideEnableClickRects;
    }

    public List<Rect> getOutsideExceptClickRects() {
        return this.outsideExceptClickRects;
    }

    public final void setAnchor(View view) {
        this.anchor = view;
    }

    public View getAnchor() {
        return this.anchor;
    }

    public void setXoff(int i) {
        this.xoff = i;
    }

    public int getXoff() {
        return this.xoff;
    }

    public void setYoff(int i) {
        this.yoff = i;
    }

    public int getYoff() {
        return this.yoff;
    }

    public void show(View view) {
        setAnchor(view);
        show();
    }

    public void show() {
        if (this.dismissOthers && PopupViewManager.getInstance().isShowing()) {
            PopupViewManager.getInstance().isTouchControlLight = false;
            PopupViewManager.getInstance().dismissAll(new Class[0]);
        }
        View findAnchor = findAnchor();
        if (findAnchor != null && findAnchor.getLocalVisibleRect(this.anchorRect)) {
            show(findAnchor, this.isDropdown, this.gravity, this.xoff, this.yoff);
            return;
        }
        View view = this.anchor;
        if (view != null && view.getVisibility() == 0 && this.anchor.getLocalVisibleRect(this.anchorRect)) {
            show(this.anchor, this.isDropdown, this.gravity, this.xoff, this.yoff);
            return;
        }
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) {
            return;
        }
        show(topActivity.getWindow().getDecorView(), this.isDropdown, this.gravity, this.xoff, this.yoff);
    }

    public void shoResults() {
        if (this.dismissOthers && PopupViewManager.getInstance().isShowing()) {
            PopupViewManager.getInstance().isTouchControlLight = false;
            PopupViewManager.getInstance().dismissAll(new Class[0]);
        }
        View findAnchor = findAnchor();
        if (findAnchor != null && findAnchor.getLocalVisibleRect(this.anchorRect)) {
            Log.e("TAG", "shoResults findAnchor0: " + findAnchor);
            showR(findAnchor, this.isDropdown, this.gravity, this.xoff, this.yoff);
            return;
        }
        View view = this.anchor;
        if (view != null && view.getVisibility() == 0 && this.anchor.getLocalVisibleRect(this.anchorRect)) {
            Log.e("TAG", "shoResults findAnchor1: " + this.anchor);
            showR(this.anchor, this.isDropdown, this.gravity, this.xoff, this.yoff);
            return;
        }
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) {
            return;
        }
        showR(topActivity.getWindow().getDecorView(), this.isDropdown, this.gravity, this.xoff, this.yoff);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0288  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void show(android.view.View r8, boolean r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.views.baseview.BasePopupView.show(android.view.View, boolean, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x028a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showR(android.view.View r8, boolean r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.views.baseview.BasePopupView.showR(android.view.View, boolean, int, int, int):void");
    }

    public void updateLocation() {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity instanceof MainActivity) {
            getRectValue(((MainActivity) topActivity).getWaveformFragment().getBinding().getRoot(), this.waveLocation, this.waveRect, "waveRect: %s");
            View contentView = getContentView();
            if (contentView == null) {
                return;
            }
            getRectValue(contentView, this.popupLocation, this.popupRect, "popupRect: %s");
            int i = this.popupRect.left;
            if (this.popupRect.left < this.waveRect.left) {
                i = this.waveRect.left;
            } else if (this.popupRect.right > this.waveRect.right) {
                i = this.waveRect.right - getContentView().getWidth();
            }
            updateLocation(i, this.popupRect.top);
        }
    }

    private void getRectValue(View view, int[] iArr, Rect rect, String str) {
        view.getLocationOnScreen(iArr);
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
    }

    public void updateLocation(int i, int i2) {
        int[] iArr = this.originLocation;
        update(i - iArr[0], i2 - iArr[1], -1, -1);
    }

    public void updateLocations(int i, int i2) {
        update(i, i2, -1, -1);
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(KeyEvent keyEvent) {
        dismiss();
    }

    public List<MappingObject> chenkCH(List<MappingObject> list) {
        int i = 0;
        if (list.size() == 4) {
            while (i < list.size()) {
                if (list.get(i).getSi().equals(this.verticalViewModel.getLiveData().getValue().get(i).getTitle()) && this.verticalViewModel.getLiveData().getValue().get(i).getStatus() != ServiceEnum.enChanStatus.CHAN_HIDE) {
                    this.baseListCH.add(list.get(i));
                }
                i++;
            }
        } else {
            this.baseListCH.addAll(list.subList(3, list.size()));
            while (i < 4) {
                if (list.get(i).getSi().equals(this.verticalViewModel.getLiveData().getValue().get(i).getTitle()) && this.verticalViewModel.getLiveData().getValue().get(i).getStatus() != ServiceEnum.enChanStatus.CHAN_HIDE) {
                    this.baseListCH.add(list.get(i));
                }
                i++;
            }
        }
        return this.baseListCH;
    }
}
