package com.sun.mail.imap;

import com.sun.mail.imap.protocol.MessageSet;
import com.sun.mail.imap.protocol.UIDSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import javax.mail.Message;
/* loaded from: classes2.dex */
public final class Utility {

    /* loaded from: classes2.dex */
    public interface Condition {
        boolean test(IMAPMessage iMAPMessage);
    }

    private Utility() {
    }

    public static MessageSet[] toMessageSet(Message[] messageArr, Condition condition) {
        ArrayList arrayList = new ArrayList(1);
        int i = 0;
        while (i < messageArr.length) {
            IMAPMessage iMAPMessage = (IMAPMessage) messageArr[i];
            if (!iMAPMessage.isExpunged()) {
                int sequenceNumber = iMAPMessage.getSequenceNumber();
                if (condition == null || condition.test(iMAPMessage)) {
                    MessageSet messageSet = new MessageSet();
                    messageSet.start = sequenceNumber;
                    while (true) {
                        i++;
                        if (i >= messageArr.length) {
                            break;
                        }
                        IMAPMessage iMAPMessage2 = (IMAPMessage) messageArr[i];
                        if (!iMAPMessage2.isExpunged()) {
                            int sequenceNumber2 = iMAPMessage2.getSequenceNumber();
                            if (condition == null || condition.test(iMAPMessage2)) {
                                if (sequenceNumber2 != sequenceNumber + 1) {
                                    i--;
                                    break;
                                }
                                sequenceNumber = sequenceNumber2;
                            }
                        }
                    }
                    messageSet.end = sequenceNumber;
                    arrayList.add(messageSet);
                }
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (MessageSet[]) arrayList.toArray(new MessageSet[arrayList.size()]);
    }

    public static MessageSet[] toMessageSetSorted(Message[] messageArr, Condition condition) {
        Message[] messageArr2 = (Message[]) messageArr.clone();
        Arrays.sort(messageArr2, new Comparator<Message>() { // from class: com.sun.mail.imap.Utility.1
            @Override // java.util.Comparator
            public int compare(Message message, Message message2) {
                return message.getMessageNumber() - message2.getMessageNumber();
            }
        });
        return toMessageSet(messageArr2, condition);
    }

    public static UIDSet[] toUIDSet(Message[] messageArr) {
        ArrayList arrayList = new ArrayList(1);
        int i = 0;
        while (i < messageArr.length) {
            IMAPMessage iMAPMessage = (IMAPMessage) messageArr[i];
            if (!iMAPMessage.isExpunged()) {
                long uid = iMAPMessage.getUID();
                UIDSet uIDSet = new UIDSet();
                uIDSet.start = uid;
                while (true) {
                    i++;
                    if (i >= messageArr.length) {
                        break;
                    }
                    IMAPMessage iMAPMessage2 = (IMAPMessage) messageArr[i];
                    if (!iMAPMessage2.isExpunged()) {
                        long uid2 = iMAPMessage2.getUID();
                        if (uid2 != 1 + uid) {
                            i--;
                            break;
                        }
                        uid = uid2;
                    }
                }
                uIDSet.end = uid;
                arrayList.add(uIDSet);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (UIDSet[]) arrayList.toArray(new UIDSet[arrayList.size()]);
    }

    public static UIDSet[] getResyncUIDSet(ResyncData resyncData) {
        return resyncData.getUIDSet();
    }
}
