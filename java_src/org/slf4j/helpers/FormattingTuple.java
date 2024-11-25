package org.slf4j.helpers;
/* loaded from: classes2.dex */
public class FormattingTuple {
    public static FormattingTuple NULL = new FormattingTuple(null);
    private Object[] argArray;
    private String message;
    private Throwable throwable;

    public FormattingTuple(String str) {
        this(str, null, null);
    }

    public FormattingTuple(String str, Object[] objArr, Throwable th) {
        this.message = str;
        this.throwable = th;
        this.argArray = objArr;
    }

    public String getMessage() {
        return this.message;
    }

    public Object[] getArgArray() {
        return this.argArray;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
