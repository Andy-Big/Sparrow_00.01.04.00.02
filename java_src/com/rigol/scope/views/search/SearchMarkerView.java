package com.rigol.scope.views.search;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.SearchViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class SearchMarkerView extends View {
    private int mainMarkNum;
    private int[] mainPos;
    private int markerId;
    private int navigation;
    private Path path;
    private SearchParam searchParam;
    private final Paint trianglePaint;
    private int zoomMarkNum;
    private int[] zoomPos;

    public SearchMarkerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.trianglePaint = new Paint();
        this.path = new Path();
        this.markerId = 1;
        this.navigation = 0;
        this.mainPos = new int[1000];
        this.zoomPos = new int[1000];
        this.mainMarkNum = 0;
        this.zoomMarkNum = 0;
        SearchViewModel searchViewModel = (SearchViewModel) ContextUtil.getAppViewModel(SearchViewModel.class);
        if (searchViewModel != null) {
            searchViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchMarkerView$vls2y90iplE8EX_o8kfOkP1tD0o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SearchMarkerView.this.lambda$new$0$SearchMarkerView((SearchParam) obj);
                }
            });
        }
        this.markerId = i;
        init();
    }

    public /* synthetic */ void lambda$new$0$SearchMarkerView(SearchParam searchParam) {
        this.searchParam = searchParam;
    }

    public void init() {
        initTrianglePaint();
        addListener();
        setVisibility(8);
    }

    private void initTrianglePaint() {
        this.trianglePaint.setStrokeWidth(2.0f);
        this.trianglePaint.setStyle(Paint.Style.STROKE);
        this.trianglePaint.setColor(-1);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return;
        }
        setMeasuredDimension(viewGroup.getWidth(), 20);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTriangle(canvas);
    }

    private void drawTriangle(Canvas canvas) {
        if (!this.searchParam.isEnable()) {
            return;
        }
        int i = 0;
        if (this.markerId == 1) {
            while (true) {
                int i2 = this.mainMarkNum;
                if (i >= i2) {
                    return;
                }
                if (1001 > i2) {
                    this.path.reset();
                    this.path.moveTo(((this.mainPos[i] * getWidth()) / 1000.0f) - 10.0f, 0.0f);
                    this.path.lineTo(((this.mainPos[i] * getWidth()) / 1000.0f) + 10.0f, 0.0f);
                    this.path.lineTo((this.mainPos[i] * getWidth()) / 1000.0f, 10.0f);
                    this.path.close();
                    if (i != this.navigation) {
                        canvas.drawPath(this.path, this.trianglePaint);
                    } else {
                        this.trianglePaint.setStyle(Paint.Style.FILL_AND_STROKE);
                        this.trianglePaint.setColor(SupportMenu.CATEGORY_MASK);
                        canvas.drawPath(this.path, this.trianglePaint);
                        this.trianglePaint.setStyle(Paint.Style.STROKE);
                        this.trianglePaint.setColor(-1);
                    }
                }
                i++;
            }
        } else {
            while (true) {
                int i3 = this.zoomMarkNum;
                if (i >= i3) {
                    return;
                }
                if (1001 > i3) {
                    this.path.reset();
                    this.path.moveTo(((this.zoomPos[i] / 1000.0f) * getWidth()) - 10.0f, 0.0f);
                    this.path.lineTo(((this.zoomPos[i] / 1000.0f) * getWidth()) + 10.0f, 0.0f);
                    this.path.lineTo((this.zoomPos[i] / 1000.0f) * getWidth(), 10.0f);
                    this.path.close();
                    canvas.drawPath(this.path, this.trianglePaint);
                }
                i++;
            }
        }
    }

    public void addListener() {
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (syncDataViewModel == null) {
            return;
        }
        syncDataViewModel.get(25, MessageID.MSG_SEARCH_NAVIGATION_EVENT_DIRECTION).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchMarkerView$akjZ_5qyeQ9f9BbXsVnfn_V5Hds
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchMarkerView.this.lambda$addListener$1$SearchMarkerView(obj);
            }
        });
        syncDataViewModel.get(25, MessageID.MSG_SEARCH_EN).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchMarkerView$OIAB5Pne6pZ81vVAkIXbl_pMaro
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchMarkerView.this.lambda$addListener$2$SearchMarkerView(obj);
            }
        });
        syncDataViewModel.get(25, MessageID.MSG_APP_SEARCH_QUERY_DATA).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchMarkerView$5njUdbw-40bR7lC-sXA1Ql4FynA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchMarkerView.this.lambda$addListener$3$SearchMarkerView(obj);
            }
        });
        updateUIViewModel.get(1, MessageID.MSG_CHAN_ON_OFF).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchMarkerView$eq-dqKD4piUbjLNKIM6wl4VAUH8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchMarkerView.this.lambda$addListener$4$SearchMarkerView((Boolean) obj);
            }
        });
        updateUIViewModel.get(2, MessageID.MSG_CHAN_ON_OFF).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchMarkerView$_RmN1YQ4RaqLIMcJZ7bM5Tw_ktQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchMarkerView.this.lambda$addListener$5$SearchMarkerView((Boolean) obj);
            }
        });
        updateUIViewModel.get(3, MessageID.MSG_CHAN_ON_OFF).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchMarkerView$JrQ6M-TvlMaKe9n8Jsb7sMw95tA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchMarkerView.this.lambda$addListener$6$SearchMarkerView((Boolean) obj);
            }
        });
        updateUIViewModel.get(4, MessageID.MSG_CHAN_ON_OFF).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchMarkerView$kkI4S79SEDntrSg9WDGq8U9TwTc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchMarkerView.this.lambda$addListener$7$SearchMarkerView((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void lambda$addListener$1$SearchMarkerView(Object obj) {
        int intValue = ((Integer) obj).intValue() - 1;
        this.navigation = intValue;
        if (intValue < 0) {
            this.navigation = 0;
        }
        invalidate();
    }

    public /* synthetic */ void lambda$addListener$2$SearchMarkerView(Object obj) {
        updateVisibility();
        invalidate();
    }

    public /* synthetic */ void lambda$addListener$3$SearchMarkerView(Object obj) {
        try {
            JSONArray jSONArray = new JSONArray(obj.toString());
            JSONArray jSONArray2 = new JSONArray(jSONArray.get(0).toString());
            this.mainMarkNum = jSONArray2.length();
            for (int i = 0; i < jSONArray2.length(); i++) {
                this.mainPos[i] = Integer.parseInt(String.valueOf(jSONArray2.getInt(i)).replace("\"]", "").replace("[\"", ""));
            }
            if (1 < jSONArray.length()) {
                try {
                    JSONArray jSONArray3 = new JSONArray(jSONArray.get(1).toString());
                    this.zoomMarkNum = jSONArray3.length();
                    for (int i2 = 0; i2 < this.zoomMarkNum; i2++) {
                        this.zoomPos[i2] = Integer.parseInt(jSONArray3.get(i2).toString().replace("[", "").replace("]", ""));
                    }
                } catch (JSONException unused) {
                    this.zoomMarkNum = 0;
                }
            }
            setVisibility(0);
        } catch (JSONException e) {
            e.printStackTrace();
            setVisibility(8);
        }
        requestLayout();
        invalidate();
    }

    public /* synthetic */ void lambda$addListener$4$SearchMarkerView(Boolean bool) {
        initNoData(ServiceEnum.Chan.chan1);
    }

    public /* synthetic */ void lambda$addListener$5$SearchMarkerView(Boolean bool) {
        initNoData(ServiceEnum.Chan.chan2);
    }

    public /* synthetic */ void lambda$addListener$6$SearchMarkerView(Boolean bool) {
        initNoData(ServiceEnum.Chan.chan3);
    }

    public /* synthetic */ void lambda$addListener$7$SearchMarkerView(Boolean bool) {
        initNoData(ServiceEnum.Chan.chan4);
    }

    private void initNoData(ServiceEnum.Chan chan) {
        if (chan == this.searchParam.getEdgeSrc() || chan == this.searchParam.getPulseSrc()) {
            this.mainMarkNum = 0;
            this.zoomMarkNum = 0;
            invalidate();
        }
    }

    public void updateVisibility() {
        SearchParam searchParam = this.searchParam;
        if (searchParam != null) {
            if (searchParam.isEnable()) {
                setVisibility(0);
            } else {
                setVisibility(8);
            }
        }
        invalidate();
    }
}
