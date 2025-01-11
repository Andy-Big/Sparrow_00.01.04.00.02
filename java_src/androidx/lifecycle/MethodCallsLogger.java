package androidx.lifecycle;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class MethodCallsLogger {
    private Map<String, Integer> mCalledMethods = new HashMap();

    public boolean approveCall(String str, int i) {
        Integer num = this.mCalledMethods.get(str);
        int intValue = num != null ? num.intValue() : 0;
        boolean z = (intValue & i) != 0;
        this.mCalledMethods.put(str, Integer.valueOf(i | intValue));
        return !z;
    }
}
