package com.sun.mail.imap;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.event.MessageCountEvent;
/* loaded from: classes2.dex */
public class MessageVanishedEvent extends MessageCountEvent {
    private static final Message[] noMessages = new Message[0];
    private static final long serialVersionUID = 2142028010250024922L;
    private long[] uids;

    public MessageVanishedEvent(Folder folder, long[] jArr) {
        super(folder, 2, true, noMessages);
        this.uids = jArr;
    }

    public long[] getUIDs() {
        return this.uids;
    }
}
