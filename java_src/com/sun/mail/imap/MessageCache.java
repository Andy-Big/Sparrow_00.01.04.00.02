package com.sun.mail.imap;

import com.sun.mail.util.MailLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import javax.mail.Message;
/* loaded from: classes2.dex */
public class MessageCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int SLOP = 64;
    private IMAPFolder folder;
    private MailLogger logger;
    private IMAPMessage[] messages;
    private int[] seqnums;
    private int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageCache(IMAPFolder iMAPFolder, IMAPStore iMAPStore, int i) {
        this.folder = iMAPFolder;
        MailLogger subLogger = iMAPFolder.logger.getSubLogger("messagecache", "DEBUG IMAP MC", iMAPStore.getMessageCacheDebug());
        this.logger = subLogger;
        if (subLogger.isLoggable(Level.CONFIG)) {
            MailLogger mailLogger = this.logger;
            mailLogger.config("create cache of size " + i);
        }
        ensureCapacity(i, 1);
    }

    MessageCache(int i, boolean z) {
        this.folder = null;
        MailLogger mailLogger = new MailLogger(getClass(), "messagecache", "DEBUG IMAP MC", z, System.out);
        this.logger = mailLogger;
        if (mailLogger.isLoggable(Level.CONFIG)) {
            MailLogger mailLogger2 = this.logger;
            mailLogger2.config("create DEBUG cache of size " + i);
        }
        ensureCapacity(i, 1);
    }

    public int size() {
        return this.size;
    }

    public IMAPMessage getMessage(int i) {
        if (i < 1 || i > this.size) {
            throw new ArrayIndexOutOfBoundsException("message number (" + i + ") out of bounds (" + this.size + ")");
        }
        int i2 = i - 1;
        IMAPMessage iMAPMessage = this.messages[i2];
        if (iMAPMessage == null) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("create message number " + i);
            }
            iMAPMessage = this.folder.newIMAPMessage(i);
            this.messages[i2] = iMAPMessage;
            if (seqnumOf(i) <= 0) {
                this.logger.fine("it's expunged!");
                iMAPMessage.setExpunged(true);
            }
        }
        return iMAPMessage;
    }

    public IMAPMessage getMessageBySeqnum(int i) {
        int msgnumOf = msgnumOf(i);
        if (msgnumOf < 0) {
            if (this.logger.isLoggable(Level.FINE)) {
                MailLogger mailLogger = this.logger;
                mailLogger.fine("no message seqnum " + i);
                return null;
            }
            return null;
        }
        return getMessage(msgnumOf);
    }

    public void expungeMessage(int i) {
        int msgnumOf = msgnumOf(i);
        if (msgnumOf < 0) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("expunge no seqnum " + i);
                return;
            }
            return;
        }
        int i2 = msgnumOf - 1;
        IMAPMessage iMAPMessage = this.messages[i2];
        if (iMAPMessage != null) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("expunge existing " + msgnumOf);
            }
            iMAPMessage.setExpunged(true);
        }
        int[] iArr = this.seqnums;
        if (iArr == null) {
            this.logger.fine("create seqnums array");
            this.seqnums = new int[this.messages.length];
            for (int i3 = 1; i3 < msgnumOf; i3++) {
                this.seqnums[i3 - 1] = i3;
            }
            this.seqnums[i2] = 0;
            int i4 = msgnumOf + 1;
            while (true) {
                int[] iArr2 = this.seqnums;
                if (i4 > iArr2.length) {
                    return;
                }
                int i5 = i4 - 1;
                iArr2[i5] = i5;
                i4++;
            }
        } else {
            iArr[i2] = 0;
            int i6 = msgnumOf + 1;
            while (true) {
                int[] iArr3 = this.seqnums;
                if (i6 > iArr3.length) {
                    return;
                }
                int i7 = i6 - 1;
                if (iArr3[i7] > 0) {
                    iArr3[i7] = iArr3[i7] - 1;
                }
                i6++;
            }
        }
    }

    public IMAPMessage[] removeExpungedMessages() {
        this.logger.fine("remove expunged messages");
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i <= this.size) {
            if (seqnumOf(i) <= 0) {
                arrayList.add(getMessage(i));
            } else {
                if (i2 != i) {
                    IMAPMessage[] iMAPMessageArr = this.messages;
                    int i3 = i2 - 1;
                    iMAPMessageArr[i3] = iMAPMessageArr[i - 1];
                    if (iMAPMessageArr[i3] != null) {
                        iMAPMessageArr[i3].setMessageNumber(i2);
                    }
                }
                i2++;
            }
            i++;
        }
        this.seqnums = null;
        shrink(i2, i);
        int size = arrayList.size();
        IMAPMessage[] iMAPMessageArr2 = new IMAPMessage[size];
        if (this.logger.isLoggable(Level.FINE)) {
            this.logger.fine("return " + size);
        }
        arrayList.toArray(iMAPMessageArr2);
        return iMAPMessageArr2;
    }

    public IMAPMessage[] removeExpungedMessages(Message[] messageArr) {
        this.logger.fine("remove expunged messages");
        ArrayList arrayList = new ArrayList();
        int length = messageArr.length;
        int[] iArr = new int[length];
        boolean z = false;
        for (int i = 0; i < messageArr.length; i++) {
            iArr[i] = messageArr[i].getMessageNumber();
        }
        Arrays.sort(iArr);
        int i2 = 1;
        int i3 = 1;
        int i4 = 0;
        while (i2 <= this.size) {
            if (i4 < length && i2 == iArr[i4] && seqnumOf(i2) <= 0) {
                arrayList.add(getMessage(i2));
                while (i4 < length && iArr[i4] <= i2) {
                    i4++;
                }
            } else {
                if (i3 != i2) {
                    IMAPMessage[] iMAPMessageArr = this.messages;
                    int i5 = i3 - 1;
                    int i6 = i2 - 1;
                    iMAPMessageArr[i5] = iMAPMessageArr[i6];
                    if (iMAPMessageArr[i5] != null) {
                        iMAPMessageArr[i5].setMessageNumber(i3);
                    }
                    int[] iArr2 = this.seqnums;
                    if (iArr2 != null) {
                        iArr2[i5] = iArr2[i6];
                    }
                }
                int[] iArr3 = this.seqnums;
                if (iArr3 != null && iArr3[i3 - 1] != i3) {
                    z = true;
                }
                i3++;
            }
            i2++;
        }
        if (!z) {
            this.seqnums = null;
        }
        shrink(i3, i2);
        int size = arrayList.size();
        IMAPMessage[] iMAPMessageArr2 = new IMAPMessage[size];
        if (this.logger.isLoggable(Level.FINE)) {
            this.logger.fine("return " + size);
        }
        arrayList.toArray(iMAPMessageArr2);
        return iMAPMessageArr2;
    }

    private void shrink(int i, int i2) {
        this.size = i - 1;
        if (this.logger.isLoggable(Level.FINE)) {
            this.logger.fine("size now " + this.size);
        }
        int i3 = this.size;
        if (i3 == 0) {
            this.messages = null;
            this.seqnums = null;
        } else if (i3 > 64 && i3 < this.messages.length / 2) {
            this.logger.fine("reallocate array");
            int i4 = this.size;
            IMAPMessage[] iMAPMessageArr = new IMAPMessage[i4 + 64];
            System.arraycopy(this.messages, 0, iMAPMessageArr, 0, i4);
            this.messages = iMAPMessageArr;
            int[] iArr = this.seqnums;
            if (iArr != null) {
                int i5 = this.size;
                int[] iArr2 = new int[i5 + 64];
                System.arraycopy(iArr, 0, iArr2, 0, i5);
                this.seqnums = iArr2;
            }
        } else {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("clean " + i + " to " + i2);
            }
            while (i < i2) {
                int i6 = i - 1;
                this.messages[i6] = null;
                int[] iArr3 = this.seqnums;
                if (iArr3 != null) {
                    iArr3[i6] = 0;
                }
                i++;
            }
        }
    }

    public void addMessages(int i, int i2) {
        if (this.logger.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.logger;
            mailLogger.fine("add " + i + " messages");
        }
        ensureCapacity(this.size + i, i2);
    }

    private void ensureCapacity(int i, int i2) {
        IMAPMessage[] iMAPMessageArr = this.messages;
        if (iMAPMessageArr == null) {
            this.messages = new IMAPMessage[i + 64];
        } else if (iMAPMessageArr.length < i) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("expand capacity to " + i);
            }
            int i3 = i + 64;
            IMAPMessage[] iMAPMessageArr2 = new IMAPMessage[i3];
            IMAPMessage[] iMAPMessageArr3 = this.messages;
            System.arraycopy(iMAPMessageArr3, 0, iMAPMessageArr2, 0, iMAPMessageArr3.length);
            this.messages = iMAPMessageArr2;
            int[] iArr = this.seqnums;
            if (iArr != null) {
                int[] iArr2 = new int[i3];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                int i4 = this.size;
                while (i4 < i3) {
                    iArr2[i4] = i2;
                    i4++;
                    i2++;
                }
                this.seqnums = iArr2;
                if (this.logger.isLoggable(Level.FINE)) {
                    this.logger.fine("message " + i + " has sequence number " + this.seqnums[i - 1]);
                }
            }
        } else if (i < this.size) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("shrink capacity to " + i);
            }
            for (int i5 = i + 1; i5 <= this.size; i5++) {
                int i6 = i5 - 1;
                this.messages[i6] = null;
                int[] iArr3 = this.seqnums;
                if (iArr3 != null) {
                    iArr3[i6] = -1;
                }
            }
        }
        this.size = i;
    }

    public int seqnumOf(int i) {
        if (this.seqnums == null) {
            return i;
        }
        if (this.logger.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.logger;
            mailLogger.fine("msgnum " + i + " is seqnum " + this.seqnums[i - 1]);
        }
        return this.seqnums[i - 1];
    }

    private int msgnumOf(int i) {
        if (this.seqnums == null) {
            return i;
        }
        if (i < 1) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("bad seqnum " + i);
            }
            return -1;
        }
        for (int i2 = i; i2 <= this.size; i2++) {
            int[] iArr = this.seqnums;
            int i3 = i2 - 1;
            if (iArr[i3] == i) {
                return i2;
            }
            if (iArr[i3] > i) {
                break;
            }
        }
        return -1;
    }
}
