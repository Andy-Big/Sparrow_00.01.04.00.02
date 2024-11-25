package com.rigol.pinyinkeyboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class CandiateViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private String[] astrHanziList;
    private Context mContext;
    private TypeWritingInterface mTypeWritingInterface;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvData;

        ViewHolder(View view) {
            super(view);
            this.tvData = (TextView) view.findViewById(R.id.hanzi_item);
        }
    }

    public CandiateViewAdapter(Context context, String[] strArr, TypeWritingInterface typeWritingInterface) {
        this.mContext = context;
        this.astrHanziList = strArr;
        this.mTypeWritingInterface = typeWritingInterface;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.candiate_view_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.tvData.setText(this.astrHanziList[i]);
        viewHolder.tvData.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.pinyinkeyboard.CandiateViewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CandiateViewAdapter.this.mTypeWritingInterface.updateInputMessage(CandiateViewAdapter.this.astrHanziList[i]);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.astrHanziList.length;
    }
}
