package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.ListInfo;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
import kotlin.jvm.internal.CharCompanionObject;
/* loaded from: classes2.dex */
public class DefaultFolder extends IMAPFolder {
    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder getParent() {
        return null;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultFolder(IMAPStore iMAPStore) {
        super("", CharCompanionObject.MAX_VALUE, iMAPStore, null);
        this.exists = true;
        this.type = 2;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public synchronized String getName() {
        return this.fullName;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public synchronized Folder[] list(final String str) throws MessagingException {
        ListInfo[] listInfoArr = (ListInfo[]) doCommand(new IMAPFolder.ProtocolCommand() { // from class: com.sun.mail.imap.DefaultFolder.1
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.list("", str);
            }
        });
        if (listInfoArr == null) {
            return new Folder[0];
        }
        int length = listInfoArr.length;
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[length];
        for (int i = 0; i < length; i++) {
            iMAPFolderArr[i] = ((IMAPStore) this.store).newIMAPFolder(listInfoArr[i]);
        }
        return iMAPFolderArr;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public synchronized Folder[] listSubscribed(final String str) throws MessagingException {
        ListInfo[] listInfoArr = (ListInfo[]) doCommand(new IMAPFolder.ProtocolCommand() { // from class: com.sun.mail.imap.DefaultFolder.2
            @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
            public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
                return iMAPProtocol.lsub("", str);
            }
        });
        if (listInfoArr == null) {
            return new Folder[0];
        }
        int length = listInfoArr.length;
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[length];
        for (int i = 0; i < length; i++) {
            iMAPFolderArr[i] = ((IMAPStore) this.store).newIMAPFolder(listInfoArr[i]);
        }
        return iMAPFolderArr;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        return ((IMAPStore) this.store).newIMAPFolder(str, CharCompanionObject.MAX_VALUE);
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean delete(boolean z) throws MessagingException {
        throw new MethodNotSupportedException("Cannot delete Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("Cannot rename Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Cannot append to Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Cannot expunge Default Folder");
    }
}
