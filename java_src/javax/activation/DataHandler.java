package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;
/* loaded from: classes2.dex */
public class DataHandler {
    private static final ActivationDataFlavor[] emptyFlavors = new ActivationDataFlavor[0];
    private static DataContentHandlerFactory factory;
    private CommandMap currentCommandMap;
    private DataContentHandler dataContentHandler;
    private DataSource dataSource;
    private DataContentHandler factoryDCH;
    private DataSource objDataSource;
    private Object object;
    private String objectMimeType;
    private DataContentHandlerFactory oldFactory;
    private String shortType;
    private ActivationDataFlavor[] transferFlavors;

    public DataHandler(DataSource dataSource) {
        this.dataSource = null;
        this.objDataSource = null;
        this.object = null;
        this.objectMimeType = null;
        this.currentCommandMap = null;
        this.transferFlavors = emptyFlavors;
        this.dataContentHandler = null;
        this.factoryDCH = null;
        this.oldFactory = null;
        this.shortType = null;
        this.dataSource = dataSource;
        this.oldFactory = factory;
    }

    public DataHandler(Object obj, String str) {
        this.dataSource = null;
        this.objDataSource = null;
        this.object = null;
        this.objectMimeType = null;
        this.currentCommandMap = null;
        this.transferFlavors = emptyFlavors;
        this.dataContentHandler = null;
        this.factoryDCH = null;
        this.oldFactory = null;
        this.shortType = null;
        this.object = obj;
        this.objectMimeType = str;
        this.oldFactory = factory;
    }

    public DataHandler(URL url) {
        this.dataSource = null;
        this.objDataSource = null;
        this.object = null;
        this.objectMimeType = null;
        this.currentCommandMap = null;
        this.transferFlavors = emptyFlavors;
        this.dataContentHandler = null;
        this.factoryDCH = null;
        this.oldFactory = null;
        this.shortType = null;
        this.dataSource = new URLDataSource(url);
        this.oldFactory = factory;
    }

    private synchronized CommandMap getCommandMap() {
        if (this.currentCommandMap != null) {
            return this.currentCommandMap;
        }
        return CommandMap.getDefaultCommandMap();
    }

    public DataSource getDataSource() {
        DataSource dataSource = this.dataSource;
        if (dataSource == null) {
            if (this.objDataSource == null) {
                this.objDataSource = new DataHandlerDataSource(this);
            }
            return this.objDataSource;
        }
        return dataSource;
    }

    public String getName() {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getName();
        }
        return null;
    }

    public String getContentType() {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getContentType();
        }
        return this.objectMimeType;
    }

    public InputStream getInputStream() throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getInputStream();
        }
        final DataContentHandler dataContentHandler = getDataContentHandler();
        if (dataContentHandler == null) {
            throw new UnsupportedDataTypeException("no DCH for MIME type " + getBaseType());
        } else if ((dataContentHandler instanceof ObjectDataContentHandler) && ((ObjectDataContentHandler) dataContentHandler).getDCH() == null) {
            throw new UnsupportedDataTypeException("no object DCH for MIME type " + getBaseType());
        } else {
            final PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
            new Thread(new Runnable() { // from class: javax.activation.DataHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        dataContentHandler.writeTo(DataHandler.this.object, DataHandler.this.objectMimeType, pipedOutputStream);
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        try {
                            pipedOutputStream.close();
                        } catch (IOException unused2) {
                        }
                        throw th;
                    }
                    try {
                        pipedOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            }, "DataHandler.getInputStream").start();
            return pipedInputStream;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            byte[] bArr = new byte[8192];
            InputStream inputStream = dataSource.getInputStream();
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                } finally {
                    inputStream.close();
                }
            }
        } else {
            getDataContentHandler().writeTo(this.object, this.objectMimeType, outputStream);
        }
    }

    public OutputStream getOutputStream() throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getOutputStream();
        }
        return null;
    }

    public synchronized ActivationDataFlavor[] getTransferDataFlavors() {
        if (factory != this.oldFactory) {
            this.transferFlavors = emptyFlavors;
        }
        if (this.transferFlavors == emptyFlavors) {
            this.transferFlavors = getDataContentHandler().mo17getTransferDataFlavors();
        }
        if (this.transferFlavors == emptyFlavors) {
            return this.transferFlavors;
        }
        return (ActivationDataFlavor[]) this.transferFlavors.clone();
    }

    public boolean isDataFlavorSupported(ActivationDataFlavor activationDataFlavor) {
        for (ActivationDataFlavor activationDataFlavor2 : getTransferDataFlavors()) {
            if (activationDataFlavor2.equals(activationDataFlavor)) {
                return true;
            }
        }
        return false;
    }

    public Object getTransferData(ActivationDataFlavor activationDataFlavor) throws IOException {
        return getDataContentHandler().getTransferData(activationDataFlavor, this.dataSource);
    }

    public synchronized void setCommandMap(CommandMap commandMap) {
        if (commandMap != this.currentCommandMap || commandMap == null) {
            this.transferFlavors = emptyFlavors;
            this.dataContentHandler = null;
            this.currentCommandMap = commandMap;
        }
    }

    public CommandInfo[] getPreferredCommands() {
        if (this.dataSource != null) {
            return getCommandMap().getPreferredCommands(getBaseType(), this.dataSource);
        }
        return getCommandMap().getPreferredCommands(getBaseType());
    }

    public CommandInfo[] getAllCommands() {
        if (this.dataSource != null) {
            return getCommandMap().getAllCommands(getBaseType(), this.dataSource);
        }
        return getCommandMap().getAllCommands(getBaseType());
    }

    public CommandInfo getCommand(String str) {
        if (this.dataSource != null) {
            return getCommandMap().getCommand(getBaseType(), str, this.dataSource);
        }
        return getCommandMap().getCommand(getBaseType(), str);
    }

    public Object getContent() throws IOException {
        Object obj = this.object;
        return obj != null ? obj : getDataContentHandler().getContent(getDataSource());
    }

    public Object getBean(CommandInfo commandInfo) {
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            return commandInfo.getCommandObject(this, contextClassLoader);
        } catch (IOException | ClassNotFoundException unused) {
            return null;
        }
    }

    private synchronized DataContentHandler getDataContentHandler() {
        if (factory != this.oldFactory) {
            this.oldFactory = factory;
            this.factoryDCH = null;
            this.dataContentHandler = null;
            this.transferFlavors = emptyFlavors;
        }
        if (this.dataContentHandler != null) {
            return this.dataContentHandler;
        }
        String baseType = getBaseType();
        if (this.factoryDCH == null && factory != null) {
            this.factoryDCH = factory.createDataContentHandler(baseType);
        }
        if (this.factoryDCH != null) {
            this.dataContentHandler = this.factoryDCH;
        }
        if (this.dataContentHandler == null) {
            if (this.dataSource != null) {
                this.dataContentHandler = getCommandMap().createDataContentHandler(baseType, this.dataSource);
            } else {
                this.dataContentHandler = getCommandMap().createDataContentHandler(baseType);
            }
        }
        if (this.dataSource != null) {
            this.dataContentHandler = new DataSourceDataContentHandler(this.dataContentHandler, this.dataSource);
        } else {
            this.dataContentHandler = new ObjectDataContentHandler(this.dataContentHandler, this.object, this.objectMimeType);
        }
        return this.dataContentHandler;
    }

    private synchronized String getBaseType() {
        if (this.shortType == null) {
            String contentType = getContentType();
            try {
                this.shortType = new MimeType(contentType).getBaseType();
            } catch (MimeTypeParseException unused) {
                this.shortType = contentType;
            }
        }
        return this.shortType;
    }

    public static synchronized void setDataContentHandlerFactory(DataContentHandlerFactory dataContentHandlerFactory) {
        synchronized (DataHandler.class) {
            if (factory != null) {
                throw new Error("DataContentHandlerFactory already defined");
            }
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                try {
                    securityManager.checkSetFactory();
                } catch (SecurityException e) {
                    if (DataHandler.class.getClassLoader() != dataContentHandlerFactory.getClass().getClassLoader()) {
                        throw e;
                    }
                }
            }
            factory = dataContentHandlerFactory;
        }
    }
}
