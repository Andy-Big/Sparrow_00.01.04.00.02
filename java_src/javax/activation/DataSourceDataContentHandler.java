package javax.activation;

import java.io.IOException;
import java.io.OutputStream;
/* compiled from: DataHandler.java */
/* loaded from: classes2.dex */
class DataSourceDataContentHandler implements DataContentHandler {
    private DataContentHandler dch;
    private DataSource ds;
    private ActivationDataFlavor[] transferFlavors = null;

    public DataSourceDataContentHandler(DataContentHandler dataContentHandler, DataSource dataSource) {
        this.ds = null;
        this.dch = null;
        this.ds = dataSource;
        this.dch = dataContentHandler;
    }

    @Override // javax.activation.DataContentHandler
    /* renamed from: getTransferDataFlavors */
    public ActivationDataFlavor[] mo17getTransferDataFlavors() {
        if (this.transferFlavors == null) {
            DataContentHandler dataContentHandler = this.dch;
            if (dataContentHandler != null) {
                this.transferFlavors = dataContentHandler.mo17getTransferDataFlavors();
            } else {
                this.transferFlavors = r0;
                ActivationDataFlavor[] activationDataFlavorArr = {new ActivationDataFlavor(this.ds.getContentType(), this.ds.getContentType())};
            }
        }
        return this.transferFlavors;
    }

    @Override // javax.activation.DataContentHandler
    public Object getTransferData(ActivationDataFlavor activationDataFlavor, DataSource dataSource) throws IOException {
        DataContentHandler dataContentHandler = this.dch;
        if (dataContentHandler != null) {
            return dataContentHandler.getTransferData(activationDataFlavor, dataSource);
        }
        if (activationDataFlavor.equals(mo17getTransferDataFlavors()[0])) {
            return dataSource.getInputStream();
        }
        throw new IOException("Unsupported DataFlavor: " + activationDataFlavor);
    }

    @Override // javax.activation.DataContentHandler
    public Object getContent(DataSource dataSource) throws IOException {
        DataContentHandler dataContentHandler = this.dch;
        if (dataContentHandler != null) {
            return dataContentHandler.getContent(dataSource);
        }
        return dataSource.getInputStream();
    }

    @Override // javax.activation.DataContentHandler
    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        DataContentHandler dataContentHandler = this.dch;
        if (dataContentHandler != null) {
            dataContentHandler.writeTo(obj, str, outputStream);
            return;
        }
        throw new UnsupportedDataTypeException("no DCH for content type " + this.ds.getContentType());
    }
}
