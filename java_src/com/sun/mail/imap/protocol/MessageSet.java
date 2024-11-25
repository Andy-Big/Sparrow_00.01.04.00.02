package com.sun.mail.imap.protocol;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MessageSet {
    public int end;
    public int start;

    public MessageSet() {
    }

    public MessageSet(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    public int size() {
        return (this.end - this.start) + 1;
    }

    public static MessageSet[] createMessageSets(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < iArr.length) {
            MessageSet messageSet = new MessageSet();
            messageSet.start = iArr[i];
            do {
                i++;
                if (i < iArr.length) {
                }
                int i2 = i - 1;
                messageSet.end = iArr[i2];
                arrayList.add(messageSet);
                i = i2 + 1;
            } while (iArr[i] == iArr[i - 1] + 1);
            int i22 = i - 1;
            messageSet.end = iArr[i22];
            arrayList.add(messageSet);
            i = i22 + 1;
        }
        return (MessageSet[]) arrayList.toArray(new MessageSet[arrayList.size()]);
    }

    public static String toString(MessageSet[] messageSetArr) {
        if (messageSetArr == null || messageSetArr.length == 0) {
            return null;
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int length = messageSetArr.length;
        while (true) {
            int i2 = messageSetArr[i].start;
            int i3 = messageSetArr[i].end;
            if (i3 > i2) {
                sb.append(i2);
                sb.append(':');
                sb.append(i3);
            } else {
                sb.append(i2);
            }
            i++;
            if (i < length) {
                sb.append(',');
            } else {
                return sb.toString();
            }
        }
    }

    public static int size(MessageSet[] messageSetArr) {
        if (messageSetArr == null) {
            return 0;
        }
        int i = 0;
        for (MessageSet messageSet : messageSetArr) {
            i += messageSet.size();
        }
        return i;
    }
}
