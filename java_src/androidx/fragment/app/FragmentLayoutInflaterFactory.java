package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    private final FragmentManager mFragmentManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.mFragmentManager);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(R.styleable.Fragment_android_name);
            }
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
            String string = obtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
            obtainStyledAttributes.recycle();
            if (attributeValue == null || !FragmentFactory.isFragmentClass(context.getClassLoader(), attributeValue)) {
                return null;
            }
            int id = view != null ? view.getId() : 0;
            if (id == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
            }
            Fragment findFragmentById = resourceId != -1 ? this.mFragmentManager.findFragmentById(resourceId) : null;
            if (findFragmentById == null && string != null) {
                findFragmentById = this.mFragmentManager.findFragmentByTag(string);
            }
            if (findFragmentById == null && id != -1) {
                findFragmentById = this.mFragmentManager.findFragmentById(id);
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(TAG, "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + findFragmentById);
            }
            if (findFragmentById == null) {
                findFragmentById = this.mFragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
                findFragmentById.mFromLayout = true;
                findFragmentById.mFragmentId = resourceId != 0 ? resourceId : id;
                findFragmentById.mContainerId = id;
                findFragmentById.mTag = string;
                findFragmentById.mInLayout = true;
                findFragmentById.mFragmentManager = this.mFragmentManager;
                findFragmentById.mHost = this.mFragmentManager.mHost;
                findFragmentById.onInflate(this.mFragmentManager.mHost.getContext(), attributeSet, findFragmentById.mSavedFragmentState);
                this.mFragmentManager.addFragment(findFragmentById);
                this.mFragmentManager.moveToState(findFragmentById);
            } else if (findFragmentById.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            } else {
                findFragmentById.mInLayout = true;
                findFragmentById.mHost = this.mFragmentManager.mHost;
                findFragmentById.onInflate(this.mFragmentManager.mHost.getContext(), attributeSet, findFragmentById.mSavedFragmentState);
            }
            if (this.mFragmentManager.mCurState < 1 && findFragmentById.mFromLayout) {
                this.mFragmentManager.moveToState(findFragmentById, 1);
            } else {
                this.mFragmentManager.moveToState(findFragmentById);
            }
            if (findFragmentById.mView == null) {
                throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
            }
            if (resourceId != 0) {
                findFragmentById.mView.setId(resourceId);
            }
            if (findFragmentById.mView.getTag() == null) {
                findFragmentById.mView.setTag(string);
            }
            return findFragmentById.mView;
        }
        return null;
    }
}
