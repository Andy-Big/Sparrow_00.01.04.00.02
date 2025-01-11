package javax.mail;

/* loaded from: classes2.dex */
public abstract class BodyPart implements Part {
    protected Multipart parent;

    public Multipart getParent() {
        return this.parent;
    }

    void setParent(Multipart multipart) {
        this.parent = multipart;
    }
}
