package javax.mail;
/* loaded from: classes2.dex */
public class ReadOnlyFolderException extends MessagingException {
    private static final long serialVersionUID = 5711829372799039325L;
    private transient Folder folder;

    public ReadOnlyFolderException(Folder folder) {
        this(folder, null);
    }

    public ReadOnlyFolderException(Folder folder, String str) {
        super(str);
        this.folder = folder;
    }

    public ReadOnlyFolderException(Folder folder, String str, Exception exc) {
        super(str, exc);
        this.folder = folder;
    }

    public Folder getFolder() {
        return this.folder;
    }
}
