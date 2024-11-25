package javax.mail;

import java.io.IOException;
import java.io.InputStream;
/* compiled from: Session.java */
/* loaded from: classes2.dex */
interface StreamLoader {
    void load(InputStream inputStream) throws IOException;
}
