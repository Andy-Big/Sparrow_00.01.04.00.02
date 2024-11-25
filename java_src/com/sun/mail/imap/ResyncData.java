package com.sun.mail.imap;

import com.sun.mail.imap.protocol.UIDSet;
/* loaded from: classes2.dex */
public class ResyncData {
    public static final ResyncData CONDSTORE = new ResyncData(-1, -1);
    private long modseq;
    private UIDSet[] uids;
    private long uidvalidity;

    public ResyncData(long j, long j2) {
        this.uidvalidity = -1L;
        this.modseq = -1L;
        this.uids = null;
        this.uidvalidity = j;
        this.modseq = j2;
        this.uids = null;
    }

    public ResyncData(long j, long j2, long j3, long j4) {
        this.uidvalidity = -1L;
        this.modseq = -1L;
        this.uids = null;
        this.uidvalidity = j;
        this.modseq = j2;
        this.uids = new UIDSet[]{new UIDSet(j3, j4)};
    }

    public ResyncData(long j, long j2, long[] jArr) {
        this.uidvalidity = -1L;
        this.modseq = -1L;
        this.uids = null;
        this.uidvalidity = j;
        this.modseq = j2;
        this.uids = UIDSet.createUIDSets(jArr);
    }

    public long getUIDValidity() {
        return this.uidvalidity;
    }

    public long getModSeq() {
        return this.modseq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UIDSet[] getUIDSet() {
        return this.uids;
    }
}
