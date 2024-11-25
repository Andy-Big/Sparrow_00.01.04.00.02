package javax.mail;
/* loaded from: classes2.dex */
public class MessageRemovedException extends MessagingException {
    private static final long serialVersionUID = 1951292550679528690L;

    public MessageRemovedException() {
    }

    public MessageRemovedException(String str) {
        super(str);
    }

    public MessageRemovedException(String str, Exception exc) {
        super(str, exc);
    }
}
