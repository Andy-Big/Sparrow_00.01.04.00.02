package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class MergedDataBinderMapper extends DataBinderMapper {
    private static final String TAG = "MergedDataBinderMapper";
    private Set<Class<? extends DataBinderMapper>> mExistingMappers = new HashSet();
    private List<DataBinderMapper> mMappers = new CopyOnWriteArrayList();
    private List<String> mFeatureBindingMappers = new CopyOnWriteArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    public void addMapper(DataBinderMapper dataBinderMapper) {
        if (this.mExistingMappers.add(dataBinderMapper.getClass())) {
            this.mMappers.add(dataBinderMapper);
            for (DataBinderMapper dataBinderMapper2 : dataBinderMapper.collectDependencies()) {
                addMapper(dataBinderMapper2);
            }
        }
    }

    protected void addMapper(String str) {
        List<String> list = this.mFeatureBindingMappers;
        list.add(str + ".DataBinderMapperImpl");
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        for (DataBinderMapper dataBinderMapper : this.mMappers) {
            ViewDataBinding dataBinder = dataBinderMapper.getDataBinder(dataBindingComponent, view, i);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, view, i);
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        for (DataBinderMapper dataBinderMapper : this.mMappers) {
            ViewDataBinding dataBinder = dataBinderMapper.getDataBinder(dataBindingComponent, viewArr, i);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, viewArr, i);
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        for (DataBinderMapper dataBinderMapper : this.mMappers) {
            int layoutId = dataBinderMapper.getLayoutId(str);
            if (layoutId != 0) {
                return layoutId;
            }
        }
        if (loadFeatures()) {
            return getLayoutId(str);
        }
        return 0;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        for (DataBinderMapper dataBinderMapper : this.mMappers) {
            String convertBrIdToString = dataBinderMapper.convertBrIdToString(i);
            if (convertBrIdToString != null) {
                return convertBrIdToString;
            }
        }
        if (loadFeatures()) {
            return convertBrIdToString(i);
        }
        return null;
    }

    private boolean loadFeatures() {
        boolean z = false;
        for (String str : this.mFeatureBindingMappers) {
            try {
                Class<?> cls = Class.forName(str);
                if (DataBinderMapper.class.isAssignableFrom(cls)) {
                    addMapper((DataBinderMapper) cls.newInstance());
                    this.mFeatureBindingMappers.remove(str);
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e) {
                Log.e(TAG, "unable to add feature mapper for " + str, e);
            } catch (InstantiationException e2) {
                Log.e(TAG, "unable to add feature mapper for " + str, e2);
            }
        }
        return z;
    }
}
