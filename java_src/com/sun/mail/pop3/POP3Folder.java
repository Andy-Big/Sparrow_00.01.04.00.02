package com.sun.mail.pop3;

import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.MailLogger;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
import javax.mail.UIDFolder;

/* loaded from: classes2.dex */
public class POP3Folder extends Folder {
    private boolean doneUidl;
    private boolean exists;
    private volatile TempFile fileCache;
    private boolean forceClose;
    MailLogger logger;
    private POP3Message[] message_cache;
    private String name;
    private volatile boolean opened;
    private volatile Protocol port;
    private int size;
    private POP3Store store;
    private int total;

    @Override // javax.mail.Folder
    public boolean create(int i) throws MessagingException {
        return false;
    }

    @Override // javax.mail.Folder
    public char getSeparator() {
        return (char) 0;
    }

    @Override // javax.mail.Folder
    public int getType() {
        return 1;
    }

    @Override // javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    protected POP3Folder(POP3Store pOP3Store, String str) {
        super(pOP3Store);
        this.exists = false;
        this.opened = false;
        this.doneUidl = false;
        this.fileCache = null;
        this.name = str;
        this.store = pOP3Store;
        if (str.equalsIgnoreCase("INBOX")) {
            this.exists = true;
        }
        this.logger = new MailLogger(getClass(), "DEBUG POP3", pOP3Store.getSession().getDebug(), pOP3Store.getSession().getDebugOut());
    }

    @Override // javax.mail.Folder
    public String getName() {
        return this.name;
    }

    @Override // javax.mail.Folder
    public String getFullName() {
        return this.name;
    }

    @Override // javax.mail.Folder
    public Folder getParent() {
        return new DefaultFolder(this.store);
    }

    @Override // javax.mail.Folder
    public boolean exists() {
        return this.exists;
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    @Override // javax.mail.Folder
    public boolean delete(boolean z) throws MessagingException {
        throw new MethodNotSupportedException("delete");
    }

    @Override // javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("renameTo");
    }

    @Override // javax.mail.Folder
    public synchronized void open(int i) throws MessagingException {
        POP3Store pOP3Store;
        checkClosed();
        if (!this.exists) {
            throw new FolderNotFoundException(this, "folder is not INBOX");
        }
        try {
            this.port = this.store.getPort(this);
            Status stat = this.port.stat();
            this.total = stat.total;
            this.size = stat.size;
            this.mode = i;
            if (this.store.useFileCache) {
                try {
                    this.fileCache = new TempFile(this.store.fileCacheDir);
                } catch (IOException e) {
                    this.logger.log(Level.FINE, "failed to create file cache", (Throwable) e);
                    throw e;
                }
            }
            this.opened = true;
            this.message_cache = new POP3Message[this.total];
            this.doneUidl = false;
            notifyConnectionListeners(1);
        } catch (IOException e2) {
            try {
                if (this.port != null) {
                    this.port.quit();
                }
                this.port = null;
                pOP3Store = this.store;
            } catch (IOException unused) {
                this.port = null;
                pOP3Store = this.store;
            } catch (Throwable th) {
                this.port = null;
                this.store.closePort(this);
                throw th;
            }
            pOP3Store.closePort(this);
            throw new MessagingException("Open failed", e2);
        }
    }

    @Override // javax.mail.Folder
    public synchronized void close(boolean z) throws MessagingException {
        checkOpen();
        try {
            if (this.store.rsetBeforeQuit && !this.forceClose) {
                this.port.rset();
            }
            if (z && this.mode == 2 && !this.forceClose) {
                for (int i = 0; i < this.message_cache.length; i++) {
                    POP3Message pOP3Message = this.message_cache[i];
                    if (pOP3Message != null && pOP3Message.isSet(Flags.Flag.DELETED)) {
                        try {
                            this.port.dele(i + 1);
                        } catch (IOException e) {
                            throw new MessagingException("Exception deleting messages during close", e);
                        }
                    }
                }
            }
            for (int i2 = 0; i2 < this.message_cache.length; i2++) {
                POP3Message pOP3Message2 = this.message_cache[i2];
                if (pOP3Message2 != null) {
                    pOP3Message2.invalidate(true);
                }
            }
            if (this.forceClose) {
                this.port.close();
            } else {
                this.port.quit();
            }
            this.port = null;
            this.store.closePort(this);
            this.message_cache = null;
            this.opened = false;
            notifyConnectionListeners(3);
        } catch (IOException unused) {
            this.port = null;
            this.store.closePort(this);
            this.message_cache = null;
            this.opened = false;
            notifyConnectionListeners(3);
            if (this.fileCache != null) {
                this.fileCache.close();
            }
        }
        if (this.fileCache != null) {
            this.fileCache.close();
            this.fileCache = null;
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean isOpen() {
        if (this.opened) {
            try {
                try {
                    if (this.port.noop()) {
                        return true;
                    }
                    throw new IOException("NOOP failed");
                } catch (IOException unused) {
                    close(false);
                    return false;
                }
            } catch (MessagingException unused2) {
                return false;
            }
        }
        return false;
    }

    @Override // javax.mail.Folder
    public Flags getPermanentFlags() {
        return new Flags();
    }

    @Override // javax.mail.Folder
    public synchronized int getMessageCount() throws MessagingException {
        if (this.opened) {
            checkReadable();
            return this.total;
        }
        return -1;
    }

    @Override // javax.mail.Folder
    public synchronized Message getMessage(int i) throws MessagingException {
        POP3Message pOP3Message;
        checkOpen();
        int i2 = i - 1;
        pOP3Message = this.message_cache[i2];
        if (pOP3Message == null) {
            pOP3Message = createMessage(this, i);
            this.message_cache[i2] = pOP3Message;
        }
        return pOP3Message;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected POP3Message createMessage(Folder folder, int i) throws MessagingException {
        POP3Message pOP3Message;
        Constructor<?> constructor = this.store.messageConstructor;
        if (constructor != null) {
            try {
                pOP3Message = (POP3Message) constructor.newInstance(this, Integer.valueOf(i));
            } catch (Exception unused) {
            }
            return pOP3Message != null ? new POP3Message(this, i) : pOP3Message;
        }
        pOP3Message = null;
        if (pOP3Message != null) {
        }
    }

    @Override // javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Append not supported");
    }

    @Override // javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Expunge not supported");
    }

    @Override // javax.mail.Folder
    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        checkReadable();
        if (!this.doneUidl && this.store.supportsUidl && fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
            int length = this.message_cache.length;
            String[] strArr = new String[length];
            try {
                try {
                    if (!this.port.uidl(strArr)) {
                        return;
                    }
                    for (int i = 0; i < length; i++) {
                        if (strArr[i] != null) {
                            ((POP3Message) getMessage(i + 1)).uid = strArr[i];
                        }
                    }
                    this.doneUidl = true;
                } catch (EOFException e) {
                    close(false);
                    throw new FolderClosedException(this, e.toString());
                }
            } catch (IOException e2) {
                throw new MessagingException("error getting UIDL", e2);
            }
        }
        if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
            for (Message message : messageArr) {
                try {
                    POP3Message pOP3Message = (POP3Message) message;
                    pOP3Message.getHeader("");
                    pOP3Message.getSize();
                } catch (MessageRemovedException unused) {
                }
            }
        }
    }

    public synchronized String getUID(Message message) throws MessagingException {
        checkOpen();
        if (!(message instanceof POP3Message)) {
            throw new MessagingException("message is not a POP3Message");
        }
        POP3Message pOP3Message = (POP3Message) message;
        try {
            if (this.store.supportsUidl) {
                if (pOP3Message.uid == "UNKNOWN") {
                    pOP3Message.uid = this.port.uidl(pOP3Message.getMessageNumber());
                }
                return pOP3Message.uid;
            }
            return null;
        } catch (EOFException e) {
            close(false);
            throw new FolderClosedException(this, e.toString());
        } catch (IOException e2) {
            throw new MessagingException("error getting UIDL", e2);
        }
    }

    public synchronized int getSize() throws MessagingException {
        checkOpen();
        return this.size;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005d, code lost:
        if (r2 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int[] getSizes() throws MessagingException {
        int[] iArr;
        InputStream inputStream;
        checkOpen();
        iArr = new int[this.total];
        LineInputStream lineInputStream = null;
        try {
            inputStream = this.port.list();
            try {
                LineInputStream lineInputStream2 = new LineInputStream(inputStream);
                while (true) {
                    try {
                        String readLine = lineInputStream2.readLine();
                        if (readLine != null) {
                            try {
                                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                                int parseInt = Integer.parseInt(stringTokenizer.nextToken());
                                int parseInt2 = Integer.parseInt(stringTokenizer.nextToken());
                                if (parseInt > 0 && parseInt <= this.total) {
                                    iArr[parseInt - 1] = parseInt2;
                                }
                            } catch (RuntimeException unused) {
                            }
                        } else {
                            try {
                                break;
                            } catch (IOException unused2) {
                            }
                        }
                    } catch (IOException unused3) {
                        lineInputStream = lineInputStream2;
                        if (lineInputStream != null) {
                            try {
                                lineInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        lineInputStream = lineInputStream2;
                        if (lineInputStream != null) {
                            try {
                                lineInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        throw th;
                    }
                }
                lineInputStream2.close();
            } catch (IOException unused7) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused8) {
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
        return iArr;
    }

    public synchronized InputStream listCommand() throws MessagingException, IOException {
        checkOpen();
        return this.port.list();
    }

    @Override // javax.mail.Folder
    protected void finalize() throws Throwable {
        this.forceClose = !this.store.finalizeCleanClose;
        try {
            if (this.opened) {
                close(false);
            }
        } finally {
            super.finalize();
            this.forceClose = false;
        }
    }

    private void checkOpen() throws IllegalStateException {
        if (!this.opened) {
            throw new IllegalStateException("Folder is not Open");
        }
    }

    private void checkClosed() throws IllegalStateException {
        if (this.opened) {
            throw new IllegalStateException("Folder is Open");
        }
    }

    private void checkReadable() throws IllegalStateException {
        if (!this.opened || (this.mode != 1 && this.mode != 2)) {
            throw new IllegalStateException("Folder is not Readable");
        }
    }

    Protocol getProtocol() throws MessagingException {
        Protocol protocol = this.port;
        checkOpen();
        return protocol;
    }

    @Override // javax.mail.Folder
    protected void notifyMessageChangedListeners(int i, Message message) {
        super.notifyMessageChangedListeners(i, message);
    }

    TempFile getFileCache() {
        return this.fileCache;
    }
}
