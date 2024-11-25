package javax.activation;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
/* compiled from: DataHandler.java */
/* loaded from: classes2.dex */
class ObjectDataContentHandler implements DataContentHandler {
    private DataContentHandler dch;
    private String mimeType;
    private Object obj;
    private ActivationDataFlavor[] transferFlavors = null;

    public ObjectDataContentHandler(DataContentHandler dataContentHandler, Object obj, String str) {
        this.dch = null;
        this.obj = obj;
        this.mimeType = str;
        this.dch = dataContentHandler;
    }

    public DataContentHandler getDCH() {
        return this.dch;
    }

    @Override // javax.activation.DataContentHandler
    /* renamed from: getTransferDataFlavors */
    public synchronized ActivationDataFlavor[] mo17getTransferDataFlavors() {
        if (this.transferFlavors == null) {
            if (this.dch != null) {
                this.transferFlavors = this.dch.mo17getTransferDataFlavors();
            } else {
                this.transferFlavors = r0;
                ActivationDataFlavor[] activationDataFlavorArr = {new ActivationDataFlavor(this.obj.getClass(), this.mimeType, this.mimeType)};
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
            return this.obj;
        }
        throw new IOException("Unsupported DataFlavor: " + activationDataFlavor);
    }

    @Override // javax.activation.DataContentHandler
    public Object getContent(DataSource dataSource) {
        return this.obj;
    }

    @Override // javax.activation.DataContentHandler
    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        DataContentHandler dataContentHandler = this.dch;
        if (dataContentHandler != null) {
            dataContentHandler.writeTo(obj, str, outputStream);
        } else if (obj instanceof byte[]) {
            outputStream.write((byte[]) obj);
        } else if (obj instanceof String) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write((String) obj);
            outputStreamWriter.flush();
        } else {
            throw new UnsupportedDataTypeException("no object DCH for MIME type " + this.mimeType);
        }
    }
}
