package com.rigol.pinyinkeyboard;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.transition.Transition;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import com.blankj.utilcode.util.CollectionUtils;
import com.rigol.pinyinkeyboard.BasePopup;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class BasePopup<T extends BasePopup> implements PopupWindow.OnDismissListener {
    private static final float DEFAULT_DIM = 0.7f;
    private static final String TAG = "BasePopup";
    private boolean isBackgroundDim;
    private boolean isShowAtLocation;
    protected View mAnchorView;
    private int mAnimationStyle;
    private View mContentView;
    public Context mContext;
    private ViewGroup mDimView;
    private Transition mEnterTransition;
    private Transition mExitTransition;
    private int mLayoutId;
    private int mOffsetX;
    private int mOffsetY;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private OnRealWHAlreadyListener mOnRealWHAlreadyListener;
    public PopupWindow mPopupWindow;
    protected static ArrayList<PopupWindow> sPopupWindowList = new ArrayList<>();
    protected static ArrayList<PopupWindow> sSpinnersList = new ArrayList<>();
    protected static ArrayList<PopupWindow> sKeyboardList = new ArrayList<>();
    protected PopViewEnum sPopViewEnum = PopViewEnum.PARMAVIEW;
    private boolean mFocusable = true;
    private boolean mOutsideTouchable = true;
    private int mWidth = -2;
    private int mHeight = -2;
    private float mDimValue = DEFAULT_DIM;
    private int mDimColor = ViewCompat.MEASURED_STATE_MASK;
    private boolean mFocusAndOutsideEnable = true;
    private int mYGravity = 2;
    private int mXGravity = 1;
    private int mInputMethodMode = 0;
    private int mSoftInputMode = 1;
    private boolean isNeedReMeasureWH = false;
    private boolean isRealWHAlready = false;
    private boolean isAtAnchorViewMethod = false;

    /* loaded from: classes.dex */
    public interface OnRealWHAlreadyListener {
        void onRealWHAlready(BasePopup basePopup, int i, int i2, int i3, int i4);
    }

    /* loaded from: classes.dex */
    public enum PopViewEnum {
        PARMAVIEW,
        SPINNER,
        KEYBOARD
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$onPopupWindowViewCreated$0(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    protected abstract void initAttributes();

    protected abstract void initViews(View view, T t);

    protected void onPopupWindowDismiss() {
    }

    protected T self() {
        return this;
    }

    public T apply() {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        PopupWindow popupWindow3;
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new PopupWindow();
        }
        onPopupWindowCreated();
        initContentViewAndWH();
        onPopupWindowViewCreated(this.mContentView);
        int i = this.mAnimationStyle;
        if (i != 0) {
            this.mPopupWindow.setAnimationStyle(i);
        }
        initFocusAndBack();
        this.mPopupWindow.setOnDismissListener(this);
        if (Build.VERSION.SDK_INT >= 23) {
            Transition transition = this.mEnterTransition;
            if (transition != null) {
                this.mPopupWindow.setEnterTransition(transition);
            }
            Transition transition2 = this.mExitTransition;
            if (transition2 != null) {
                this.mPopupWindow.setExitTransition(transition2);
            }
        }
        this.mPopupWindow.setClippingEnabled(false);
        PopViewEnum popViewEnum = getPopViewEnum();
        if (popViewEnum == PopViewEnum.PARMAVIEW && (popupWindow3 = this.mPopupWindow) != null) {
            sPopupWindowList.add(popupWindow3);
        }
        if (popViewEnum == PopViewEnum.SPINNER && (popupWindow2 = this.mPopupWindow) != null) {
            sSpinnersList.add(popupWindow2);
        }
        if (popViewEnum == PopViewEnum.KEYBOARD && (popupWindow = this.mPopupWindow) != null) {
            sKeyboardList.add(popupWindow);
        }
        return self();
    }

    private void initContentViewAndWH() {
        Context context;
        if (this.mContentView == null) {
            if (this.mLayoutId != 0 && (context = this.mContext) != null) {
                this.mContentView = LayoutInflater.from(context).inflate(this.mLayoutId, (ViewGroup) null);
            } else {
                throw new IllegalArgumentException("The content view is null,the layoutId=" + this.mLayoutId + ",context=" + this.mContext);
            }
        }
        this.mPopupWindow.setContentView(this.mContentView);
        int i = this.mWidth;
        if (i > 0 || i == -2 || i == -1) {
            this.mPopupWindow.setWidth(this.mWidth);
        } else {
            this.mPopupWindow.setWidth(-2);
        }
        int i2 = this.mHeight;
        if (i2 > 0 || i2 == -2 || i2 == -1) {
            this.mPopupWindow.setHeight(this.mHeight);
        } else {
            this.mPopupWindow.setHeight(-2);
        }
        measureContentView();
        registerOnGlobalLayoutListener();
        this.mPopupWindow.setInputMethodMode(this.mInputMethodMode);
        this.mPopupWindow.setSoftInputMode(this.mSoftInputMode);
    }

    private void initFocusAndBack() {
        if (!this.mFocusAndOutsideEnable) {
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable(null);
            this.mPopupWindow.getContentView().setFocusable(true);
            this.mPopupWindow.getContentView().setFocusableInTouchMode(true);
            this.mPopupWindow.getContentView().setOnKeyListener(new View.OnKeyListener() { // from class: com.rigol.pinyinkeyboard.BasePopup.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4) {
                        BasePopup.this.mPopupWindow.dismiss();
                        return true;
                    }
                    return false;
                }
            });
            this.mPopupWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: com.rigol.pinyinkeyboard.BasePopup.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (motionEvent.getAction() == 0 && (x < 0 || x >= BasePopup.this.mWidth || y < 0 || y >= BasePopup.this.mHeight)) {
                        Log.d(BasePopup.TAG, "onTouch outside:mWidth=" + BasePopup.this.mWidth + ",mHeight=" + BasePopup.this.mHeight);
                        return true;
                    } else if (motionEvent.getAction() == 4) {
                        Log.d(BasePopup.TAG, "onTouch outside event:mWidth=" + BasePopup.this.mWidth + ",mHeight=" + BasePopup.this.mHeight);
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            return;
        }
        this.mPopupWindow.setFocusable(this.mFocusable);
        this.mPopupWindow.setOutsideTouchable(this.mOutsideTouchable);
        this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    }

    protected void onPopupWindowCreated() {
        initAttributes();
    }

    protected void onPopupWindowViewCreated(View view) {
        initViews(view, self());
        View view2 = this.mContentView;
        if (view2 != null) {
            view2.setFocusable(true);
            this.mContentView.setFocusableInTouchMode(true);
            this.mContentView.setOnKeyListener(new View.OnKeyListener() { // from class: com.rigol.pinyinkeyboard.-$$Lambda$BasePopup$Io14jTBMPWEJeGn_6YB0tGgdMTc
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view3, int i, KeyEvent keyEvent) {
                    return BasePopup.lambda$onPopupWindowViewCreated$0(view3, i, keyEvent);
                }
            });
        }
    }

    public T setPopupWindowType(PopViewEnum popViewEnum) {
        this.sPopViewEnum = popViewEnum;
        return self();
    }

    private PopViewEnum getPopViewEnum() {
        return this.sPopViewEnum;
    }

    private void measureContentView() {
        View contentView = getContentView();
        if (this.mWidth <= 0 || this.mHeight <= 0) {
            contentView.measure(0, 0);
            if (this.mWidth <= 0) {
                this.mWidth = contentView.getMeasuredWidth();
            }
            if (this.mHeight <= 0) {
                this.mHeight = contentView.getMeasuredHeight();
            }
        }
    }

    private void registerOnGlobalLayoutListener() {
        getContentView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.rigol.pinyinkeyboard.BasePopup.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                BasePopup.this.getContentView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                BasePopup basePopup = BasePopup.this;
                basePopup.mWidth = basePopup.getContentView().getWidth();
                BasePopup basePopup2 = BasePopup.this;
                basePopup2.mHeight = basePopup2.getContentView().getHeight();
                BasePopup.this.isRealWHAlready = true;
                BasePopup.this.isNeedReMeasureWH = false;
                if (BasePopup.this.mOnRealWHAlreadyListener != null) {
                    OnRealWHAlreadyListener onRealWHAlreadyListener = BasePopup.this.mOnRealWHAlreadyListener;
                    BasePopup basePopup3 = BasePopup.this;
                    onRealWHAlreadyListener.onRealWHAlready(basePopup3, basePopup3.mWidth, BasePopup.this.mHeight, BasePopup.this.mAnchorView == null ? 0 : BasePopup.this.mAnchorView.getWidth(), BasePopup.this.mAnchorView != null ? BasePopup.this.mAnchorView.getHeight() : 0);
                }
                if (BasePopup.this.isShowing() && BasePopup.this.isAtAnchorViewMethod) {
                    BasePopup basePopup4 = BasePopup.this;
                    basePopup4.updateLocation(basePopup4.mWidth, BasePopup.this.mHeight, BasePopup.this.mAnchorView, BasePopup.this.mYGravity, BasePopup.this.mXGravity, BasePopup.this.mOffsetX, BasePopup.this.mOffsetY);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocation(int i, int i2, View view, int i3, int i4, int i5, int i6) {
        if (this.mPopupWindow == null) {
            return;
        }
        this.mPopupWindow.update(view, calculateX(view, i4, i, i5), calculateY(view, i3, i2, i6), i, i2);
    }

    public void touchMove() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null) {
            return;
        }
        popupWindow.getContentView().setOnTouchListener(new View.OnTouchListener() { // from class: com.rigol.pinyinkeyboard.BasePopup.4
            private float offsetX;
            private float offsetXTotal;
            private float offsetY;
            private float offsetYTotal;
            private int orgX;
            private int orgY;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        view.performClick();
                        this.offsetXTotal += this.offsetX;
                        this.offsetYTotal += this.offsetY;
                    } else if (action == 2) {
                        this.offsetX = motionEvent.getRawX() - this.orgX;
                        this.offsetY = motionEvent.getRawY() - this.orgY;
                        if (BasePopup.this.isShowAtLocation) {
                            if (BasePopup.this.mPopupWindow != null) {
                                BasePopup.this.mPopupWindow.update((int) (this.offsetX + this.offsetXTotal), (int) (this.offsetY + this.offsetYTotal), -1, -1, false);
                            }
                        } else if (BasePopup.this.mPopupWindow != null) {
                            BasePopup.this.mPopupWindow.update((int) this.offsetX, (int) this.offsetY, -1, -1, false);
                        }
                    }
                } else if (BasePopup.this.isShowAtLocation) {
                    this.orgX = (int) motionEvent.getRawX();
                    this.orgY = (int) motionEvent.getRawY();
                } else {
                    this.orgX = (int) motionEvent.getX();
                    this.orgY = (int) motionEvent.getY();
                }
                return true;
            }
        });
    }

    public T setContext(Context context) {
        this.mContext = context;
        return self();
    }

    public T setContentView(View view) {
        this.mContentView = view;
        this.mLayoutId = 0;
        return self();
    }

    public T setContentView(int i) {
        this.mContentView = null;
        this.mLayoutId = i;
        return self();
    }

    public T setContentView(Context context, int i) {
        this.mContext = context;
        this.mContentView = null;
        this.mLayoutId = i;
        return self();
    }

    public T setContentView(View view, int i, int i2) {
        this.mContentView = view;
        this.mLayoutId = 0;
        this.mWidth = i;
        this.mHeight = i2;
        return self();
    }

    public T setContentView(int i, int i2, int i3) {
        this.mContentView = null;
        this.mLayoutId = i;
        this.mWidth = i2;
        this.mHeight = i3;
        return self();
    }

    public T setContentView(Context context, int i, int i2, int i3) {
        this.mContext = context;
        this.mContentView = null;
        this.mLayoutId = i;
        this.mWidth = i2;
        this.mHeight = i3;
        return self();
    }

    public T setWidth(int i) {
        this.mWidth = i;
        return self();
    }

    public T setHeight(int i) {
        this.mHeight = i;
        return self();
    }

    public T setAnchorView(View view) {
        this.mAnchorView = view;
        return self();
    }

    public View getAnchorView() {
        return this.mAnchorView;
    }

    public T setYGravity(int i) {
        this.mYGravity = i;
        return self();
    }

    public T setXGravity(int i) {
        this.mXGravity = i;
        return self();
    }

    public T setOffsetX(int i) {
        this.mOffsetX = i;
        return self();
    }

    public T setOffsetY(int i) {
        this.mOffsetY = i;
        return self();
    }

    public T setAnimationStyle(int i) {
        this.mAnimationStyle = i;
        return self();
    }

    public T setFocusable(boolean z) {
        this.mFocusable = z;
        return self();
    }

    public T setOutsideTouchable(boolean z) {
        this.mOutsideTouchable = z;
        return self();
    }

    public T setFocusAndOutsideEnable(boolean z) {
        this.mFocusAndOutsideEnable = z;
        return self();
    }

    public T setBackgroundDimEnable(boolean z) {
        this.isBackgroundDim = z;
        return self();
    }

    public T setDimValue(float f) {
        this.mDimValue = f;
        return self();
    }

    public T setDimColor(int i) {
        this.mDimColor = i;
        return self();
    }

    public T setDimView(ViewGroup viewGroup) {
        this.mDimView = viewGroup;
        return self();
    }

    public T setEnterTransition(Transition transition) {
        this.mEnterTransition = transition;
        return self();
    }

    public T setExitTransition(Transition transition) {
        this.mExitTransition = transition;
        return self();
    }

    public T setInputMethodMode(int i) {
        this.mInputMethodMode = i;
        return self();
    }

    public T setSoftInputMode(int i) {
        this.mSoftInputMode = i;
        return self();
    }

    public T setNeedReMeasureWH(boolean z) {
        this.isNeedReMeasureWH = z;
        return self();
    }

    private void checkIsApply(boolean z) {
        if (this.isAtAnchorViewMethod != z) {
            this.isAtAnchorViewMethod = z;
        }
        if (this.mPopupWindow == null) {
            apply();
        }
    }

    private void dismissOtherPopupWindow() {
        if (this.sPopViewEnum != PopViewEnum.PARMAVIEW) {
            return;
        }
        ArrayList<PopupWindow> arrayList = sPopupWindowList;
        if (arrayList != null && arrayList.size() > 1) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < sPopupWindowList.size() - 1; i++) {
                PopupWindow popupWindow = sPopupWindowList.get(i);
                if (!popupWindow.isShowing()) {
                    arrayList2.add(popupWindow);
                } else {
                    arrayList3.add(popupWindow);
                }
            }
            if (!arrayList2.isEmpty()) {
                sPopupWindowList.removeAll(arrayList2);
            }
            if (!arrayList3.isEmpty()) {
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    ((PopupWindow) it.next()).dismiss();
                }
            }
        }
        if (!CollectionUtils.isEmpty(sSpinnersList)) {
            Iterator<PopupWindow> it2 = sSpinnersList.iterator();
            while (it2.hasNext()) {
                PopupWindow next = it2.next();
                if (next != null && next.isShowing()) {
                    next.dismiss();
                }
            }
            sSpinnersList.clear();
        }
        if (CollectionUtils.isEmpty(sKeyboardList)) {
            return;
        }
        Iterator<PopupWindow> it3 = sKeyboardList.iterator();
        while (it3.hasNext()) {
            PopupWindow next2 = it3.next();
            if (next2.isShowing()) {
                next2.dismiss();
            }
        }
        sKeyboardList.clear();
    }

    public void showAsDropDown(View view, View view2, int i) {
        int i2;
        int i3;
        dismissOtherPopupWindow();
        this.isShowAtLocation = false;
        checkIsApply(false);
        handleBackgroundDim();
        this.mAnchorView = view;
        int[] offset = getOffset(view, view2);
        registerOnGlobalLayoutListener();
        this.mPopupWindow.setFocusable(false);
        this.mPopupWindow.update();
        int[] iArr = new int[2];
        this.mAnchorView.getLocationOnScreen(iArr);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.widthPixels < iArr[0] + offset[0] + this.mWidth) {
            i2 = displayMetrics.widthPixels - (iArr[0] + this.mWidth);
        } else {
            i2 = offset[0];
        }
        int i4 = displayMetrics.heightPixels;
        int height = iArr[1] + this.mAnchorView.getHeight() + offset[1];
        int i5 = this.mHeight;
        if (i4 < height + i5) {
            i3 = ((-i5) - view2.getHeight()) + offset[1];
        } else {
            i3 = offset[1];
        }
        this.mPopupWindow.showAsDropDown(view, i2, i3, i);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.update();
    }

    public void showAsDropDown(View view, int i, int i2) {
        dismissOtherPopupWindow();
        this.isShowAtLocation = false;
        checkIsApply(false);
        handleBackgroundDim();
        this.mAnchorView = view;
        this.mOffsetX = i;
        this.mOffsetY = i2;
        if (this.isNeedReMeasureWH) {
            registerOnGlobalLayoutListener();
        }
        this.mPopupWindow.setFocusable(false);
        this.mPopupWindow.update();
        this.mPopupWindow.showAsDropDown(view, this.mOffsetX, this.mOffsetY);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.update();
    }

    public void showAsDropDown(View view) {
        showAsDropDown(view, 0, 0);
    }

    public void showAsDropDown(View view, View view2) {
        this.isShowAtLocation = false;
        int[] offset = getOffset(view, view2);
        showAsDropDown(view, offset[0], offset[1]);
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        dismissOtherPopupWindow();
        this.isShowAtLocation = true;
        checkIsApply(false);
        handleBackgroundDim();
        this.mAnchorView = view;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        if (this.isNeedReMeasureWH) {
            registerOnGlobalLayoutListener();
        }
        this.mPopupWindow.setFocusable(false);
        this.mPopupWindow.update();
        this.mPopupWindow.showAtLocation(view, i, this.mOffsetX, this.mOffsetY);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.update();
    }

    public void showAtAnchorView(View view, int i, int i2) {
        showAtAnchorView(view, i, i2, 0, 0);
    }

    public void showAtAnchorView(View view, int i, int i2, int i3, int i4) {
        dismissOtherPopupWindow();
        this.isShowAtLocation = false;
        checkIsApply(true);
        this.mAnchorView = view;
        this.mOffsetX = i3;
        this.mOffsetY = i4;
        this.mYGravity = i;
        this.mXGravity = i2;
        handleBackgroundDim();
        int calculateX = calculateX(view, i2, this.mWidth, this.mOffsetX);
        int calculateY = calculateY(view, i, this.mHeight, this.mOffsetY);
        if (this.isNeedReMeasureWH) {
            registerOnGlobalLayoutListener();
        }
        this.mPopupWindow.setFocusable(false);
        this.mPopupWindow.update();
        PopupWindowCompat.showAsDropDown(this.mPopupWindow, view, calculateX, calculateY, 0);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.update();
    }

    private int calculateY(View view, int i, int i2, int i3) {
        int height;
        if (i != 0) {
            if (i == 1) {
                i2 += view.getHeight();
            } else if (i == 3) {
                height = view.getHeight();
            } else if (i != 4) {
                return i3;
            }
            return i3 - i2;
        }
        height = (view.getHeight() / 2) + (i2 / 2);
        return i3 - height;
    }

    private int calculateX(View view, int i, int i2, int i3) {
        int width;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    width = view.getWidth();
                } else if (i != 4) {
                    return i3;
                } else {
                    i2 -= view.getWidth();
                }
            }
            return i3 - i2;
        }
        width = (view.getWidth() / 2) - (i2 / 2);
        return i3 + width;
    }

    public T setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return self();
    }

    public T setOnRealWHAlreadyListener(OnRealWHAlreadyListener onRealWHAlreadyListener) {
        this.mOnRealWHAlreadyListener = onRealWHAlreadyListener;
        return self();
    }

    private void handleBackgroundDim() {
        if (Build.VERSION.SDK_INT < 18 || !this.isBackgroundDim) {
            return;
        }
        ViewGroup viewGroup = this.mDimView;
        if (viewGroup != null) {
            applyDim(viewGroup);
        } else if (getContentView() == null || getContentView().getContext() == null || !(getContentView().getContext() instanceof Activity)) {
        } else {
            applyDim((Activity) getContentView().getContext());
        }
    }

    private void applyDim(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().getRootView();
        ColorDrawable colorDrawable = new ColorDrawable(this.mDimColor);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (this.mDimValue * 255.0f));
        viewGroup.getOverlay().add(colorDrawable);
    }

    private void applyDim(ViewGroup viewGroup) {
        ColorDrawable colorDrawable = new ColorDrawable(this.mDimColor);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (this.mDimValue * 255.0f));
        viewGroup.getOverlay().add(colorDrawable);
    }

    private void clearBackgroundDim() {
        Activity activity;
        if (Build.VERSION.SDK_INT < 18 || !this.isBackgroundDim) {
            return;
        }
        ViewGroup viewGroup = this.mDimView;
        if (viewGroup != null) {
            clearDim(viewGroup);
        } else if (getContentView() == null || (activity = (Activity) getContentView().getContext()) == null) {
        } else {
            clearDim(activity);
        }
    }

    private void clearDim(Activity activity) {
        ((ViewGroup) activity.getWindow().getDecorView().getRootView()).getOverlay().clear();
    }

    private void clearDim(ViewGroup viewGroup) {
        viewGroup.getOverlay().clear();
    }

    public View getContentView() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            return popupWindow.getContentView();
        }
        return null;
    }

    public PopupWindow getPopupWindow() {
        return this.mPopupWindow;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getXGravity() {
        return this.mXGravity;
    }

    public int getYGravity() {
        return this.mYGravity;
    }

    public int getOffsetX() {
        return this.mOffsetX;
    }

    public int getOffsetY() {
        return this.mOffsetY;
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        return popupWindow != null && popupWindow.isShowing();
    }

    public boolean isRealWHAlready() {
        return this.isRealWHAlready;
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
    public View findViewById(int i) {
        if (getContentView() != null) {
            return getContentView().findViewById(i);
        }
        return null;
    }

    public void dismiss() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        handleDismiss();
    }

    private void handleDismiss() {
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        clearBackgroundDim();
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
        }
        if (this.sPopViewEnum == PopViewEnum.PARMAVIEW && sPopupWindowList.contains(this.mPopupWindow)) {
            sPopupWindowList.remove(this.mPopupWindow);
        }
        if (this.sPopViewEnum == PopViewEnum.SPINNER) {
            sSpinnersList.clear();
        }
        onPopupWindowDismiss();
    }

    public static int[] getOffset(View view, View view2) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        return new int[]{iArr[0] - iArr2[0], ((iArr[1] - iArr2[1]) - view.getHeight()) + view2.getHeight()};
    }
}
