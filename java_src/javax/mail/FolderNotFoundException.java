package javax.mail;
/* loaded from: classes2.dex */
public class FolderNotFoundException extends MessagingException {
    private static final long serialVersionUID = 472612108891249403L;
    private transient Folder folder;

    public FolderNotFoundException() {
    }

    public FolderNotFoundException(Folder folder) {
        this.folder = folder;
    }

    public FolderNotFoundException(Folder folder, String str) {
        super(str);
        this.folder = folder;
    }

    public FolderNotFoundException(Folder folder, String str, Exception exc) {
        super(str, exc);
        this.folder = folder;
    }

    public FolderNotFoundException(String str, Folder folder) {
        super(str);
        this.folder = folder;
    }

    public Folder getFolder() {
        return this.folder;
    }
}
