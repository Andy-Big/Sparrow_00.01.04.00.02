package javax.mail;
/* loaded from: classes2.dex */
public class MethodNotSupportedException extends MessagingException {
    private static final long serialVersionUID = -3757386618726131322L;

    public MethodNotSupportedException() {
    }

    public MethodNotSupportedException(String str) {
        super(str);
    }

    public MethodNotSupportedException(String str, Exception exc) {
        super(str, exc);
    }
}
