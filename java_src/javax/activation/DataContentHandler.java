package javax.activation;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public interface DataContentHandler {
    Object getContent(DataSource dataSource) throws IOException;

    Object getTransferData(ActivationDataFlavor activationDataFlavor, DataSource dataSource) throws IOException;

    /* renamed from: getTransferDataFlavors */
    ActivationDataFlavor[] mo17getTransferDataFlavors();

    void writeTo(Object obj, String str, OutputStream outputStream) throws IOException;
}
