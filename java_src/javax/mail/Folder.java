package javax.mail;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Vector;
import java.util.concurrent.Executor;
import javax.mail.Flags;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.FolderEvent;
import javax.mail.event.FolderListener;
import javax.mail.event.MailEvent;
import javax.mail.event.MessageChangedEvent;
import javax.mail.event.MessageChangedListener;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;
import javax.mail.search.SearchTerm;
/* loaded from: classes2.dex */
public abstract class Folder implements AutoCloseable {
    public static final int HOLDS_FOLDERS = 2;
    public static final int HOLDS_MESSAGES = 1;
    public static final int READ_ONLY = 1;
    public static final int READ_WRITE = 2;
    private final EventQueue q;
    protected Store store;
    protected int mode = -1;
    private volatile Vector<ConnectionListener> connectionListeners = null;
    private volatile Vector<FolderListener> folderListeners = null;
    private volatile Vector<MessageCountListener> messageCountListeners = null;
    private volatile Vector<MessageChangedListener> messageChangedListeners = null;

    public abstract void appendMessages(Message[] messageArr) throws MessagingException;

    public abstract void close(boolean z) throws MessagingException;

    public abstract boolean create(int i) throws MessagingException;

    public abstract boolean delete(boolean z) throws MessagingException;

    public abstract boolean exists() throws MessagingException;

    public abstract Message[] expunge() throws MessagingException;

    public void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
    }

    public abstract Folder getFolder(String str) throws MessagingException;

    public abstract String getFullName();

    public abstract Message getMessage(int i) throws MessagingException;

    public abstract int getMessageCount() throws MessagingException;

    public abstract String getName();

    public abstract Folder getParent() throws MessagingException;

    public abstract Flags getPermanentFlags();

    public abstract char getSeparator() throws MessagingException;

    public abstract int getType() throws MessagingException;

    public abstract boolean hasNewMessages() throws MessagingException;

    public abstract boolean isOpen();

    public boolean isSubscribed() {
        return true;
    }

    public abstract Folder[] list(String str) throws MessagingException;

    public abstract void open(int i) throws MessagingException;

    public abstract boolean renameTo(Folder folder) throws MessagingException;

    /* JADX INFO: Access modifiers changed from: protected */
    public Folder(Store store) {
        this.store = store;
        Session session = store.getSession();
        String property = session.getProperties().getProperty("mail.event.scope", "folder");
        Executor executor = (Executor) session.getProperties().get("mail.event.executor");
        if (property.equalsIgnoreCase("application")) {
            this.q = EventQueue.getApplicationEventQueue(executor);
        } else if (property.equalsIgnoreCase("session")) {
            this.q = session.getEventQueue();
        } else if (property.equalsIgnoreCase("store")) {
            this.q = store.getEventQueue();
        } else {
            this.q = new EventQueue(executor);
        }
    }

    public URLName getURLName() throws MessagingException {
        URLName uRLName = getStore().getURLName();
        String fullName = getFullName();
        StringBuilder sb = new StringBuilder();
        if (fullName != null) {
            sb.append(fullName);
        }
        return new URLName(uRLName.getProtocol(), uRLName.getHost(), uRLName.getPort(), sb.toString(), uRLName.getUsername(), null);
    }

    public Store getStore() {
        return this.store;
    }

    public Folder[] listSubscribed(String str) throws MessagingException {
        return list(str);
    }

    public Folder[] list() throws MessagingException {
        return list("%");
    }

    public Folder[] listSubscribed() throws MessagingException {
        return listSubscribed("%");
    }

    public void setSubscribed(boolean z) throws MessagingException {
        throw new MethodNotSupportedException();
    }

    @Override // java.lang.AutoCloseable
    public void close() throws MessagingException {
        close(true);
    }

    public synchronized int getMode() {
        if (!isOpen()) {
            throw new IllegalStateException("Folder not open");
        }
        return this.mode;
    }

    public synchronized int getNewMessageCount() throws MessagingException {
        if (isOpen()) {
            int i = 0;
            int messageCount = getMessageCount();
            for (int i2 = 1; i2 <= messageCount; i2++) {
                try {
                    if (getMessage(i2).isSet(Flags.Flag.RECENT)) {
                        i++;
                    }
                } catch (MessageRemovedException unused) {
                }
            }
            return i;
        }
        return -1;
    }

    public synchronized int getUnreadMessageCount() throws MessagingException {
        if (isOpen()) {
            int i = 0;
            int messageCount = getMessageCount();
            for (int i2 = 1; i2 <= messageCount; i2++) {
                try {
                    if (!getMessage(i2).isSet(Flags.Flag.SEEN)) {
                        i++;
                    }
                } catch (MessageRemovedException unused) {
                }
            }
            return i;
        }
        return -1;
    }

    public synchronized int getDeletedMessageCount() throws MessagingException {
        if (isOpen()) {
            int i = 0;
            int messageCount = getMessageCount();
            for (int i2 = 1; i2 <= messageCount; i2++) {
                try {
                    if (getMessage(i2).isSet(Flags.Flag.DELETED)) {
                        i++;
                    }
                } catch (MessageRemovedException unused) {
                }
            }
            return i;
        }
        return -1;
    }

    public synchronized Message[] getMessages(int i, int i2) throws MessagingException {
        Message[] messageArr;
        messageArr = new Message[(i2 - i) + 1];
        for (int i3 = i; i3 <= i2; i3++) {
            messageArr[i3 - i] = getMessage(i3);
        }
        return messageArr;
    }

    public synchronized Message[] getMessages(int[] iArr) throws MessagingException {
        Message[] messageArr;
        int length = iArr.length;
        messageArr = new Message[length];
        for (int i = 0; i < length; i++) {
            messageArr[i] = getMessage(iArr[i]);
        }
        return messageArr;
    }

    public synchronized Message[] getMessages() throws MessagingException {
        Message[] messageArr;
        if (!isOpen()) {
            throw new IllegalStateException("Folder not open");
        }
        int messageCount = getMessageCount();
        messageArr = new Message[messageCount];
        for (int i = 1; i <= messageCount; i++) {
            messageArr[i - 1] = getMessage(i);
        }
        return messageArr;
    }

    public synchronized void setFlags(Message[] messageArr, Flags flags, boolean z) throws MessagingException {
        for (Message message : messageArr) {
            try {
                message.setFlags(flags, z);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    public synchronized void setFlags(int i, int i2, Flags flags, boolean z) throws MessagingException {
        while (i <= i2) {
            try {
                getMessage(i).setFlags(flags, z);
            } catch (MessageRemovedException unused) {
            }
            i++;
        }
    }

    public synchronized void setFlags(int[] iArr, Flags flags, boolean z) throws MessagingException {
        for (int i : iArr) {
            try {
                getMessage(i).setFlags(flags, z);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    public void copyMessages(Message[] messageArr, Folder folder) throws MessagingException {
        if (!folder.exists()) {
            throw new FolderNotFoundException(folder.getFullName() + " does not exist", folder);
        }
        folder.appendMessages(messageArr);
    }

    public Message[] search(SearchTerm searchTerm) throws MessagingException {
        return search(searchTerm, getMessages());
    }

    public Message[] search(SearchTerm searchTerm, Message[] messageArr) throws MessagingException {
        ArrayList arrayList = new ArrayList();
        for (Message message : messageArr) {
            try {
                if (message.match(searchTerm)) {
                    arrayList.add(message);
                }
            } catch (MessageRemovedException unused) {
            }
        }
        return (Message[]) arrayList.toArray(new Message[arrayList.size()]);
    }

    public synchronized void addConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners == null) {
            this.connectionListeners = new Vector<>();
        }
        this.connectionListeners.addElement(connectionListener);
    }

    public synchronized void removeConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners != null) {
            this.connectionListeners.removeElement(connectionListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyConnectionListeners(int i) {
        if (this.connectionListeners != null) {
            queueEvent(new ConnectionEvent(this, i), this.connectionListeners);
        }
        if (i == 3) {
            this.q.terminateQueue();
        }
    }

    public synchronized void addFolderListener(FolderListener folderListener) {
        if (this.folderListeners == null) {
            this.folderListeners = new Vector<>();
        }
        this.folderListeners.addElement(folderListener);
    }

    public synchronized void removeFolderListener(FolderListener folderListener) {
        if (this.folderListeners != null) {
            this.folderListeners.removeElement(folderListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyFolderListeners(int i) {
        if (this.folderListeners != null) {
            queueEvent(new FolderEvent(this, this, i), this.folderListeners);
        }
        this.store.notifyFolderListeners(i, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyFolderRenamedListeners(Folder folder) {
        if (this.folderListeners != null) {
            queueEvent(new FolderEvent(this, this, folder, 3), this.folderListeners);
        }
        this.store.notifyFolderRenamedListeners(this, folder);
    }

    public synchronized void addMessageCountListener(MessageCountListener messageCountListener) {
        if (this.messageCountListeners == null) {
            this.messageCountListeners = new Vector<>();
        }
        this.messageCountListeners.addElement(messageCountListener);
    }

    public synchronized void removeMessageCountListener(MessageCountListener messageCountListener) {
        if (this.messageCountListeners != null) {
            this.messageCountListeners.removeElement(messageCountListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyMessageAddedListeners(Message[] messageArr) {
        if (this.messageCountListeners == null) {
            return;
        }
        queueEvent(new MessageCountEvent(this, 1, false, messageArr), this.messageCountListeners);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyMessageRemovedListeners(boolean z, Message[] messageArr) {
        if (this.messageCountListeners == null) {
            return;
        }
        queueEvent(new MessageCountEvent(this, 2, z, messageArr), this.messageCountListeners);
    }

    public synchronized void addMessageChangedListener(MessageChangedListener messageChangedListener) {
        if (this.messageChangedListeners == null) {
            this.messageChangedListeners = new Vector<>();
        }
        this.messageChangedListeners.addElement(messageChangedListener);
    }

    public synchronized void removeMessageChangedListener(MessageChangedListener messageChangedListener) {
        if (this.messageChangedListeners != null) {
            this.messageChangedListeners.removeElement(messageChangedListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyMessageChangedListeners(int i, Message message) {
        if (this.messageChangedListeners == null) {
            return;
        }
        queueEvent(new MessageChangedEvent(this, i, message), this.messageChangedListeners);
    }

    private void queueEvent(MailEvent mailEvent, Vector<? extends EventListener> vector) {
        this.q.enqueue(mailEvent, (Vector) vector.clone());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            this.q.terminateQueue();
        } finally {
            super.finalize();
        }
    }

    public String toString() {
        String fullName = getFullName();
        return fullName != null ? fullName : super.toString();
    }
}
