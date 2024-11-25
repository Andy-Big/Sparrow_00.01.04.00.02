package com.sun.mail.pop3;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
/* loaded from: classes2.dex */
public class DefaultFolder extends Folder {
    @Override // javax.mail.Folder
    public boolean create(int i) throws MessagingException {
        return false;
    }

    @Override // javax.mail.Folder
    public boolean exists() {
        return true;
    }

    @Override // javax.mail.Folder
    public String getFullName() {
        return "";
    }

    @Override // javax.mail.Folder
    public int getMessageCount() throws MessagingException {
        return 0;
    }

    @Override // javax.mail.Folder
    public String getName() {
        return "";
    }

    @Override // javax.mail.Folder
    public Folder getParent() {
        return null;
    }

    @Override // javax.mail.Folder
    public char getSeparator() {
        return '/';
    }

    @Override // javax.mail.Folder
    public int getType() {
        return 2;
    }

    @Override // javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    @Override // javax.mail.Folder
    public boolean isOpen() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultFolder(POP3Store pOP3Store) {
        super(pOP3Store);
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        return new Folder[]{getInbox()};
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        if (!str.equalsIgnoreCase("INBOX")) {
            throw new MessagingException("only INBOX supported");
        }
        return getInbox();
    }

    protected Folder getInbox() throws MessagingException {
        return getStore().getFolder("INBOX");
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
    public void open(int i) throws MessagingException {
        throw new MethodNotSupportedException("open");
    }

    @Override // javax.mail.Folder
    public void close(boolean z) throws MessagingException {
        throw new MethodNotSupportedException("close");
    }

    @Override // javax.mail.Folder
    public Flags getPermanentFlags() {
        return new Flags();
    }

    @Override // javax.mail.Folder
    public Message getMessage(int i) throws MessagingException {
        throw new MethodNotSupportedException("getMessage");
    }

    @Override // javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Append not supported");
    }

    @Override // javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("expunge");
    }
}
