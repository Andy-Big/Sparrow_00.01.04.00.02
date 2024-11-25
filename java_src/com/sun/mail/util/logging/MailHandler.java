package com.sun.mail.util.logging;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;
import javax.activation.DataHandler;
import javax.activation.FileTypeMap;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessageContext;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Service;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;
/* loaded from: classes2.dex */
public class MailHandler extends Handler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MIN_HEADER_SIZE = 1024;
    private volatile Filter[] attachmentFilters;
    private Formatter[] attachmentFormatters;
    private Formatter[] attachmentNames;
    private Authenticator auth;
    private int capacity;
    private Comparator<? super LogRecord> comparator;
    private FileTypeMap contentTypes;
    private LogRecord[] data;
    private String encoding;
    private volatile Filter filter;
    private Formatter formatter;
    private boolean isWriting;
    private Properties mailProps;
    private int[] matched;
    private Filter pushFilter;
    private Level pushLevel;
    private volatile boolean sealed;
    private Session session;
    private int size;
    private Formatter subjectFormatter;
    private static final Filter[] EMPTY_FILTERS = new Filter[0];
    private static final Formatter[] EMPTY_FORMATTERS = new Formatter[0];
    private static final int offValue = Level.OFF.intValue();
    private static final PrivilegedAction<Object> MAILHANDLER_LOADER = new GetAndSetContext(MailHandler.class);
    private static final ThreadLocal<Integer> MUTEX = new ThreadLocal<>();
    private static final Integer MUTEX_PUBLISH = -2;
    private static final Integer MUTEX_REPORT = -4;
    private static final Integer MUTEX_LINKAGE = -8;
    private volatile Level logLevel = Level.ALL;
    private volatile ErrorManager errorManager = defaultErrorManager();

    public void postConstruct() {
    }

    public MailHandler() {
        init(null);
        this.sealed = true;
        checkAccess();
    }

    public MailHandler(int i) {
        init(null);
        this.sealed = true;
        setCapacity0(i);
    }

    public MailHandler(Properties properties) {
        if (properties == null) {
            throw null;
        }
        init(properties);
        this.sealed = true;
        setMailProperties0(properties);
    }

    @Override // java.util.logging.Handler
    public boolean isLoggable(LogRecord logRecord) {
        int intValue;
        if (logRecord == null || logRecord.getLevel().intValue() < (intValue = getLevel().intValue()) || intValue == offValue) {
            return false;
        }
        Filter filter = getFilter();
        if (filter == null || filter.isLoggable(logRecord)) {
            setMatchedPart(-1);
            return true;
        }
        return isAttachmentLoggable(logRecord);
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        if (tryMutex()) {
            try {
                try {
                    if (isLoggable(logRecord)) {
                        if (logRecord != null) {
                            logRecord.getSourceMethodName();
                            publish0(logRecord);
                        } else {
                            reportNullError(1);
                        }
                    }
                } catch (LinkageError e) {
                    reportLinkageError(e, 1);
                }
                return;
            } finally {
                releaseMutex();
            }
        }
        reportUnPublishedError(logRecord);
    }

    private void publish0(LogRecord logRecord) {
        Message message;
        boolean z;
        synchronized (this) {
            if (this.size == this.data.length && this.size < this.capacity) {
                grow();
            }
            message = null;
            if (this.size < this.data.length) {
                this.matched[this.size] = getMatchedPart();
                this.data[this.size] = logRecord;
                this.size++;
                z = isPushable(logRecord);
                if (z || this.size >= this.capacity) {
                    message = writeLogRecords(1);
                }
            } else {
                z = false;
            }
        }
        if (message != null) {
            send(message, z, 1);
        }
    }

    private void reportUnPublishedError(LogRecord logRecord) {
        String str;
        Integer num = MUTEX.get();
        if (num == null || num.intValue() > MUTEX_REPORT.intValue()) {
            MUTEX.set(MUTEX_REPORT);
            if (logRecord != null) {
                try {
                    Formatter createSimpleFormatter = createSimpleFormatter();
                    str = "Log record " + logRecord.getSequenceNumber() + " was not published. " + head(createSimpleFormatter) + format(createSimpleFormatter, logRecord) + tail(createSimpleFormatter, "");
                } catch (Throwable th) {
                    if (num != null) {
                        MUTEX.set(num);
                    } else {
                        MUTEX.remove();
                    }
                    throw th;
                }
            } else {
                str = null;
            }
            reportError(str, new IllegalStateException("Recursive publish detected by thread " + Thread.currentThread()), 1);
            if (num != null) {
                MUTEX.set(num);
            } else {
                MUTEX.remove();
            }
        }
    }

    private boolean tryMutex() {
        if (MUTEX.get() == null) {
            MUTEX.set(MUTEX_PUBLISH);
            return true;
        }
        return false;
    }

    private void releaseMutex() {
        MUTEX.remove();
    }

    private int getMatchedPart() {
        Integer num = MUTEX.get();
        if (num == null || num.intValue() >= readOnlyAttachmentFilters().length) {
            num = MUTEX_PUBLISH;
        }
        return num.intValue();
    }

    private void setMatchedPart(int i) {
        if (MUTEX_PUBLISH.equals(MUTEX.get())) {
            MUTEX.set(Integer.valueOf(i));
        }
    }

    private void clearMatches(int i) {
        for (int i2 = 0; i2 < this.size; i2++) {
            int[] iArr = this.matched;
            if (iArr[i2] >= i) {
                iArr[i2] = MUTEX_PUBLISH.intValue();
            }
        }
    }

    public void preDestroy() {
        push(false, 3);
    }

    public void push() {
        push(true, 2);
    }

    @Override // java.util.logging.Handler
    public void flush() {
        push(false, 2);
    }

    @Override // java.util.logging.Handler
    public void close() {
        Message writeLogRecords;
        try {
            checkAccess();
            synchronized (this) {
                writeLogRecords = writeLogRecords(3);
                this.logLevel = Level.OFF;
                if (this.capacity > 0) {
                    this.capacity = -this.capacity;
                }
                if (this.size == 0 && this.data.length != 1) {
                    LogRecord[] logRecordArr = new LogRecord[1];
                    this.data = logRecordArr;
                    this.matched = new int[logRecordArr.length];
                }
            }
            if (writeLogRecords != null) {
                send(writeLogRecords, false, 3);
            }
        } catch (LinkageError e) {
            reportLinkageError(e, 3);
        }
    }

    @Override // java.util.logging.Handler
    public void setLevel(Level level) {
        if (level == null) {
            throw null;
        }
        checkAccess();
        synchronized (this) {
            if (this.capacity > 0) {
                this.logLevel = level;
            }
        }
    }

    @Override // java.util.logging.Handler
    public Level getLevel() {
        return this.logLevel;
    }

    @Override // java.util.logging.Handler
    public ErrorManager getErrorManager() {
        checkAccess();
        return this.errorManager;
    }

    @Override // java.util.logging.Handler
    public void setErrorManager(ErrorManager errorManager) {
        checkAccess();
        setErrorManager0(errorManager);
    }

    private void setErrorManager0(ErrorManager errorManager) {
        if (errorManager == null) {
            throw null;
        }
        try {
            synchronized (this) {
                this.errorManager = errorManager;
                super.setErrorManager(errorManager);
            }
        } catch (LinkageError | RuntimeException unused) {
        }
    }

    @Override // java.util.logging.Handler
    public Filter getFilter() {
        return this.filter;
    }

    @Override // java.util.logging.Handler
    public void setFilter(Filter filter) {
        checkAccess();
        synchronized (this) {
            if (filter != this.filter) {
                clearMatches(-1);
            }
            this.filter = filter;
        }
    }

    @Override // java.util.logging.Handler
    public synchronized String getEncoding() {
        return this.encoding;
    }

    @Override // java.util.logging.Handler
    public void setEncoding(String str) throws UnsupportedEncodingException {
        checkAccess();
        setEncoding0(str);
    }

    private void setEncoding0(String str) throws UnsupportedEncodingException {
        if (str != null) {
            try {
                if (!Charset.isSupported(str)) {
                    throw new UnsupportedEncodingException(str);
                }
            } catch (IllegalCharsetNameException unused) {
                throw new UnsupportedEncodingException(str);
            }
        }
        synchronized (this) {
            this.encoding = str;
        }
    }

    @Override // java.util.logging.Handler
    public synchronized Formatter getFormatter() {
        return this.formatter;
    }

    @Override // java.util.logging.Handler
    public synchronized void setFormatter(Formatter formatter) throws SecurityException {
        checkAccess();
        if (formatter == null) {
            throw new NullPointerException();
        }
        this.formatter = formatter;
    }

    public final synchronized Level getPushLevel() {
        return this.pushLevel;
    }

    public final synchronized void setPushLevel(Level level) {
        checkAccess();
        if (level == null) {
            throw new NullPointerException();
        }
        if (this.isWriting) {
            throw new IllegalStateException();
        }
        this.pushLevel = level;
    }

    public final synchronized Filter getPushFilter() {
        return this.pushFilter;
    }

    public final synchronized void setPushFilter(Filter filter) {
        checkAccess();
        if (this.isWriting) {
            throw new IllegalStateException();
        }
        this.pushFilter = filter;
    }

    public final synchronized Comparator<? super LogRecord> getComparator() {
        return this.comparator;
    }

    public final synchronized void setComparator(Comparator<? super LogRecord> comparator) {
        checkAccess();
        if (this.isWriting) {
            throw new IllegalStateException();
        }
        this.comparator = comparator;
    }

    public final synchronized int getCapacity() {
        return Math.abs(this.capacity);
    }

    public final synchronized Authenticator getAuthenticator() {
        checkAccess();
        return this.auth;
    }

    public final void setAuthenticator(Authenticator authenticator) {
        setAuthenticator0(authenticator);
    }

    public final void setAuthenticator(char... cArr) {
        if (cArr == null) {
            setAuthenticator0(null);
        } else {
            setAuthenticator0(DefaultAuthenticator.of(new String(cArr)));
        }
    }

    private void setAuthenticator0(Authenticator authenticator) {
        Session updateSession;
        checkAccess();
        synchronized (this) {
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            this.auth = authenticator;
            updateSession = updateSession();
        }
        verifySettings(updateSession);
    }

    public final void setMailProperties(Properties properties) {
        setMailProperties0(properties);
    }

    private void setMailProperties0(Properties properties) {
        Session updateSession;
        checkAccess();
        Properties properties2 = (Properties) properties.clone();
        synchronized (this) {
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            this.mailProps = properties2;
            updateSession = updateSession();
        }
        verifySettings(updateSession);
    }

    public final Properties getMailProperties() {
        Properties properties;
        checkAccess();
        synchronized (this) {
            properties = this.mailProps;
        }
        return (Properties) properties.clone();
    }

    public final Filter[] getAttachmentFilters() {
        return (Filter[]) readOnlyAttachmentFilters().clone();
    }

    public final void setAttachmentFilters(Filter... filterArr) {
        Filter[] filterArr2;
        checkAccess();
        if (filterArr.length == 0) {
            filterArr2 = emptyFilterArray();
        } else {
            filterArr2 = (Filter[]) Arrays.copyOf(filterArr, filterArr.length, Filter[].class);
        }
        synchronized (this) {
            if (this.attachmentFormatters.length != filterArr2.length) {
                throw attachmentMismatch(this.attachmentFormatters.length, filterArr2.length);
            }
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            if (this.size != 0) {
                int i = 0;
                while (true) {
                    if (i >= filterArr2.length) {
                        break;
                    } else if (filterArr2[i] != this.attachmentFilters[i]) {
                        clearMatches(i);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.attachmentFilters = filterArr2;
        }
    }

    public final Formatter[] getAttachmentFormatters() {
        Formatter[] formatterArr;
        synchronized (this) {
            formatterArr = this.attachmentFormatters;
        }
        return (Formatter[]) formatterArr.clone();
    }

    public final void setAttachmentFormatters(Formatter... formatterArr) {
        Formatter[] formatterArr2;
        checkAccess();
        if (formatterArr.length == 0) {
            formatterArr2 = emptyFormatterArray();
        } else {
            formatterArr2 = (Formatter[]) Arrays.copyOf(formatterArr, formatterArr.length, Formatter[].class);
            for (int i = 0; i < formatterArr2.length; i++) {
                if (formatterArr2[i] == null) {
                    throw new NullPointerException(atIndexMsg(i));
                }
            }
        }
        synchronized (this) {
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            this.attachmentFormatters = formatterArr2;
            alignAttachmentFilters();
            alignAttachmentNames();
        }
    }

    public final Formatter[] getAttachmentNames() {
        Formatter[] formatterArr;
        synchronized (this) {
            formatterArr = this.attachmentNames;
        }
        return (Formatter[]) formatterArr.clone();
    }

    public final void setAttachmentNames(String... strArr) {
        Formatter[] formatterArr;
        checkAccess();
        if (strArr.length == 0) {
            formatterArr = emptyFormatterArray();
        } else {
            formatterArr = new Formatter[strArr.length];
        }
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str != null) {
                if (str.length() > 0) {
                    formatterArr[i] = TailNameFormatter.of(str);
                } else {
                    throw new IllegalArgumentException(atIndexMsg(i));
                }
            } else {
                throw new NullPointerException(atIndexMsg(i));
            }
        }
        synchronized (this) {
            if (this.attachmentFormatters.length != strArr.length) {
                throw attachmentMismatch(this.attachmentFormatters.length, strArr.length);
            }
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            this.attachmentNames = formatterArr;
        }
    }

    public final void setAttachmentNames(Formatter... formatterArr) {
        Formatter[] formatterArr2;
        checkAccess();
        if (formatterArr.length == 0) {
            formatterArr2 = emptyFormatterArray();
        } else {
            formatterArr2 = (Formatter[]) Arrays.copyOf(formatterArr, formatterArr.length, Formatter[].class);
        }
        for (int i = 0; i < formatterArr2.length; i++) {
            if (formatterArr2[i] == null) {
                throw new NullPointerException(atIndexMsg(i));
            }
        }
        synchronized (this) {
            if (this.attachmentFormatters.length != formatterArr2.length) {
                throw attachmentMismatch(this.attachmentFormatters.length, formatterArr2.length);
            }
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            this.attachmentNames = formatterArr2;
        }
    }

    public final synchronized Formatter getSubject() {
        return this.subjectFormatter;
    }

    public final void setSubject(String str) {
        if (str != null) {
            setSubject(TailNameFormatter.of(str));
        } else {
            checkAccess();
            throw null;
        }
    }

    public final void setSubject(Formatter formatter) {
        checkAccess();
        if (formatter == null) {
            throw null;
        }
        synchronized (this) {
            if (this.isWriting) {
                throw new IllegalStateException();
            }
            this.subjectFormatter = formatter;
        }
    }

    @Override // java.util.logging.Handler
    protected void reportError(String str, Exception exc, int i) {
        try {
            if (str != null) {
                this.errorManager.error(Level.SEVERE.getName().concat(": ").concat(str), exc, i);
            } else {
                this.errorManager.error(null, exc, i);
            }
        } catch (LinkageError | RuntimeException e) {
            reportLinkageError(e, i);
        }
    }

    private void checkAccess() {
        if (this.sealed) {
            LogManagerProperties.checkLogManagerAccess();
        }
    }

    final String contentTypeOf(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return null;
        }
        if (charSequence.length() > 25) {
            charSequence = charSequence.subSequence(0, 25);
        }
        try {
            return URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(charSequence.toString().getBytes(getEncodingName())));
        } catch (IOException e) {
            reportError(e.getMessage(), e, 5);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
        r7 = r7.getSuperclass();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.lang.String contentTypeOf(java.util.logging.Formatter r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L67
            java.lang.Class r0 = r7.getClass()
            java.lang.String r0 = r0.getName()
            java.lang.String r0 = r6.getContentType(r0)
            if (r0 == 0) goto L11
            return r0
        L11:
            java.lang.Class r7 = r7.getClass()
        L15:
            java.lang.Class<java.util.logging.Formatter> r0 = java.util.logging.Formatter.class
            if (r7 == r0) goto L67
            java.lang.String r0 = r7.getSimpleName()     // Catch: java.lang.InternalError -> L1e
            goto L22
        L1e:
            java.lang.String r0 = r7.getName()
        L22:
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r1)
            r1 = 36
            int r1 = r0.indexOf(r1)
            r2 = 1
            int r1 = r1 + r2
        L30:
            java.lang.String r3 = "ml"
            int r1 = r0.indexOf(r3, r1)
            r3 = -1
            if (r1 <= r3) goto L62
            if (r1 <= 0) goto L5f
            int r3 = r1 + (-1)
            char r4 = r0.charAt(r3)
            r5 = 120(0x78, float:1.68E-43)
            if (r4 != r5) goto L48
            java.lang.String r7 = "application/xml"
            return r7
        L48:
            if (r1 <= r2) goto L5f
            int r4 = r1 + (-2)
            char r4 = r0.charAt(r4)
            r5 = 104(0x68, float:1.46E-43)
            if (r4 != r5) goto L5f
            char r3 = r0.charAt(r3)
            r4 = 116(0x74, float:1.63E-43)
            if (r3 != r4) goto L5f
            java.lang.String r7 = "text/html"
            return r7
        L5f:
            int r1 = r1 + 2
            goto L30
        L62:
            java.lang.Class r7 = r7.getSuperclass()
            goto L15
        L67:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.MailHandler.contentTypeOf(java.util.logging.Formatter):java.lang.String");
    }

    final boolean isMissingContent(Message message, Throwable th) {
        Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
        try {
            try {
                message.writeTo(new ByteArrayOutputStream(1024));
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                String message2 = e2.getMessage();
                if (!isEmpty(message2)) {
                    int i = 0;
                    while (th != null) {
                        if (e2.getClass() != th.getClass() || !message2.equals(th.getMessage())) {
                            Throwable cause = th.getCause();
                            th = (cause == null && (th instanceof MessagingException)) ? ((MessagingException) th).getNextException() : cause;
                            i++;
                            if (i == 65536) {
                                break;
                            }
                        } else {
                            getAndSetContextClassLoader(andSetContextClassLoader);
                            return true;
                        }
                    }
                }
            }
            getAndSetContextClassLoader(andSetContextClassLoader);
            return false;
        } catch (Throwable th2) {
            getAndSetContextClassLoader(andSetContextClassLoader);
            throw th2;
        }
    }

    private void reportError(Message message, Exception exc, int i) {
        try {
            try {
                this.errorManager.error(toRawString(message), exc, i);
            } catch (RuntimeException e) {
                reportError(toMsgString(e), exc, i);
            } catch (Exception e2) {
                reportError(toMsgString(e2), exc, i);
            }
        } catch (LinkageError e3) {
            reportLinkageError(e3, i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
        if (r4 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        com.sun.mail.util.logging.MailHandler.MUTEX.set(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
        com.sun.mail.util.logging.MailHandler.MUTEX.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
        if (r4 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void reportLinkageError(java.lang.Throwable r3, int r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L4e
            java.lang.ThreadLocal<java.lang.Integer> r4 = com.sun.mail.util.logging.MailHandler.MUTEX
            java.lang.Object r4 = r4.get()
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 == 0) goto L18
            int r0 = r4.intValue()
            java.lang.Integer r1 = com.sun.mail.util.logging.MailHandler.MUTEX_LINKAGE
            int r1 = r1.intValue()
            if (r0 <= r1) goto L4d
        L18:
            java.lang.ThreadLocal<java.lang.Integer> r0 = com.sun.mail.util.logging.MailHandler.MUTEX
            java.lang.Integer r1 = com.sun.mail.util.logging.MailHandler.MUTEX_LINKAGE
            r0.set(r1)
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L40
            java.lang.Thread$UncaughtExceptionHandler r0 = r0.getUncaughtExceptionHandler()     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L40
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L40
            r0.uncaughtException(r1, r3)     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L40
            if (r4 == 0) goto L48
            goto L42
        L31:
            r3 = move-exception
            if (r4 == 0) goto L3a
            java.lang.ThreadLocal<java.lang.Integer> r0 = com.sun.mail.util.logging.MailHandler.MUTEX
            r0.set(r4)
            goto L3f
        L3a:
            java.lang.ThreadLocal<java.lang.Integer> r4 = com.sun.mail.util.logging.MailHandler.MUTEX
            r4.remove()
        L3f:
            throw r3
        L40:
            if (r4 == 0) goto L48
        L42:
            java.lang.ThreadLocal<java.lang.Integer> r3 = com.sun.mail.util.logging.MailHandler.MUTEX
            r3.set(r4)
            goto L4d
        L48:
            java.lang.ThreadLocal<java.lang.Integer> r3 = com.sun.mail.util.logging.MailHandler.MUTEX
            r3.remove()
        L4d:
            return
        L4e:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.MailHandler.reportLinkageError(java.lang.Throwable, int):void");
    }

    private String getContentType(String str) {
        String contentType = this.contentTypes.getContentType(str);
        if ("application/octet-stream".equalsIgnoreCase(contentType)) {
            return null;
        }
        return contentType;
    }

    private String getEncodingName() {
        String encoding = getEncoding();
        return encoding == null ? MimeUtility.getDefaultJavaCharset() : encoding;
    }

    private void setContent(MimePart mimePart, CharSequence charSequence, String str) throws MessagingException {
        String encodingName = getEncodingName();
        if (str != null && !"text/plain".equalsIgnoreCase(str)) {
            try {
                mimePart.setDataHandler(new DataHandler(new ByteArrayDataSource(charSequence.toString(), contentWithEncoding(str, encodingName))));
                return;
            } catch (IOException e) {
                reportError(e.getMessage(), e, 5);
                mimePart.setText(charSequence.toString(), encodingName);
                return;
            }
        }
        mimePart.setText(charSequence.toString(), MimeUtility.mimeCharset(encodingName));
    }

    private String contentWithEncoding(String str, String str2) {
        try {
            ContentType contentType = new ContentType(str);
            contentType.setParameter("charset", MimeUtility.mimeCharset(str2));
            String contentType2 = contentType.toString();
            return !isEmpty(contentType2) ? contentType2 : str;
        } catch (MessagingException e) {
            reportError(str, e, 5);
            return str;
        }
    }

    private synchronized void setCapacity0(int i) {
        checkAccess();
        if (i <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        if (this.isWriting) {
            throw new IllegalStateException();
        }
        if (this.capacity < 0) {
            this.capacity = -i;
        } else {
            this.capacity = i;
        }
    }

    private Filter[] readOnlyAttachmentFilters() {
        return this.attachmentFilters;
    }

    private static Formatter[] emptyFormatterArray() {
        return EMPTY_FORMATTERS;
    }

    private static Filter[] emptyFilterArray() {
        return EMPTY_FILTERS;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021 A[LOOP:0: B:10:0x0021->B:14:0x0037, LOOP_START, PHI: r3 
      PHI: (r3v1 int) = (r3v0 int), (r3v2 int) binds: [B:8:0x0018, B:14:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean alignAttachmentNames() {
        /*
            r5 = this;
            java.util.logging.Formatter[] r0 = r5.attachmentFormatters
            int r0 = r0.length
            java.util.logging.Formatter[] r1 = r5.attachmentNames
            int r2 = r1.length
            r3 = 0
            if (r2 == r0) goto L17
            java.lang.Class<java.util.logging.Formatter[]> r4 = java.util.logging.Formatter[].class
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r0, r4)
            java.util.logging.Formatter[] r1 = (java.util.logging.Formatter[]) r1
            r5.attachmentNames = r1
            if (r2 == 0) goto L17
            r1 = 1
            goto L18
        L17:
            r1 = r3
        L18:
            if (r0 != 0) goto L21
            java.util.logging.Formatter[] r0 = emptyFormatterArray()
            r5.attachmentNames = r0
            goto L3a
        L21:
            if (r3 >= r0) goto L3a
            java.util.logging.Formatter[] r2 = r5.attachmentNames
            r4 = r2[r3]
            if (r4 != 0) goto L37
            java.util.logging.Formatter[] r4 = r5.attachmentFormatters
            r4 = r4[r3]
            java.lang.String r4 = r5.toString(r4)
            java.util.logging.Formatter r4 = com.sun.mail.util.logging.MailHandler.TailNameFormatter.of(r4)
            r2[r3] = r4
        L37:
            int r3 = r3 + 1
            goto L21
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.MailHandler.alignAttachmentNames():boolean");
    }

    private boolean alignAttachmentFilters() {
        int length = this.attachmentFormatters.length;
        int length2 = this.attachmentFilters.length;
        if (length2 != length) {
            this.attachmentFilters = (Filter[]) Arrays.copyOf(this.attachmentFilters, length, Filter[].class);
            clearMatches(length2);
            r2 = length2 != 0;
            Filter filter = this.filter;
            if (filter != null) {
                while (length2 < length) {
                    this.attachmentFilters[length2] = filter;
                    length2++;
                }
            }
        }
        if (length == 0) {
            this.attachmentFilters = emptyFilterArray();
        }
        return r2;
    }

    private void reset() {
        int i = this.size;
        LogRecord[] logRecordArr = this.data;
        if (i < logRecordArr.length) {
            Arrays.fill(logRecordArr, 0, i, (Object) null);
        } else {
            Arrays.fill(logRecordArr, (Object) null);
        }
        this.size = 0;
    }

    private void grow() {
        int length = this.data.length;
        int i = (length >> 1) + length + 1;
        if (i > this.capacity || i < length) {
            i = this.capacity;
        }
        this.data = (LogRecord[]) Arrays.copyOf(this.data, i, LogRecord[].class);
        this.matched = Arrays.copyOf(this.matched, i);
    }

    private synchronized void init(Properties properties) {
        String name = getClass().getName();
        this.mailProps = new Properties();
        Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
        this.contentTypes = FileTypeMap.getDefaultFileTypeMap();
        getAndSetContextClassLoader(andSetContextClassLoader);
        initErrorManager(name);
        initLevel(name);
        initFilter(name);
        initCapacity(name);
        initAuthenticator(name);
        initEncoding(name);
        initFormatter(name);
        initComparator(name);
        initPushLevel(name);
        initPushFilter(name);
        initSubject(name);
        initAttachmentFormaters(name);
        initAttachmentFilters(name);
        initAttachmentNames(name);
        if (properties == null && LogManagerProperties.fromLogManager(name.concat(".verify")) != null) {
            verifySettings(initSession());
        }
        intern();
    }

    private void intern() {
        try {
            Map<Object, Object> hashMap = new HashMap<>();
            try {
                intern(hashMap, this.errorManager);
            } catch (SecurityException e) {
                reportError(e.getMessage(), e, 4);
            }
            try {
                Object obj = this.filter;
                Object intern = intern(hashMap, obj);
                if (intern != obj && (intern instanceof Filter)) {
                    this.filter = (Filter) intern;
                }
                Object obj2 = this.formatter;
                Object intern2 = intern(hashMap, obj2);
                if (intern2 != obj2 && (intern2 instanceof Formatter)) {
                    this.formatter = (Formatter) intern2;
                }
            } catch (SecurityException e2) {
                reportError(e2.getMessage(), e2, 4);
            }
            Object obj3 = this.subjectFormatter;
            Object intern3 = intern(hashMap, obj3);
            if (intern3 != obj3 && (intern3 instanceof Formatter)) {
                this.subjectFormatter = (Formatter) intern3;
            }
            Object obj4 = this.pushFilter;
            Object intern4 = intern(hashMap, obj4);
            if (intern4 != obj4 && (intern4 instanceof Filter)) {
                this.pushFilter = (Filter) intern4;
            }
            for (int i = 0; i < this.attachmentFormatters.length; i++) {
                Object obj5 = this.attachmentFormatters[i];
                Object intern5 = intern(hashMap, obj5);
                if (intern5 != obj5 && (intern5 instanceof Formatter)) {
                    this.attachmentFormatters[i] = (Formatter) intern5;
                }
                Object obj6 = this.attachmentFilters[i];
                Object intern6 = intern(hashMap, obj6);
                if (intern6 != obj6 && (intern6 instanceof Filter)) {
                    this.attachmentFilters[i] = (Filter) intern6;
                }
                Object obj7 = this.attachmentNames[i];
                Object intern7 = intern(hashMap, obj7);
                if (intern7 != obj7 && (intern7 instanceof Formatter)) {
                    this.attachmentNames[i] = (Formatter) intern7;
                }
            }
        } catch (Exception e3) {
            reportError(e3.getMessage(), e3, 4);
        } catch (LinkageError e4) {
            reportError(e4.getMessage(), new InvocationTargetException(e4), 4);
        }
    }

    private Object intern(Map<Object, Object> map, Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        Object newInstance = obj.getClass().getName().equals(TailNameFormatter.class.getName()) ? obj : obj.getClass().getConstructor(new Class[0]).newInstance(new Object[0]);
        if (newInstance.getClass() == obj.getClass()) {
            Object obj2 = map.get(newInstance);
            if (obj2 == null) {
                boolean equals = newInstance.equals(obj);
                boolean equals2 = obj.equals(newInstance);
                if (!equals || !equals2) {
                    if (equals != equals2) {
                        reportNonSymmetric(obj, newInstance);
                        return obj;
                    }
                    return obj;
                }
                Object put = map.put(obj, obj);
                if (put != null) {
                    reportNonDiscriminating(newInstance, put);
                    Object remove = map.remove(newInstance);
                    if (remove != obj) {
                        reportNonDiscriminating(newInstance, remove);
                        map.clear();
                        return obj;
                    }
                    return obj;
                }
                return obj;
            } else if (obj.getClass() == obj2.getClass()) {
                return obj2;
            } else {
                reportNonDiscriminating(obj, obj2);
                return obj;
            }
        }
        return obj;
    }

    private static Formatter createSimpleFormatter() {
        return (Formatter) Formatter.class.cast(new SimpleFormatter());
    }

    private static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    private static boolean hasValue(String str) {
        return (isEmpty(str) || "null".equalsIgnoreCase(str)) ? false : true;
    }

    private void initAttachmentFilters(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".attachment.filters"));
        if (!isEmpty(fromLogManager)) {
            String[] split = fromLogManager.split(",");
            int length = split.length;
            Filter[] filterArr = new Filter[length];
            for (int i = 0; i < length; i++) {
                split[i] = split[i].trim();
                if (!"null".equalsIgnoreCase(split[i])) {
                    try {
                        filterArr[i] = LogManagerProperties.newFilter(split[i]);
                    } catch (SecurityException e) {
                        throw e;
                    } catch (Exception e2) {
                        reportError(e2.getMessage(), e2, 4);
                    }
                }
            }
            this.attachmentFilters = filterArr;
            if (alignAttachmentFilters()) {
                reportError("Attachment filters.", attachmentMismatch("Length mismatch."), 4);
                return;
            }
            return;
        }
        this.attachmentFilters = emptyFilterArray();
        alignAttachmentFilters();
    }

    private void initAttachmentFormaters(String str) {
        Formatter[] formatterArr;
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".attachment.formatters"));
        if (!isEmpty(fromLogManager)) {
            String[] split = fromLogManager.split(",");
            if (split.length == 0) {
                formatterArr = emptyFormatterArray();
            } else {
                formatterArr = new Formatter[split.length];
            }
            for (int i = 0; i < formatterArr.length; i++) {
                split[i] = split[i].trim();
                if (!"null".equalsIgnoreCase(split[i])) {
                    try {
                        formatterArr[i] = LogManagerProperties.newFormatter(split[i]);
                        if (formatterArr[i] instanceof TailNameFormatter) {
                            reportError("Attachment formatter.", new ClassNotFoundException(formatterArr[i].toString()), 4);
                            formatterArr[i] = createSimpleFormatter();
                        }
                    } catch (SecurityException e) {
                        throw e;
                    } catch (Exception e2) {
                        reportError(e2.getMessage(), e2, 4);
                        formatterArr[i] = createSimpleFormatter();
                    }
                } else {
                    reportError("Attachment formatter.", new NullPointerException(atIndexMsg(i)), 4);
                    formatterArr[i] = createSimpleFormatter();
                }
            }
            this.attachmentFormatters = formatterArr;
            return;
        }
        this.attachmentFormatters = emptyFormatterArray();
    }

    private void initAttachmentNames(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".attachment.names"));
        if (!isEmpty(fromLogManager)) {
            String[] split = fromLogManager.split(",");
            int length = split.length;
            Formatter[] formatterArr = new Formatter[length];
            for (int i = 0; i < length; i++) {
                split[i] = split[i].trim();
                if (!"null".equalsIgnoreCase(split[i])) {
                    try {
                        try {
                            formatterArr[i] = LogManagerProperties.newFormatter(split[i]);
                        } catch (ClassCastException | ClassNotFoundException unused) {
                            formatterArr[i] = TailNameFormatter.of(split[i]);
                        }
                    } catch (SecurityException e) {
                        throw e;
                    } catch (Exception e2) {
                        reportError(e2.getMessage(), e2, 4);
                    }
                } else {
                    reportError("Attachment names.", new NullPointerException(atIndexMsg(i)), 4);
                }
            }
            this.attachmentNames = formatterArr;
            if (alignAttachmentNames()) {
                reportError("Attachment names.", attachmentMismatch("Length mismatch."), 4);
                return;
            }
            return;
        }
        this.attachmentNames = emptyFormatterArray();
        alignAttachmentNames();
    }

    private void initAuthenticator(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".authenticator"));
        if (fromLogManager == null || "null".equalsIgnoreCase(fromLogManager)) {
            return;
        }
        if (fromLogManager.length() != 0) {
            try {
                this.auth = (Authenticator) LogManagerProperties.newObjectFrom(fromLogManager, Authenticator.class);
                return;
            } catch (ClassCastException | ClassNotFoundException unused) {
                this.auth = DefaultAuthenticator.of(fromLogManager);
                return;
            } catch (SecurityException e) {
                throw e;
            } catch (Exception e2) {
                reportError(e2.getMessage(), e2, 4);
                return;
            }
        }
        this.auth = DefaultAuthenticator.of(fromLogManager);
    }

    private void initLevel(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".level"));
            if (fromLogManager != null) {
                this.logLevel = Level.parse(fromLogManager);
            } else {
                this.logLevel = Level.WARNING;
            }
        } catch (SecurityException e) {
            throw e;
        } catch (RuntimeException e2) {
            reportError(e2.getMessage(), e2, 4);
            this.logLevel = Level.WARNING;
        }
    }

    private void initFilter(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".filter"));
            if (hasValue(fromLogManager)) {
                this.filter = LogManagerProperties.newFilter(fromLogManager);
            }
        } catch (SecurityException e) {
            throw e;
        } catch (Exception e2) {
            reportError(e2.getMessage(), e2, 4);
        }
    }

    private void initCapacity(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".capacity"));
            if (fromLogManager != null) {
                setCapacity0(Integer.parseInt(fromLogManager));
            } else {
                setCapacity0(1000);
            }
        } catch (SecurityException e) {
            throw e;
        } catch (RuntimeException e2) {
            reportError(e2.getMessage(), e2, 4);
        }
        if (this.capacity <= 0) {
            this.capacity = 1000;
        }
        LogRecord[] logRecordArr = new LogRecord[1];
        this.data = logRecordArr;
        this.matched = new int[logRecordArr.length];
    }

    private void initEncoding(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".encoding"));
            if (fromLogManager != null) {
                setEncoding0(fromLogManager);
            }
        } catch (UnsupportedEncodingException e) {
            e = e;
            reportError(e.getMessage(), e, 4);
        } catch (SecurityException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            e = e3;
            reportError(e.getMessage(), e, 4);
        }
    }

    private ErrorManager defaultErrorManager() {
        ErrorManager errorManager;
        try {
            errorManager = super.getErrorManager();
        } catch (LinkageError | RuntimeException unused) {
            errorManager = null;
        }
        return errorManager == null ? new ErrorManager() : errorManager;
    }

    private void initErrorManager(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".errorManager"));
            if (fromLogManager != null) {
                setErrorManager0(LogManagerProperties.newErrorManager(fromLogManager));
            }
        } catch (SecurityException e) {
            throw e;
        } catch (Exception e2) {
            reportError(e2.getMessage(), e2, 4);
        }
    }

    private void initFormatter(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".formatter"));
            if (hasValue(fromLogManager)) {
                Formatter newFormatter = LogManagerProperties.newFormatter(fromLogManager);
                if (!(newFormatter instanceof TailNameFormatter)) {
                    this.formatter = newFormatter;
                } else {
                    this.formatter = createSimpleFormatter();
                }
            } else {
                this.formatter = createSimpleFormatter();
            }
        } catch (SecurityException e) {
            throw e;
        } catch (Exception e2) {
            reportError(e2.getMessage(), e2, 4);
            this.formatter = createSimpleFormatter();
        }
    }

    private void initComparator(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".comparator"));
            String fromLogManager2 = LogManagerProperties.fromLogManager(str.concat(".comparator.reverse"));
            if (hasValue(fromLogManager)) {
                this.comparator = LogManagerProperties.newComparator(fromLogManager);
                if (Boolean.parseBoolean(fromLogManager2)) {
                    this.comparator = LogManagerProperties.reverseOrder(this.comparator);
                }
            } else if (!isEmpty(fromLogManager2)) {
                throw new IllegalArgumentException("No comparator to reverse.");
            }
        } catch (SecurityException e) {
            throw e;
        } catch (Exception e2) {
            reportError(e2.getMessage(), e2, 4);
        }
    }

    private void initPushLevel(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".pushLevel"));
            if (fromLogManager != null) {
                this.pushLevel = Level.parse(fromLogManager);
            }
        } catch (RuntimeException e) {
            reportError(e.getMessage(), e, 4);
        }
        if (this.pushLevel == null) {
            this.pushLevel = Level.OFF;
        }
    }

    private void initPushFilter(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".pushFilter"));
            if (hasValue(fromLogManager)) {
                this.pushFilter = LogManagerProperties.newFilter(fromLogManager);
            }
        } catch (SecurityException e) {
            throw e;
        } catch (Exception e2) {
            reportError(e2.getMessage(), e2, 4);
        }
    }

    private void initSubject(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".subject"));
        if (fromLogManager == null) {
            fromLogManager = "com.sun.mail.util.logging.CollectorFormatter";
        }
        if (hasValue(fromLogManager)) {
            try {
                this.subjectFormatter = LogManagerProperties.newFormatter(fromLogManager);
                return;
            } catch (ClassCastException | ClassNotFoundException unused) {
                this.subjectFormatter = TailNameFormatter.of(fromLogManager);
                return;
            } catch (SecurityException e) {
                throw e;
            } catch (Exception e2) {
                this.subjectFormatter = TailNameFormatter.of(fromLogManager);
                reportError(e2.getMessage(), e2, 4);
                return;
            }
        }
        this.subjectFormatter = TailNameFormatter.of(fromLogManager);
    }

    private boolean isAttachmentLoggable(LogRecord logRecord) {
        Filter[] readOnlyAttachmentFilters = readOnlyAttachmentFilters();
        for (int i = 0; i < readOnlyAttachmentFilters.length; i++) {
            Filter filter = readOnlyAttachmentFilters[i];
            if (filter == null || filter.isLoggable(logRecord)) {
                setMatchedPart(i);
                return true;
            }
        }
        return false;
    }

    private boolean isPushable(LogRecord logRecord) {
        int intValue = getPushLevel().intValue();
        if (intValue == offValue || logRecord.getLevel().intValue() < intValue) {
            return false;
        }
        Filter pushFilter = getPushFilter();
        if (pushFilter == null) {
            return true;
        }
        int matchedPart = getMatchedPart();
        if (!(matchedPart == -1 && getFilter() == pushFilter) && (matchedPart < 0 || this.attachmentFilters[matchedPart] != pushFilter)) {
            return pushFilter.isLoggable(logRecord);
        }
        return true;
    }

    private void push(boolean z, int i) {
        try {
            if (tryMutex()) {
                try {
                    Message writeLogRecords = writeLogRecords(i);
                    if (writeLogRecords != null) {
                        send(writeLogRecords, z, i);
                    }
                } catch (LinkageError e) {
                    reportLinkageError(e, i);
                }
                return;
            }
            reportUnPublishedError(null);
        } finally {
            releaseMutex();
        }
    }

    private void send(Message message, boolean z, int i) {
        try {
            envelopeFor(message, z);
            Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
            Transport.send(message);
            getAndSetContextClassLoader(andSetContextClassLoader);
        } catch (RuntimeException e) {
            reportError(message, e, i);
        } catch (Exception e2) {
            reportError(message, e2, i);
        }
    }

    private void sort() {
        Comparator<? super LogRecord> comparator = this.comparator;
        if (comparator != null) {
            try {
                if (this.size != 1) {
                    Arrays.sort(this.data, 0, this.size, comparator);
                } else if (comparator.compare(this.data[0], this.data[0]) != 0) {
                    throw new IllegalArgumentException(this.comparator.getClass().getName());
                }
            } catch (RuntimeException e) {
                reportError(e.getMessage(), e, 5);
            }
        }
    }

    private Message writeLogRecords(int i) {
        try {
            synchronized (this) {
                if (this.size <= 0 || this.isWriting) {
                    return null;
                }
                this.isWriting = true;
                Message writeLogRecords0 = writeLogRecords0();
                this.isWriting = false;
                if (this.size > 0) {
                    reset();
                }
                return writeLogRecords0;
            }
        } catch (RuntimeException e) {
            reportError(e.getMessage(), e, i);
            return null;
        } catch (Exception e2) {
            reportError(e2.getMessage(), e2, i);
            return null;
        }
    }

    private Message writeLogRecords0() throws Exception {
        MimePart createBodyPart;
        int i;
        StringBuilder sb;
        Filter filter;
        boolean z;
        sort();
        if (this.session == null) {
            initSession();
        }
        MimeMessage mimeMessage = new MimeMessage(this.session);
        int length = this.attachmentFormatters.length;
        BodyPart[] bodyPartArr = new MimeBodyPart[length];
        CharSequence[] charSequenceArr = new StringBuilder[length];
        if (length == 0) {
            mimeMessage.setDescription(descriptionFrom(getFormatter(), getFilter(), this.subjectFormatter));
            createBodyPart = mimeMessage;
        } else {
            mimeMessage.setDescription(descriptionFrom(this.comparator, this.pushLevel, this.pushFilter));
            createBodyPart = createBodyPart();
        }
        appendSubject(mimeMessage, head(this.subjectFormatter));
        Formatter formatter = getFormatter();
        Filter filter2 = getFilter();
        LogRecord logRecord = null;
        StringBuilder sb2 = null;
        Object obj = null;
        int i2 = 0;
        while (i2 < this.size) {
            int i3 = this.matched[i2];
            LogRecord[] logRecordArr = this.data;
            LogRecord logRecord2 = logRecordArr[i2];
            logRecordArr[i2] = logRecord;
            Locale localeFor = localeFor(logRecord2);
            appendSubject(mimeMessage, format(this.subjectFormatter, logRecord2));
            if (filter2 == null || i3 == -1 || length == 0 || (i3 < -1 && filter2.isLoggable(logRecord2))) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                    sb2.append(head(formatter));
                }
                sb2.append(format(formatter, logRecord2));
                if (localeFor != null && !localeFor.equals(obj)) {
                    appendContentLang(createBodyPart, localeFor);
                }
                filter = filter2;
                z = true;
            } else {
                z = false;
                filter = null;
            }
            Filter filter3 = filter2;
            Filter filter4 = filter;
            int i4 = 0;
            while (i4 < length) {
                StringBuilder sb3 = sb2;
                Filter filter5 = this.attachmentFilters[i4];
                if (filter5 == null || filter4 == filter5 || i3 == i4 || (i3 < i4 && filter5.isLoggable(logRecord2))) {
                    if (filter4 == null && filter5 != null) {
                        filter4 = filter5;
                    }
                    if (bodyPartArr[i4] == null) {
                        bodyPartArr[i4] = createBodyPart(i4);
                        charSequenceArr[i4] = new StringBuilder();
                        charSequenceArr[i4].append(head(this.attachmentFormatters[i4]));
                        appendFileName(bodyPartArr[i4], head(this.attachmentNames[i4]));
                    }
                    appendFileName(bodyPartArr[i4], format(this.attachmentNames[i4], logRecord2));
                    charSequenceArr[i4].append(format(this.attachmentFormatters[i4], logRecord2));
                    if (localeFor != null && !localeFor.equals(obj)) {
                        appendContentLang(bodyPartArr[i4], localeFor);
                    }
                    z = true;
                }
                i4++;
                sb2 = sb3;
            }
            StringBuilder sb4 = sb2;
            if (z) {
                if (createBodyPart != mimeMessage && localeFor != null && !localeFor.equals(obj)) {
                    appendContentLang(mimeMessage, localeFor);
                }
            } else {
                reportFilterError(logRecord2);
            }
            i2++;
            obj = localeFor;
            filter2 = filter3;
            sb2 = sb4;
            logRecord = null;
        }
        this.size = 0;
        for (int i5 = length - 1; i5 >= 0; i5--) {
            if (bodyPartArr[i5] != null) {
                appendFileName(bodyPartArr[i5], tail(this.attachmentNames[i5], NotificationCompat.CATEGORY_ERROR));
                charSequenceArr[i5].append(tail(this.attachmentFormatters[i5], ""));
                if (charSequenceArr[i5].length() > 0) {
                    String fileName = bodyPartArr[i5].getFileName();
                    if (isEmpty(fileName)) {
                        fileName = toString(this.attachmentFormatters[i5]);
                        bodyPartArr[i5].setFileName(fileName);
                    }
                    setContent(bodyPartArr[i5], charSequenceArr[i5], getContentType(fileName));
                    sb = null;
                } else {
                    setIncompleteCopy(mimeMessage);
                    sb = null;
                    bodyPartArr[i5] = null;
                }
                charSequenceArr[i5] = sb;
            }
        }
        if (sb2 != null) {
            sb2.append(tail(formatter, ""));
            i = 0;
        } else {
            i = 0;
            sb2 = new StringBuilder(0);
        }
        appendSubject(mimeMessage, tail(this.subjectFormatter, ""));
        String contentTypeOf = contentTypeOf(sb2);
        String contentTypeOf2 = contentTypeOf(formatter);
        if (contentTypeOf2 != null) {
            contentTypeOf = contentTypeOf2;
        }
        setContent(createBodyPart, sb2, contentTypeOf);
        if (createBodyPart != mimeMessage) {
            Multipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart((BodyPart) createBodyPart);
            for (int i6 = i; i6 < length; i6++) {
                if (bodyPartArr[i6] != null) {
                    mimeMultipart.addBodyPart(bodyPartArr[i6]);
                }
            }
            mimeMessage.setContent(mimeMultipart);
        }
        return mimeMessage;
    }

    private void verifySettings(Session session) {
        if (session != null) {
            try {
                Object put = session.getProperties().put("verify", "");
                if (put instanceof String) {
                    String str = (String) put;
                    if (hasValue(str)) {
                        verifySettings0(session, str);
                    }
                } else if (put != null) {
                    verifySettings0(session, put.getClass().toString());
                }
            } catch (LinkageError e) {
                reportLinkageError(e, 4);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:45|46|(10:51|(1:53)(1:131)|54|(1:56)(1:130)|57|(4:119|120|(2:122|(1:124))(1:127)|125)|59|(14:87|88|(1:92)|93|94|95|96|97|2a4|104|(1:106)|107|108|109)|61|(6:63|(1:65)|66|(1:(2:83|84))(3:70|(3:73|(1:75)(3:76|77|78)|71)|79)|80|81)(2:85|86))|132|133|134|135|136|137|(1:139)|141|142|143|144|145|(1:147)(1:153)|148|(1:150)|151|59|(0)|61|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x023c, code lost:
        setErrorContent(r5, r18, r0);
        reportError(r5, r0, 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0206, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0207, code lost:
        r14 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0220, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0222, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0223, code lost:
        r10 = r14;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x023c A[Catch: Exception -> 0x039c, RuntimeException -> 0x03a5, TryCatch #15 {RuntimeException -> 0x03a5, blocks: (B:32:0x00da, B:34:0x00e0, B:36:0x00e3, B:41:0x00ee, B:43:0x00f1, B:51:0x0117, B:53:0x0120, B:56:0x012a, B:58:0x0155, B:60:0x0161, B:62:0x0181, B:64:0x01b5, B:126:0x0269, B:139:0x0297, B:138:0x028c, B:76:0x01e1, B:63:0x019c, B:59:0x015c, B:77:0x01ee, B:83:0x0201, B:87:0x0208, B:89:0x0210, B:124:0x0261, B:90:0x0214, B:109:0x0236, B:111:0x023c, B:112:0x0243, B:114:0x0249, B:116:0x024c, B:117:0x0252, B:119:0x0258, B:121:0x025b, B:100:0x022b, B:106:0x0233, B:44:0x00fd, B:45:0x0107, B:39:0x00e8, B:48:0x010a, B:50:0x0114), top: B:218:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0261 A[Catch: Exception -> 0x039c, RuntimeException -> 0x03a5, TryCatch #15 {RuntimeException -> 0x03a5, blocks: (B:32:0x00da, B:34:0x00e0, B:36:0x00e3, B:41:0x00ee, B:43:0x00f1, B:51:0x0117, B:53:0x0120, B:56:0x012a, B:58:0x0155, B:60:0x0161, B:62:0x0181, B:64:0x01b5, B:126:0x0269, B:139:0x0297, B:138:0x028c, B:76:0x01e1, B:63:0x019c, B:59:0x015c, B:77:0x01ee, B:83:0x0201, B:87:0x0208, B:89:0x0210, B:124:0x0261, B:90:0x0214, B:109:0x0236, B:111:0x023c, B:112:0x0243, B:114:0x0249, B:116:0x024c, B:117:0x0252, B:119:0x0258, B:121:0x025b, B:100:0x022b, B:106:0x0233, B:44:0x00fd, B:45:0x0107, B:39:0x00e8, B:48:0x010a, B:50:0x0114), top: B:218:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0318 A[Catch: RuntimeException -> 0x0399, Exception -> 0x039c, TryCatch #16 {Exception -> 0x039c, blocks: (B:32:0x00da, B:34:0x00e0, B:36:0x00e3, B:41:0x00ee, B:43:0x00f1, B:51:0x0117, B:53:0x0120, B:56:0x012a, B:58:0x0155, B:60:0x0161, B:62:0x0181, B:64:0x01b5, B:66:0x01bd, B:68:0x01cb, B:70:0x01d4, B:71:0x01d9, B:126:0x0269, B:128:0x0271, B:130:0x0279, B:132:0x0281, B:133:0x0285, B:139:0x0297, B:150:0x02fd, B:159:0x030a, B:156:0x0305, B:157:0x0308, B:160:0x0315, B:162:0x0318, B:164:0x0327, B:165:0x032d, B:167:0x0337, B:169:0x033a, B:170:0x033e, B:172:0x0341, B:174:0x0349, B:175:0x034c, B:176:0x036c, B:178:0x036f, B:179:0x0377, B:180:0x0383, B:181:0x0384, B:182:0x038b, B:138:0x028c, B:76:0x01e1, B:63:0x019c, B:59:0x015c, B:77:0x01ee, B:83:0x0201, B:87:0x0208, B:89:0x0210, B:124:0x0261, B:90:0x0214, B:109:0x0236, B:111:0x023c, B:112:0x0243, B:114:0x0249, B:116:0x024c, B:117:0x0252, B:119:0x0258, B:121:0x025b, B:100:0x022b, B:106:0x0233, B:44:0x00fd, B:45:0x0107, B:39:0x00e8, B:48:0x010a, B:50:0x0114, B:189:0x0395, B:190:0x0398), top: B:218:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0384 A[Catch: RuntimeException -> 0x0399, Exception -> 0x039c, TryCatch #16 {Exception -> 0x039c, blocks: (B:32:0x00da, B:34:0x00e0, B:36:0x00e3, B:41:0x00ee, B:43:0x00f1, B:51:0x0117, B:53:0x0120, B:56:0x012a, B:58:0x0155, B:60:0x0161, B:62:0x0181, B:64:0x01b5, B:66:0x01bd, B:68:0x01cb, B:70:0x01d4, B:71:0x01d9, B:126:0x0269, B:128:0x0271, B:130:0x0279, B:132:0x0281, B:133:0x0285, B:139:0x0297, B:150:0x02fd, B:159:0x030a, B:156:0x0305, B:157:0x0308, B:160:0x0315, B:162:0x0318, B:164:0x0327, B:165:0x032d, B:167:0x0337, B:169:0x033a, B:170:0x033e, B:172:0x0341, B:174:0x0349, B:175:0x034c, B:176:0x036c, B:178:0x036f, B:179:0x0377, B:180:0x0383, B:181:0x0384, B:182:0x038b, B:138:0x028c, B:76:0x01e1, B:63:0x019c, B:59:0x015c, B:77:0x01ee, B:83:0x0201, B:87:0x0208, B:89:0x0210, B:124:0x0261, B:90:0x0214, B:109:0x0236, B:111:0x023c, B:112:0x0243, B:114:0x0249, B:116:0x024c, B:117:0x0252, B:119:0x0258, B:121:0x025b, B:100:0x022b, B:106:0x0233, B:44:0x00fd, B:45:0x0107, B:39:0x00e8, B:48:0x010a, B:50:0x0114, B:189:0x0395, B:190:0x0398), top: B:218:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0271 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void verifySettings0(javax.mail.Session r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 945
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.MailHandler.verifySettings0(javax.mail.Session, java.lang.String):void");
    }

    private void saveChangesNoContent(Message message, String str) {
        if (message != null) {
            try {
                try {
                    message.saveChanges();
                } catch (NullPointerException e) {
                    try {
                        if (message.getHeader("Content-Transfer-Encoding") == null) {
                            message.setHeader("Content-Transfer-Encoding", "base64");
                            message.saveChanges();
                            return;
                        }
                        throw e;
                    } catch (RuntimeException | MessagingException e2) {
                        if (e2 != e) {
                            e2.addSuppressed(e);
                        }
                        throw e2;
                    }
                }
            } catch (RuntimeException | MessagingException e3) {
                reportError(str, e3, 5);
            }
        }
    }

    private static void verifyProperties(Session session, String str) {
        session.getProperty("mail.from");
        session.getProperty("mail." + str + ".from");
        session.getProperty("mail.dsn.ret");
        session.getProperty("mail." + str + ".dsn.ret");
        session.getProperty("mail.dsn.notify");
        session.getProperty("mail." + str + ".dsn.notify");
        session.getProperty("mail." + str + ".port");
        session.getProperty("mail.user");
        session.getProperty("mail." + str + ".user");
        session.getProperty("mail." + str + ".localport");
    }

    private static InetAddress verifyHost(String str) throws IOException {
        InetAddress byName;
        if (isEmpty(str)) {
            byName = InetAddress.getLocalHost();
        } else {
            byName = InetAddress.getByName(str);
        }
        if (byName.getCanonicalHostName().length() != 0) {
            return byName;
        }
        throw new UnknownHostException();
    }

    private static void verifyAddresses(Address[] addressArr) throws AddressException {
        if (addressArr != null) {
            for (Address address : addressArr) {
                if (address instanceof InternetAddress) {
                    ((InternetAddress) address).validate();
                }
            }
        }
    }

    private void reportUnexpectedSend(MimeMessage mimeMessage, String str, Exception exc) {
        Exception messagingException = new MessagingException("An empty message was sent.", exc);
        setErrorContent(mimeMessage, str, messagingException);
        reportError(mimeMessage, messagingException, 4);
    }

    private void setErrorContent(MimeMessage mimeMessage, String str, Throwable th) {
        MimeBodyPart createBodyPart;
        String descriptionFrom;
        String classId;
        String name;
        try {
            synchronized (this) {
                createBodyPart = createBodyPart();
                descriptionFrom = descriptionFrom(this.comparator, this.pushLevel, this.pushFilter);
                classId = getClassId(this.subjectFormatter);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Formatted using ");
            if (th == null) {
                name = Throwable.class.getName();
            } else {
                name = th.getClass().getName();
            }
            sb.append(name);
            sb.append(", filtered with ");
            sb.append(str);
            sb.append(", and named by ");
            sb.append(classId);
            sb.append('.');
            createBodyPart.setDescription(sb.toString());
            setContent(createBodyPart, toMsgString(th), "text/plain");
            Multipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(createBodyPart);
            mimeMessage.setContent(mimeMultipart);
            mimeMessage.setDescription(descriptionFrom);
            setAcceptLang(mimeMessage);
            mimeMessage.saveChanges();
        } catch (RuntimeException | MessagingException e) {
            reportError("Unable to create body.", e, 4);
        }
    }

    private Session updateSession() {
        if (this.mailProps.getProperty("verify") != null) {
            return initSession();
        }
        this.session = null;
        return null;
    }

    private Session initSession() {
        Session session = Session.getInstance(new LogManagerProperties(this.mailProps, getClass().getName()), this.auth);
        this.session = session;
        return session;
    }

    private void envelopeFor(Message message, boolean z) {
        setAcceptLang(message);
        setFrom(message);
        if (!setRecipient(message, "mail.to", Message.RecipientType.TO)) {
            setDefaultRecipient(message, Message.RecipientType.TO);
        }
        setRecipient(message, "mail.cc", Message.RecipientType.CC);
        setRecipient(message, "mail.bcc", Message.RecipientType.BCC);
        setReplyTo(message);
        setSender(message);
        setMailer(message);
        setAutoSubmitted(message);
        if (z) {
            setPriority(message);
        }
        try {
            message.setSentDate(new Date());
        } catch (MessagingException e) {
            reportError(e.getMessage(), e, 5);
        }
    }

    private MimeBodyPart createBodyPart() throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDisposition(Part.INLINE);
        mimeBodyPart.setDescription(descriptionFrom(getFormatter(), getFilter(), this.subjectFormatter));
        setAcceptLang(mimeBodyPart);
        return mimeBodyPart;
    }

    private MimeBodyPart createBodyPart(int i) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDisposition(Part.ATTACHMENT);
        mimeBodyPart.setDescription(descriptionFrom(this.attachmentFormatters[i], this.attachmentFilters[i], this.attachmentNames[i]));
        setAcceptLang(mimeBodyPart);
        return mimeBodyPart;
    }

    private String descriptionFrom(Comparator<?> comparator, Level level, Filter filter) {
        StringBuilder sb = new StringBuilder();
        sb.append("Sorted using ");
        sb.append(comparator == null ? "no comparator" : comparator.getClass().getName());
        sb.append(", pushed when ");
        sb.append(level.getName());
        sb.append(", and ");
        sb.append(filter == null ? "no push filter" : filter.getClass().getName());
        sb.append('.');
        return sb.toString();
    }

    private String descriptionFrom(Formatter formatter, Filter filter, Formatter formatter2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Formatted using ");
        sb.append(getClassId(formatter));
        sb.append(", filtered with ");
        sb.append(filter == null ? "no filter" : filter.getClass().getName());
        sb.append(", and named by ");
        sb.append(getClassId(formatter2));
        sb.append('.');
        return sb.toString();
    }

    private String getClassId(Formatter formatter) {
        if (formatter instanceof TailNameFormatter) {
            return String.class.getName();
        }
        return formatter.getClass().getName();
    }

    private String toString(Formatter formatter) {
        String obj = formatter.toString();
        return !isEmpty(obj) ? obj : getClassId(formatter);
    }

    private void appendFileName(Part part, String str) {
        if (str != null) {
            if (str.length() > 0) {
                appendFileName0(part, str);
                return;
            }
            return;
        }
        reportNullError(5);
    }

    private void appendFileName0(Part part, String str) {
        try {
            String replaceAll = str.replaceAll("[\\x00-\\x1F\\x7F]+", "");
            String fileName = part.getFileName();
            if (fileName != null) {
                replaceAll = fileName.concat(replaceAll);
            }
            part.setFileName(replaceAll);
        } catch (MessagingException e) {
            reportError(e.getMessage(), e, 5);
        }
    }

    private void appendSubject(Message message, String str) {
        if (str != null) {
            if (str.length() > 0) {
                appendSubject0(message, str);
                return;
            }
            return;
        }
        reportNullError(5);
    }

    private void appendSubject0(Message message, String str) {
        try {
            String replaceAll = str.replaceAll("[\\x00-\\x1F\\x7F]+", "");
            String encodingName = getEncodingName();
            String subject = message.getSubject();
            MimeMessage mimeMessage = (MimeMessage) message;
            if (subject != null) {
                replaceAll = subject.concat(replaceAll);
            }
            mimeMessage.setSubject(replaceAll, MimeUtility.mimeCharset(encodingName));
        } catch (MessagingException e) {
            reportError(e.getMessage(), e, 5);
        }
    }

    private Locale localeFor(LogRecord logRecord) {
        ResourceBundle resourceBundle = logRecord.getResourceBundle();
        if (resourceBundle != null) {
            Locale locale = resourceBundle.getLocale();
            return (locale == null || isEmpty(locale.getLanguage())) ? Locale.getDefault() : locale;
        }
        return null;
    }

    private void appendContentLang(MimePart mimePart, Locale locale) {
        int length;
        String concat;
        try {
            String languageTag = LogManagerProperties.toLanguageTag(locale);
            if (languageTag.length() != 0) {
                String header = mimePart.getHeader("Content-Language", null);
                if (isEmpty(header)) {
                    mimePart.setHeader("Content-Language", languageTag);
                } else if (header.equalsIgnoreCase(languageTag)) {
                } else {
                    String concat2 = ",".concat(languageTag);
                    int i = 0;
                    do {
                        i = header.indexOf(concat2, i);
                        if (i <= -1 || (i = i + concat2.length()) == header.length()) {
                            break;
                        }
                    } while (header.charAt(i) != ',');
                    if (i < 0) {
                        int lastIndexOf = header.lastIndexOf("\r\n\t");
                        if (lastIndexOf < 0) {
                            length = header.length() + 20;
                        } else {
                            length = (header.length() - lastIndexOf) + 8;
                        }
                        if (length + concat2.length() > 76) {
                            concat = header.concat("\r\n\t".concat(concat2));
                        } else {
                            concat = header.concat(concat2);
                        }
                        mimePart.setHeader("Content-Language", concat);
                    }
                }
            }
        } catch (MessagingException e) {
            reportError(e.getMessage(), e, 5);
        }
    }

    private void setAcceptLang(Part part) {
        try {
            String languageTag = LogManagerProperties.toLanguageTag(Locale.getDefault());
            if (languageTag.length() != 0) {
                part.setHeader("Accept-Language", languageTag);
            }
        } catch (MessagingException e) {
            reportError(e.getMessage(), e, 5);
        }
    }

    private void reportFilterError(LogRecord logRecord) {
        Formatter createSimpleFormatter = createSimpleFormatter();
        reportError("Log record " + logRecord.getSequenceNumber() + " was filtered from all message parts.  " + head(createSimpleFormatter) + format(createSimpleFormatter, logRecord) + tail(createSimpleFormatter, ""), new IllegalArgumentException(getFilter() + ", " + Arrays.asList(readOnlyAttachmentFilters())), 5);
    }

    private void reportNonSymmetric(Object obj, Object obj2) {
        reportError("Non symmetric equals implementation.", new IllegalArgumentException(obj.getClass().getName() + " is not equal to " + obj2.getClass().getName()), 4);
    }

    private void reportNonDiscriminating(Object obj, Object obj2) {
        reportError("Non discriminating equals implementation.", new IllegalArgumentException(obj.getClass().getName() + " should not be equal to " + obj2.getClass().getName()), 4);
    }

    private void reportNullError(int i) {
        reportError("null", new NullPointerException(), i);
    }

    private String head(Formatter formatter) {
        try {
            return formatter.getHead(this);
        } catch (RuntimeException e) {
            reportError(e.getMessage(), e, 5);
            return "";
        }
    }

    private String format(Formatter formatter, LogRecord logRecord) {
        try {
            return formatter.format(logRecord);
        } catch (RuntimeException e) {
            reportError(e.getMessage(), e, 5);
            return "";
        }
    }

    private String tail(Formatter formatter, String str) {
        try {
            return formatter.getTail(this);
        } catch (RuntimeException e) {
            reportError(e.getMessage(), e, 5);
            return str;
        }
    }

    private void setMailer(Message message) {
        String replaceAll;
        String fold;
        try {
            Class<?> cls = getClass();
            if (cls == MailHandler.class) {
                fold = MailHandler.class.getName();
            } else {
                try {
                    replaceAll = MimeUtility.encodeText(cls.getName());
                } catch (UnsupportedEncodingException e) {
                    reportError(e.getMessage(), e, 5);
                    replaceAll = cls.getName().replaceAll("[^\\x00-\\x7F]", "\u001a");
                }
                fold = MimeUtility.fold(10, MailHandler.class.getName() + " using the " + replaceAll + " extension.");
            }
            message.setHeader("X-Mailer", fold);
        } catch (MessagingException e2) {
            reportError(e2.getMessage(), e2, 5);
        }
    }

    private void setPriority(Message message) {
        try {
            message.setHeader("Importance", "High");
            message.setHeader("Priority", "urgent");
            message.setHeader("X-Priority", ExifInterface.GPS_MEASUREMENT_2D);
        } catch (MessagingException e) {
            reportError(e.getMessage(), e, 5);
        }
    }

    private void setIncompleteCopy(Message message) {
        try {
            message.setHeader("Incomplete-Copy", "");
        } catch (MessagingException e) {
            reportError(e.getMessage(), e, 5);
        }
    }

    private void setAutoSubmitted(Message message) {
        if (allowRestrictedHeaders()) {
            try {
                message.setHeader("auto-submitted", "auto-generated");
            } catch (MessagingException e) {
                reportError(e.getMessage(), e, 5);
            }
        }
    }

    private void setFrom(Message message) {
        String property = getSession(message).getProperty("mail.from");
        if (property != null) {
            try {
                InternetAddress[] parse = InternetAddress.parse(property, false);
                if (parse.length > 0) {
                    if (parse.length == 1) {
                        message.setFrom(parse[0]);
                    } else {
                        message.addFrom(parse);
                    }
                }
                return;
            } catch (MessagingException e) {
                reportError(e.getMessage(), e, 5);
                setDefaultFrom(message);
                return;
            }
        }
        setDefaultFrom(message);
    }

    private void setDefaultFrom(Message message) {
        try {
            message.setFrom();
        } catch (MessagingException e) {
            reportError(e.getMessage(), e, 5);
        }
    }

    private void setDefaultRecipient(Message message, Message.RecipientType recipientType) {
        try {
            InternetAddress localAddress = InternetAddress.getLocalAddress(getSession(message));
            if (localAddress != null) {
                message.setRecipient(recipientType, localAddress);
                return;
            }
            MimeMessage mimeMessage = new MimeMessage(getSession(message));
            mimeMessage.setFrom();
            Address[] from = mimeMessage.getFrom();
            if (from.length > 0) {
                message.setRecipients(recipientType, from);
                return;
            }
            throw new MessagingException("No local address.");
        } catch (RuntimeException | MessagingException e) {
            reportError("Unable to compute a default recipient.", e, 5);
        }
    }

    private void setReplyTo(Message message) {
        String property = getSession(message).getProperty("mail.reply.to");
        if (isEmpty(property)) {
            return;
        }
        try {
            InternetAddress[] parse = InternetAddress.parse(property, false);
            if (parse.length > 0) {
                message.setReplyTo(parse);
            }
        } catch (MessagingException e) {
            reportError(e.getMessage(), e, 5);
        }
    }

    private void setSender(Message message) {
        String property = getSession(message).getProperty("mail.sender");
        if (isEmpty(property)) {
            return;
        }
        try {
            Address[] parse = InternetAddress.parse(property, false);
            if (parse.length > 0) {
                ((MimeMessage) message).setSender(parse[0]);
                if (parse.length > 1) {
                    reportError("Ignoring other senders.", tooManyAddresses(parse, 1), 5);
                }
            }
        } catch (MessagingException e) {
            reportError(e.getMessage(), e, 5);
        }
    }

    private AddressException tooManyAddresses(Address[] addressArr, int i) {
        return new AddressException(Arrays.asList(addressArr).subList(i, addressArr.length).toString());
    }

    private boolean setRecipient(Message message, String str, Message.RecipientType recipientType) {
        String property = getSession(message).getProperty(str);
        boolean z = property != null;
        if (!isEmpty(property)) {
            try {
                InternetAddress[] parse = InternetAddress.parse(property, false);
                if (parse.length > 0) {
                    message.setRecipients(recipientType, parse);
                }
            } catch (MessagingException e) {
                reportError(e.getMessage(), e, 5);
            }
        }
        return z;
    }

    private String toRawString(Message message) throws MessagingException, IOException {
        if (message != null) {
            Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(message.getSize() + 1024, 1024));
                message.writeTo(byteArrayOutputStream);
                return byteArrayOutputStream.toString("UTF-8");
            } finally {
                getAndSetContextClassLoader(andSetContextClassLoader);
            }
        }
        return null;
    }

    private String toMsgString(Throwable th) {
        if (th == null) {
            return "null";
        }
        String encodingName = getEncodingName();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, encodingName);
            try {
                PrintWriter printWriter = new PrintWriter(outputStreamWriter);
                printWriter.println(th.getMessage());
                th.printStackTrace(printWriter);
                printWriter.flush();
                printWriter.close();
                outputStreamWriter.close();
                return byteArrayOutputStream.toString(encodingName);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    try {
                        outputStreamWriter.close();
                    } catch (Throwable th4) {
                        th2.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
        } catch (RuntimeException e) {
            return th.toString() + ' ' + e.toString();
        } catch (Exception e2) {
            return th.toString() + ' ' + e2.toString();
        }
    }

    private Object getAndSetContextClassLoader(Object obj) {
        PrivilegedAction getAndSetContext;
        if (obj != GetAndSetContext.NOT_MODIFIED) {
            try {
                if (obj instanceof PrivilegedAction) {
                    getAndSetContext = (PrivilegedAction) obj;
                } else {
                    getAndSetContext = new GetAndSetContext(obj);
                }
                return AccessController.doPrivileged(getAndSetContext);
            } catch (SecurityException unused) {
            }
        }
        return GetAndSetContext.NOT_MODIFIED;
    }

    private static RuntimeException attachmentMismatch(String str) {
        return new IndexOutOfBoundsException(str);
    }

    private static RuntimeException attachmentMismatch(int i, int i2) {
        return attachmentMismatch("Attachments mismatched, expected " + i + " but given " + i2 + '.');
    }

    private static MessagingException attach(MessagingException messagingException, Exception exc) {
        if (exc != null && !messagingException.setNextException(exc)) {
            if (exc instanceof MessagingException) {
                MessagingException messagingException2 = (MessagingException) exc;
                if (messagingException2.setNextException(messagingException)) {
                    return messagingException2;
                }
            }
            if (exc != messagingException) {
                messagingException.addSuppressed(exc);
            }
        }
        return messagingException;
    }

    private String getLocalHost(Service service) {
        try {
            return LogManagerProperties.getLocalHost(service);
        } catch (Exception e) {
            reportError(service.toString(), e, 4);
            return null;
        } catch (LinkageError | NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    private Session getSession(Message message) {
        if (message == null) {
            throw null;
        }
        return new MessageContext(message).getSession();
    }

    private boolean allowRestrictedHeaders() {
        return LogManagerProperties.hasLogManager();
    }

    private static String atIndexMsg(int i) {
        return "At index: " + i + '.';
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class DefaultAuthenticator extends Authenticator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String pass;

        static Authenticator of(String str) {
            return new DefaultAuthenticator(str);
        }

        private DefaultAuthenticator(String str) {
            this.pass = str;
        }

        @Override // javax.mail.Authenticator
        protected final PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(getDefaultUserName(), this.pass);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class GetAndSetContext implements PrivilegedAction<Object> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final Object NOT_MODIFIED = GetAndSetContext.class;
        private final Object source;

        GetAndSetContext(Object obj) {
            this.source = obj;
        }

        @Override // java.security.PrivilegedAction
        public final Object run() {
            ClassLoader classLoader;
            Thread currentThread = Thread.currentThread();
            ClassLoader contextClassLoader = currentThread.getContextClassLoader();
            Object obj = this.source;
            if (obj == null) {
                classLoader = null;
            } else if (obj instanceof ClassLoader) {
                classLoader = (ClassLoader) obj;
            } else if (obj instanceof Class) {
                classLoader = ((Class) obj).getClassLoader();
            } else if (obj instanceof Thread) {
                classLoader = ((Thread) obj).getContextClassLoader();
            } else {
                classLoader = obj.getClass().getClassLoader();
            }
            if (contextClassLoader != classLoader) {
                currentThread.setContextClassLoader(classLoader);
                return contextClassLoader;
            }
            return NOT_MODIFIED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class TailNameFormatter extends Formatter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String name;

        @Override // java.util.logging.Formatter
        public final String format(LogRecord logRecord) {
            return "";
        }

        static Formatter of(String str) {
            return new TailNameFormatter(str);
        }

        private TailNameFormatter(String str) {
            this.name = str;
        }

        @Override // java.util.logging.Formatter
        public final String getTail(Handler handler) {
            return this.name;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof TailNameFormatter) {
                return this.name.equals(((TailNameFormatter) obj).name);
            }
            return false;
        }

        public final int hashCode() {
            return getClass().hashCode() + this.name.hashCode();
        }

        public final String toString() {
            return this.name;
        }
    }
}
