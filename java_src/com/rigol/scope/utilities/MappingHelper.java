package com.rigol.scope.utilities;

import android.content.Context;
import androidx.collection.SparseArrayCompat;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.rigol.scope.data.MappingObject;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MappingHelper {
    private static MappingHelper instance;
    private final SparseArrayCompat<SparseArrayCompat<MappingObject>> res1 = new SparseArrayCompat<>();
    private final SparseArrayCompat<List<MappingObject>> res2 = new SparseArrayCompat<>();

    private MappingHelper() {
    }

    public static MappingHelper getInstance() {
        if (instance == null) {
            synchronized (MappingHelper.class) {
                if (instance == null) {
                    instance = new MappingHelper();
                }
            }
        }
        return instance;
    }

    public void reload(Context context) {
        if (!this.res1.isEmpty()) {
            for (int i = 0; i < this.res1.size(); i++) {
                SparseArrayCompat<MappingObject> valueAt = this.res1.valueAt(i);
                for (int i2 = 0; i2 < valueAt.size(); i2++) {
                    MappingObject valueAt2 = valueAt.valueAt(i2);
                    if (valueAt2.getStrId() != 0) {
                        valueAt2.setStr(context.getString(valueAt2.getStrId()));
                        valueAt.setValueAt(i2, valueAt2);
                    }
                }
            }
        }
        if (this.res2.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < this.res2.size(); i3++) {
            List<MappingObject> valueAt3 = this.res2.valueAt(i3);
            if (valueAt3 != null && !valueAt3.isEmpty()) {
                for (int i4 = 0; i4 < valueAt3.size(); i4++) {
                    MappingObject mappingObject = valueAt3.get(i4);
                    if (mappingObject.getStrId() != 0) {
                        mappingObject.setStr(context.getString(mappingObject.getStrId()));
                        valueAt3.set(i4, mappingObject);
                    }
                }
            }
        }
    }

    public SparseArrayCompat<MappingObject> getArray(int i) {
        if (!this.res1.containsKey(i)) {
            SparseArrayCompat<MappingObject> convertToArray = convertToArray(i);
            this.res1.put(i, convertToArray);
            print(convertToArray, this.res1);
        }
        return this.res1.get(i);
    }

    private void print(SparseArrayCompat<MappingObject> sparseArrayCompat, SparseArrayCompat<?> sparseArrayCompat2) {
        for (int i = 0; i < sparseArrayCompat.size(); i++) {
            sparseArrayCompat.valueAt(i);
        }
    }

    public List<MappingObject> getList(int i) {
        if (!this.res2.containsKey(i)) {
            List<MappingObject> convertToList = convertToList(i);
            this.res2.put(i, convertToList);
            print(convertToList, this.res2);
        }
        return this.res2.get(i);
    }

    private void print(List<MappingObject> list, SparseArrayCompat<?> sparseArrayCompat) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
    }

    private List<MappingObject> convertToList(int i) {
        String[] stringArray = ActivityUtils.getTopActivity().getResources().getStringArray(i);
        ArrayList arrayList = new ArrayList();
        for (String str : stringArray) {
            try {
                MappingObject mappingObject = (MappingObject) GsonUtils.fromJson(str, (Class<Object>) MappingObject.class);
                mappingObject.parse(ActivityUtils.getTopActivity());
                arrayList.add(mappingObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private SparseArrayCompat<MappingObject> convertToArray(int i) {
        String[] stringArray = ActivityUtils.getTopActivity().getResources().getStringArray(i);
        SparseArrayCompat<MappingObject> sparseArrayCompat = new SparseArrayCompat<>();
        for (String str : stringArray) {
            try {
                MappingObject mappingObject = (MappingObject) GsonUtils.fromJson(str, (Class<Object>) MappingObject.class);
                mappingObject.parse(ActivityUtils.getTopActivity());
                sparseArrayCompat.put(mappingObject.getValue(), mappingObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sparseArrayCompat;
    }
}
