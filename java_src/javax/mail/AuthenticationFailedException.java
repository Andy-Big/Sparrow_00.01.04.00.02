package javax.mail;
/* loaded from: classes2.dex */
public class AuthenticationFailedException extends MessagingException {
    private static final long serialVersionUID = 492080754054436511L;

    public AuthenticationFailedException() {
    }

    public AuthenticationFailedException(String str) {
        super(str);
    }

    public AuthenticationFailedException(String str, Exception exc) {
        super(str, exc);
    }
}
