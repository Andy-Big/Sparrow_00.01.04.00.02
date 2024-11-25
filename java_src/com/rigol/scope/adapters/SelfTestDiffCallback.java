package com.rigol.scope.adapters;

import androidx.recyclerview.widget.DiffUtil;
import com.rigol.scope.data.SelfTestParam;
import java.util.List;
/* loaded from: classes.dex */
class SelfTestDiffCallback extends DiffUtil.Callback {
    private List<SelfTestParam> newParamList;
    private List<SelfTestParam> oldParamList;

    public SelfTestDiffCallback(List<SelfTestParam> list, List<SelfTestParam> list2) {
        this.oldParamList = list;
        this.newParamList = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.oldParamList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.newParamList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        return this.oldParamList.get(i).toString().equals(this.newParamList.get(i2).toString());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        return this.oldParamList.get(i).toString().equals(this.newParamList.get(i2).toString());
    }
}
