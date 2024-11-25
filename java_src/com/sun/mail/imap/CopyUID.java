package com.sun.mail.imap;

import com.sun.mail.imap.protocol.UIDSet;
/* loaded from: classes2.dex */
public class CopyUID {
    public UIDSet[] dst;
    public UIDSet[] src;
    public long uidvalidity;

    public CopyUID(long j, UIDSet[] uIDSetArr, UIDSet[] uIDSetArr2) {
        this.uidvalidity = -1L;
        this.uidvalidity = j;
        this.src = uIDSetArr;
        this.dst = uIDSetArr2;
    }
}
