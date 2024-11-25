package javax.mail;
/* loaded from: classes2.dex */
public class MessagingException extends Exception {
    private static final long serialVersionUID = -7569192289819959253L;
    private Exception next;

    public MessagingException() {
        initCause(null);
    }

    public MessagingException(String str) {
        super(str);
        initCause(null);
    }

    public MessagingException(String str, Exception exc) {
        super(str);
        this.next = exc;
        initCause(null);
    }

    public synchronized Exception getNextException() {
        return this.next;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        return this.next;
    }

    public synchronized boolean setNextException(Exception exc) {
        Exception exc2 = this;
        while ((exc2 instanceof MessagingException) && ((MessagingException) exc2).next != null) {
            exc2 = ((MessagingException) exc2).next;
        }
        if (exc2 instanceof MessagingException) {
            ((MessagingException) exc2).next = exc;
            return true;
        }
        return false;
    }

    @Override // java.lang.Throwable
    public synchronized String toString() {
        String exc = super.toString();
        Exception exc2 = this.next;
        if (exc2 == null) {
            return exc;
        }
        if (exc == null) {
            exc = "";
        }
        StringBuilder sb = new StringBuilder(exc);
        while (exc2 != null) {
            sb.append(";\n  nested exception is:\n\t");
            if (exc2 instanceof MessagingException) {
                MessagingException messagingException = (MessagingException) exc2;
                sb.append(messagingException.superToString());
                exc2 = messagingException.next;
            } else {
                sb.append(exc2.toString());
                exc2 = null;
            }
        }
        return sb.toString();
    }

    private final String superToString() {
        return super.toString();
    }
}
