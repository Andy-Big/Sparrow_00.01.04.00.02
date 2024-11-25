package javax.mail;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;
import javax.mail.Flags;
import javax.mail.search.SearchTerm;
/* loaded from: classes2.dex */
public abstract class Message implements Part {
    protected boolean expunged;
    protected Folder folder;
    protected int msgnum;
    protected Session session;

    public abstract void addFrom(Address[] addressArr) throws MessagingException;

    public abstract void addRecipients(RecipientType recipientType, Address[] addressArr) throws MessagingException;

    public abstract Flags getFlags() throws MessagingException;

    public abstract Address[] getFrom() throws MessagingException;

    public abstract Date getReceivedDate() throws MessagingException;

    public abstract Address[] getRecipients(RecipientType recipientType) throws MessagingException;

    public abstract Date getSentDate() throws MessagingException;

    public abstract String getSubject() throws MessagingException;

    public abstract Message reply(boolean z) throws MessagingException;

    public abstract void saveChanges() throws MessagingException;

    public abstract void setFlags(Flags flags, boolean z) throws MessagingException;

    public abstract void setFrom() throws MessagingException;

    public abstract void setFrom(Address address) throws MessagingException;

    public abstract void setRecipients(RecipientType recipientType, Address[] addressArr) throws MessagingException;

    public abstract void setSentDate(Date date) throws MessagingException;

    public abstract void setSubject(String str) throws MessagingException;

    protected Message() {
        this.msgnum = 0;
        this.expunged = false;
        this.folder = null;
        this.session = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message(Folder folder, int i) {
        this.msgnum = 0;
        this.expunged = false;
        this.folder = null;
        this.session = null;
        this.folder = folder;
        this.msgnum = i;
        this.session = folder.store.session;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message(Session session) {
        this.msgnum = 0;
        this.expunged = false;
        this.folder = null;
        this.session = null;
        this.session = session;
    }

    public Session getSession() {
        return this.session;
    }

    /* loaded from: classes2.dex */
    public static class RecipientType implements Serializable {
        private static final long serialVersionUID = -7479791750606340008L;
        protected String type;
        public static final RecipientType TO = new RecipientType("To");
        public static final RecipientType CC = new RecipientType("Cc");
        public static final RecipientType BCC = new RecipientType("Bcc");

        /* JADX INFO: Access modifiers changed from: protected */
        public RecipientType(String str) {
            this.type = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            if (this.type.equals("To")) {
                return TO;
            }
            if (this.type.equals("Cc")) {
                return CC;
            }
            if (this.type.equals("Bcc")) {
                return BCC;
            }
            throw new InvalidObjectException("Attempt to resolve unknown RecipientType: " + this.type);
        }

        public String toString() {
            return this.type;
        }
    }

    public Address[] getAllRecipients() throws MessagingException {
        int i;
        Address[] recipients = getRecipients(RecipientType.TO);
        Address[] recipients2 = getRecipients(RecipientType.CC);
        Address[] recipients3 = getRecipients(RecipientType.BCC);
        if (recipients2 == null && recipients3 == null) {
            return recipients;
        }
        Address[] addressArr = new Address[(recipients != null ? recipients.length : 0) + (recipients2 != null ? recipients2.length : 0) + (recipients3 != null ? recipients3.length : 0)];
        if (recipients != null) {
            System.arraycopy(recipients, 0, addressArr, 0, recipients.length);
            i = recipients.length + 0;
        } else {
            i = 0;
        }
        if (recipients2 != null) {
            System.arraycopy(recipients2, 0, addressArr, i, recipients2.length);
            i += recipients2.length;
        }
        if (recipients3 != null) {
            System.arraycopy(recipients3, 0, addressArr, i, recipients3.length);
        }
        return addressArr;
    }

    public void setRecipient(RecipientType recipientType, Address address) throws MessagingException {
        if (address == null) {
            setRecipients(recipientType, null);
        } else {
            setRecipients(recipientType, new Address[]{address});
        }
    }

    public void addRecipient(RecipientType recipientType, Address address) throws MessagingException {
        addRecipients(recipientType, new Address[]{address});
    }

    public Address[] getReplyTo() throws MessagingException {
        return getFrom();
    }

    public void setReplyTo(Address[] addressArr) throws MessagingException {
        throw new MethodNotSupportedException("setReplyTo not supported");
    }

    public boolean isSet(Flags.Flag flag) throws MessagingException {
        return getFlags().contains(flag);
    }

    public void setFlag(Flags.Flag flag, boolean z) throws MessagingException {
        setFlags(new Flags(flag), z);
    }

    public int getMessageNumber() {
        return this.msgnum;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMessageNumber(int i) {
        this.msgnum = i;
    }

    public Folder getFolder() {
        return this.folder;
    }

    public boolean isExpunged() {
        return this.expunged;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setExpunged(boolean z) {
        this.expunged = z;
    }

    public boolean match(SearchTerm searchTerm) throws MessagingException {
        return searchTerm.match(this);
    }
}
