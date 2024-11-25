package com.rigol.scope.views.boardTest;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.GsonUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SelfTestItemAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.SelfTestParam;
import com.rigol.scope.databinding.PopupviewBoardTestBinding;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.baseview.LinearSpaceItemDecoration;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class BoardTestPopupView extends BasePopupView {
    private static final int COUNTDOWNINTERVAL = 1000;
    private static final int MILLISINFUTURE = 3000;
    private final PopupviewBoardTestBinding binding;
    private final CountDownTimer countDownTimer;
    private final SelfTestItemAdapter selfTestItemAdapter;
    private List<SelfTestParam> selfTestParamList;

    public BoardTestPopupView() {
        super((int) R.style.App_PopupWindow_BoardTest);
        this.countDownTimer = new CountDownTimer(3000L, 1000L) { // from class: com.rigol.scope.views.boardTest.BoardTestPopupView.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                try {
                    List<SelfTestParam> loadData = BoardTestPopupView.this.loadData();
                    BoardTestPopupView.this.selfTestItemAdapter.updateData(loadData);
                    BoardTestPopupView.this.updateSpanCount(loadData);
                } catch (JSONException e) {
                    e.printStackTrace();
                    ToastUtils.showShort("Data Load Error");
                }
                BoardTestPopupView.this.countDownTimer.start();
            }
        };
        PopupviewBoardTestBinding inflate = PopupviewBoardTestBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        try {
            List<SelfTestParam> loadData = loadData();
            this.selfTestParamList = loadData;
            updateSpanCount(loadData);
            this.binding.tvWarning.setVisibility(8);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.selfTestItemAdapter = new SelfTestItemAdapter(this.context, this.selfTestParamList);
        this.binding.selfTestRecycler.addItemDecoration(new LinearSpaceItemDecoration(5));
        this.binding.selfTestRecycler.setAdapter(this.selfTestItemAdapter);
        this.countDownTimer.start();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        this.countDownTimer.cancel();
        API.getInstance().UI_PostInt32(11, MessageID.MSG_APP_UTILITY_SELF_TEST, 0);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        API.getInstance().UI_PostInt32(11, MessageID.MSG_APP_UTILITY_SELF_TEST, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SelfTestParam> loadData() throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(API.getInstance().UI_QueryStr(11, MessageID.MSG_APP_UTILITY_SELF_TEST));
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i != 2 && i != 3) {
                try {
                    arrayList.add((SelfTestParam) GsonUtils.fromJson(jSONArray.get(i).toString(), (Class<Object>) SelfTestParam.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpanCount(List<SelfTestParam> list) {
        RecyclerView.LayoutManager layoutManager = this.binding.selfTestRecycler.getLayoutManager();
        int size = list.size() / 2;
        if (list.size() % 2 != 0) {
            size++;
        }
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanCount(size);
        }
    }
}
