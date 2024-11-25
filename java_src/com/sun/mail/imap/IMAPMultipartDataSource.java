package com.sun.mail.imap;

import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import java.util.ArrayList;
import java.util.List;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.MultipartDataSource;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimePartDataSource;
/* loaded from: classes2.dex */
public class IMAPMultipartDataSource extends MimePartDataSource implements MultipartDataSource {
    private List<IMAPBodyPart> parts;

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPMultipartDataSource(MimePart mimePart, BODYSTRUCTURE[] bodystructureArr, String str, IMAPMessage iMAPMessage) {
        super(mimePart);
        this.parts = new ArrayList(bodystructureArr.length);
        for (int i = 0; i < bodystructureArr.length; i++) {
            this.parts.add(new IMAPBodyPart(bodystructureArr[i], str == null ? Integer.toString(i + 1) : str + "." + Integer.toString(i + 1), iMAPMessage));
        }
    }

    @Override // javax.mail.MultipartDataSource
    public int getCount() {
        return this.parts.size();
    }

    @Override // javax.mail.MultipartDataSource
    public BodyPart getBodyPart(int i) throws MessagingException {
        return this.parts.get(i);
    }
}
