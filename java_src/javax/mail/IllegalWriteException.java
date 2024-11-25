package javax.mail;
/* loaded from: classes2.dex */
public class IllegalWriteException extends MessagingException {
    private static final long serialVersionUID = 3974370223328268013L;

    public IllegalWriteException() {
    }

    public IllegalWriteException(String str) {
        super(str);
    }

    public IllegalWriteException(String str, Exception exc) {
        super(str, exc);
    }
}
