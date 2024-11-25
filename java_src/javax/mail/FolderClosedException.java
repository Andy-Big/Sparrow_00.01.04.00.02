package javax.mail;
/* loaded from: classes2.dex */
public class FolderClosedException extends MessagingException {
    private static final long serialVersionUID = 1687879213433302315L;
    private transient Folder folder;

    public FolderClosedException(Folder folder) {
        this(folder, null);
    }

    public FolderClosedException(Folder folder, String str) {
        super(str);
        this.folder = folder;
    }

    public FolderClosedException(Folder folder, String str, Exception exc) {
        super(str, exc);
        this.folder = folder;
    }

    public Folder getFolder() {
        return this.folder;
    }
}
