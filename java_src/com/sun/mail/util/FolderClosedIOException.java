package com.sun.mail.util;

import java.io.IOException;
import javax.mail.Folder;
/* loaded from: classes2.dex */
public class FolderClosedIOException extends IOException {
    private static final long serialVersionUID = 4281122580365555735L;
    private transient Folder folder;

    public FolderClosedIOException(Folder folder) {
        this(folder, null);
    }

    public FolderClosedIOException(Folder folder, String str) {
        super(str);
        this.folder = folder;
    }

    public Folder getFolder() {
        return this.folder;
    }
}
