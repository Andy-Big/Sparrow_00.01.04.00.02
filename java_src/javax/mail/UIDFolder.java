package javax.mail;

import javax.mail.FetchProfile;
/* loaded from: classes2.dex */
public interface UIDFolder {
    public static final long LASTUID = -1;
    public static final long MAXUID = 4294967295L;

    Message getMessageByUID(long j) throws MessagingException;

    Message[] getMessagesByUID(long j, long j2) throws MessagingException;

    Message[] getMessagesByUID(long[] jArr) throws MessagingException;

    long getUID(Message message) throws MessagingException;

    long getUIDNext() throws MessagingException;

    long getUIDValidity() throws MessagingException;

    /* loaded from: classes2.dex */
    public static class FetchProfileItem extends FetchProfile.Item {
        public static final FetchProfileItem UID = new FetchProfileItem("UID");

        protected FetchProfileItem(String str) {
            super(str);
        }
    }
}
