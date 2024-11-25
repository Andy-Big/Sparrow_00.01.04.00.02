package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HelperReference {
    private HelperWidget mHelperWidget;
    protected ArrayList<Object> mReferences = new ArrayList<>();
    protected final State mState;
    final State.Helper mType;

    public void apply() {
    }

    public HelperReference(State state, State.Helper helper) {
        this.mState = state;
        this.mType = helper;
    }

    public State.Helper getType() {
        return this.mType;
    }

    public HelperReference add(Object... objArr) {
        for (Object obj : objArr) {
            this.mReferences.add(obj);
        }
        return this;
    }

    public void setHelperWidget(HelperWidget helperWidget) {
        this.mHelperWidget = helperWidget;
    }

    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }
}
