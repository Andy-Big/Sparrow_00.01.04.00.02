package javax.mail;
/* loaded from: classes2.dex */
public class NoSuchProviderException extends MessagingException {
    private static final long serialVersionUID = 8058319293154708827L;

    public NoSuchProviderException() {
    }

    public NoSuchProviderException(String str) {
        super(str);
    }

    public NoSuchProviderException(String str, Exception exc) {
        super(str, exc);
    }
}
