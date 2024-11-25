package javax.mail;
/* loaded from: classes2.dex */
public class SendFailedException extends MessagingException {
    private static final long serialVersionUID = -6457531621682372913L;
    protected transient Address[] invalid;
    protected transient Address[] validSent;
    protected transient Address[] validUnsent;

    public SendFailedException() {
    }

    public SendFailedException(String str) {
        super(str);
    }

    public SendFailedException(String str, Exception exc) {
        super(str, exc);
    }

    public SendFailedException(String str, Exception exc, Address[] addressArr, Address[] addressArr2, Address[] addressArr3) {
        super(str, exc);
        this.validSent = addressArr;
        this.validUnsent = addressArr2;
        this.invalid = addressArr3;
    }

    public Address[] getValidSentAddresses() {
        return this.validSent;
    }

    public Address[] getValidUnsentAddresses() {
        return this.validUnsent;
    }

    public Address[] getInvalidAddresses() {
        return this.invalid;
    }
}
