package com.sun.mail.handlers;

import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
/* loaded from: classes2.dex */
public abstract class handler_base implements DataContentHandler {
    protected abstract ActivationDataFlavor[] getDataFlavors();

    protected Object getData(ActivationDataFlavor activationDataFlavor, DataSource dataSource) throws IOException {
        return getContent(dataSource);
    }

    @Override // javax.activation.DataContentHandler
    public ActivationDataFlavor[] getTransferDataFlavors() {
        return (ActivationDataFlavor[]) getDataFlavors().clone();
    }

    @Override // javax.activation.DataContentHandler
    public Object getTransferData(ActivationDataFlavor activationDataFlavor, DataSource dataSource) throws IOException {
        ActivationDataFlavor[] dataFlavors = getDataFlavors();
        for (int i = 0; i < dataFlavors.length; i++) {
            if (dataFlavors[i].equals((DataFlavor) activationDataFlavor)) {
                return getData(dataFlavors[i], dataSource);
            }
        }
        return null;
    }
}
