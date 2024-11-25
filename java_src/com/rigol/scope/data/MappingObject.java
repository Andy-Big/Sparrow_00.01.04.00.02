package com.rigol.scope.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.content.ContextCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import java.util.List;
/* loaded from: classes2.dex */
public class MappingObject extends BaseObservable {
    private String keyAStr;
    private String keyBStr;
    private String pi;
    private Drawable pic;
    private int picId;
    private String si;
    private String str;
    private int strId;
    private String v;
    private int value;

    public String getKeyAStr() {
        String str = this.keyAStr;
        return str == null ? "" : str;
    }

    public void setKeyAStr(String str) {
        this.keyAStr = str;
    }

    public String getKeyBStr() {
        String str = this.keyBStr;
        return str == null ? "" : str;
    }

    public void setKeyBStr(String str) {
        this.keyBStr = str;
    }

    public String getSi() {
        return this.si;
    }

    public void setSi(String str) {
        this.si = str;
    }

    public String getV() {
        return this.v;
    }

    public void setV(String str) {
        this.v = str;
    }

    public String getPi() {
        return this.pi;
    }

    public void setPi(String str) {
        this.pi = str;
    }

    @Bindable
    public String getStr() {
        return this.str;
    }

    public void setStr(String str) {
        this.str = str;
        notifyPropertyChanged(915);
    }

    public int getStrId() {
        return this.strId;
    }

    public void setStrId(int i) {
        this.strId = i;
    }

    @Bindable
    public Drawable getPic() {
        return this.pic;
    }

    public void setPic(Drawable drawable) {
        this.pic = drawable;
        notifyPropertyChanged(638);
    }

    public int getPicId() {
        return this.picId;
    }

    public void setPicId(int i) {
        this.picId = i;
    }

    @Bindable
    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        this.value = i;
        notifyPropertyChanged(1015);
    }

    public void parse(Context context) {
        if (!TextUtils.isEmpty(this.si)) {
            int identifier = ContextUtil.getIdentifier(context, this.si, "string");
            this.strId = identifier;
            if (identifier != 0) {
                this.str = context.getResources().getString(this.strId);
            }
        }
        if (!TextUtils.isEmpty(this.pi)) {
            try {
                int identifier2 = ContextUtil.getIdentifier(context, this.pi, "drawable");
                this.picId = identifier2;
                if (identifier2 != 0) {
                    setPic(ContextCompat.getDrawable(context, identifier2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(this.v)) {
            return;
        }
        this.value = Integer.parseInt(this.v);
    }

    public static SparseArray<MappingObject> createMappingByValue(Context context, int... iArr) {
        SparseArray<MappingObject> sparseArray = new SparseArray<>();
        for (int i : iArr) {
            for (MappingObject mappingObject : ViewUtil.getList(i)) {
                sparseArray.put(mappingObject.getValue(), mappingObject);
            }
        }
        return sparseArray;
    }

    public static int indexOf(List<MappingObject> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i).getStr();
            if (str2 != null && str2.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return "MappingObject{si='" + this.si + "', v='" + this.v + "', pi='" + this.pi + "', str='" + this.str + "', strId=" + this.strId + ", pic=" + this.pic + ", picId=" + this.picId + ", value=" + this.value + '}';
    }
}
