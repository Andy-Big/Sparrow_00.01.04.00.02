package com.sun.mail.util.logging;

import java.util.Collections;
import java.util.Date;
import java.util.Formattable;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import javax.mail.UIDFolder;
/* loaded from: classes2.dex */
public class CompactFormatter extends Formatter {
    private final String fmt;

    static {
        loadDeclaredClasses();
    }

    private static Class<?>[] loadDeclaredClasses() {
        return new Class[]{Alternate.class};
    }

    public CompactFormatter() {
        this.fmt = initFormat(getClass().getName());
    }

    public CompactFormatter(String str) {
        this.fmt = str == null ? initFormat(getClass().getName()) : str;
    }

    @Override // java.util.logging.Formatter
    public String format(LogRecord logRecord) {
        ResourceBundle resourceBundle = logRecord.getResourceBundle();
        Locale locale = resourceBundle == null ? null : resourceBundle.getLocale();
        String formatMessage = formatMessage(logRecord);
        String formatThrown = formatThrown(logRecord);
        String formatError = formatError(logRecord);
        Object[] objArr = {formatZonedDateTime(logRecord), formatSource(logRecord), formatLoggerName(logRecord), formatLevel(logRecord), formatMessage, formatThrown, new Alternate(formatMessage, formatThrown), new Alternate(formatThrown, formatMessage), Long.valueOf(logRecord.getSequenceNumber()), formatThreadID(logRecord), formatError, new Alternate(formatMessage, formatError), new Alternate(formatError, formatMessage), formatBackTrace(logRecord), logRecord.getResourceBundleName(), logRecord.getMessage()};
        if (locale == null) {
            return String.format(this.fmt, objArr);
        }
        return String.format(locale, this.fmt, objArr);
    }

    @Override // java.util.logging.Formatter
    public String formatMessage(LogRecord logRecord) {
        return replaceClassName(replaceClassName(super.formatMessage(logRecord), logRecord.getThrown()), logRecord.getParameters());
    }

    public String formatMessage(Throwable th) {
        String replaceClassName;
        if (th != null) {
            Throwable apply = apply(th);
            String localizedMessage = apply.getLocalizedMessage();
            String th2 = apply.toString();
            String simpleClassName = simpleClassName(apply.getClass());
            if (!isNullOrSpaces(localizedMessage)) {
                if (th2.contains(localizedMessage)) {
                    if (th2.startsWith(apply.getClass().getName()) || th2.startsWith(simpleClassName)) {
                        replaceClassName = replaceClassName(localizedMessage, th);
                    } else {
                        replaceClassName = replaceClassName(simpleClassName(th2), th);
                    }
                } else {
                    replaceClassName = replaceClassName(simpleClassName(th2) + ": " + localizedMessage, th);
                }
            } else {
                replaceClassName = replaceClassName(simpleClassName(th2), th);
            }
            if (replaceClassName.contains(simpleClassName)) {
                return replaceClassName;
            }
            return simpleClassName + ": " + replaceClassName;
        }
        return "";
    }

    public String formatLevel(LogRecord logRecord) {
        return logRecord.getLevel().getLocalizedName();
    }

    public String formatSource(LogRecord logRecord) {
        String sourceClassName = logRecord.getSourceClassName();
        if (sourceClassName != null) {
            if (logRecord.getSourceMethodName() != null) {
                return simpleClassName(sourceClassName) + " " + logRecord.getSourceMethodName();
            }
            return simpleClassName(sourceClassName);
        }
        return simpleClassName(logRecord.getLoggerName());
    }

    public String formatLoggerName(LogRecord logRecord) {
        return simpleClassName(logRecord.getLoggerName());
    }

    public Number formatThreadID(LogRecord logRecord) {
        return Long.valueOf(logRecord.getThreadID() & UIDFolder.MAXUID);
    }

    public String formatThrown(LogRecord logRecord) {
        Throwable thrown = logRecord.getThrown();
        String str = "";
        if (thrown != null) {
            String formatBackTrace = formatBackTrace(logRecord);
            StringBuilder sb = new StringBuilder();
            sb.append(formatMessage(thrown));
            if (!isNullOrSpaces(formatBackTrace)) {
                str = ' ' + formatBackTrace;
            }
            sb.append(str);
            return sb.toString();
        }
        return "";
    }

    public String formatError(LogRecord logRecord) {
        return formatMessage(logRecord.getThrown());
    }

    public String formatBackTrace(LogRecord logRecord) {
        Throwable thrown = logRecord.getThrown();
        if (thrown != null) {
            StackTraceElement[] stackTrace = apply(thrown).getStackTrace();
            String findAndFormat = findAndFormat(stackTrace);
            if (isNullOrSpaces(findAndFormat)) {
                int i = 0;
                while (thrown != null) {
                    StackTraceElement[] stackTrace2 = thrown.getStackTrace();
                    String findAndFormat2 = findAndFormat(stackTrace2);
                    if (isNullOrSpaces(findAndFormat2)) {
                        if (stackTrace.length == 0) {
                            stackTrace = stackTrace2;
                        }
                        i++;
                        if (i != 65536) {
                            thrown = thrown.getCause();
                            findAndFormat = findAndFormat2;
                        }
                    }
                    findAndFormat = findAndFormat2;
                    break;
                }
                return (!isNullOrSpaces(findAndFormat) || stackTrace.length == 0) ? findAndFormat : formatStackTraceElement(stackTrace[0]);
            }
            return findAndFormat;
        }
        return "";
    }

    private String findAndFormat(StackTraceElement[] stackTraceElementArr) {
        String str;
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = "";
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            if (!ignore(stackTraceElement)) {
                str = formatStackTraceElement(stackTraceElement);
                break;
            }
            i++;
        }
        if (isNullOrSpaces(str)) {
            for (StackTraceElement stackTraceElement2 : stackTraceElementArr) {
                if (!defaultIgnore(stackTraceElement2)) {
                    return formatStackTraceElement(stackTraceElement2);
                }
            }
            return str;
        }
        return str;
    }

    private String formatStackTraceElement(StackTraceElement stackTraceElement) {
        String stackTraceElement2;
        String simpleClassName = simpleClassName(stackTraceElement.getClassName());
        if (simpleClassName != null) {
            stackTraceElement2 = stackTraceElement.toString().replace(stackTraceElement.getClassName(), simpleClassName);
        } else {
            stackTraceElement2 = stackTraceElement.toString();
        }
        String simpleFileName = simpleFileName(stackTraceElement.getFileName());
        return (simpleFileName == null || !stackTraceElement2.startsWith(simpleFileName)) ? stackTraceElement2 : stackTraceElement2.replace(stackTraceElement.getFileName(), "");
    }

    protected Throwable apply(Throwable th) {
        return SeverityComparator.getInstance().apply(th);
    }

    protected boolean ignore(StackTraceElement stackTraceElement) {
        return isUnknown(stackTraceElement) || defaultIgnore(stackTraceElement);
    }

    protected String toAlternate(String str) {
        if (str != null) {
            return str.replaceAll("[\\x00-\\x1F\\x7F]+", "");
        }
        return null;
    }

    private Comparable<?> formatZonedDateTime(LogRecord logRecord) {
        Comparable<?> zonedDateTime = LogManagerProperties.getZonedDateTime(logRecord);
        return zonedDateTime == null ? new Date(logRecord.getMillis()) : zonedDateTime;
    }

    private boolean defaultIgnore(StackTraceElement stackTraceElement) {
        return isSynthetic(stackTraceElement) || isStaticUtility(stackTraceElement) || isReflection(stackTraceElement);
    }

    private boolean isStaticUtility(StackTraceElement stackTraceElement) {
        try {
            return LogManagerProperties.isStaticUtilityClass(stackTraceElement.getClassName());
        } catch (RuntimeException | Exception | LinkageError unused) {
            String className = stackTraceElement.getClassName();
            return (className.endsWith("s") && !className.endsWith("es")) || className.contains("Util") || className.endsWith("Throwables");
        }
    }

    private boolean isSynthetic(StackTraceElement stackTraceElement) {
        return stackTraceElement.getMethodName().indexOf(36) > -1;
    }

    private boolean isUnknown(StackTraceElement stackTraceElement) {
        return stackTraceElement.getLineNumber() < 0;
    }

    private boolean isReflection(StackTraceElement stackTraceElement) {
        try {
            return LogManagerProperties.isReflectionClass(stackTraceElement.getClassName());
        } catch (RuntimeException | Exception | LinkageError unused) {
            return stackTraceElement.getClassName().startsWith("java.lang.reflect.") || stackTraceElement.getClassName().startsWith("sun.reflect.");
        }
    }

    private String initFormat(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".format"));
        return isNullOrSpaces(fromLogManager) ? "%7$#.160s%n" : fromLogManager;
    }

    private static String replaceClassName(String str, Throwable th) {
        if (!isNullOrSpaces(str)) {
            int i = 0;
            while (th != null) {
                Class<?> cls = th.getClass();
                str = str.replace(cls.getName(), simpleClassName(cls));
                i++;
                if (i == 65536) {
                    break;
                }
                th = th.getCause();
            }
        }
        return str;
    }

    private static String replaceClassName(String str, Object[] objArr) {
        if (!isNullOrSpaces(str) && objArr != null) {
            for (Object obj : objArr) {
                if (obj != null) {
                    Class<?> cls = obj.getClass();
                    str = str.replace(cls.getName(), simpleClassName(cls));
                }
            }
        }
        return str;
    }

    private static String simpleClassName(Class<?> cls) {
        try {
            return cls.getSimpleName();
        } catch (InternalError unused) {
            return simpleClassName(cls.getName());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
        if (r2 <= (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
        if (r2 >= r0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
        if (r4 >= r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
        if (r4 <= r2) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0042, code lost:
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
        return r7.substring(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String simpleClassName(java.lang.String r7) {
        /*
            if (r7 == 0) goto L47
            r0 = 0
            r1 = -1
            r2 = r1
            r3 = r2
            r4 = r3
        L7:
            int r5 = r7.length()
            if (r0 >= r5) goto L36
            int r5 = r7.codePointAt(r0)
            boolean r6 = java.lang.Character.isJavaIdentifierPart(r5)
            if (r6 != 0) goto L2b
            r6 = 46
            if (r5 != r6) goto L25
            int r3 = r2 + 1
            if (r3 == r0) goto L24
            if (r3 == r4) goto L24
            r3 = r2
            r2 = r0
            goto L30
        L24:
            return r7
        L25:
            int r5 = r2 + 1
            if (r5 != r0) goto L36
            r2 = r3
            goto L36
        L2b:
            r6 = 36
            if (r5 != r6) goto L30
            r4 = r0
        L30:
            int r5 = java.lang.Character.charCount(r5)
            int r0 = r0 + r5
            goto L7
        L36:
            if (r2 <= r1) goto L47
            int r2 = r2 + 1
            if (r2 >= r0) goto L47
            int r4 = r4 + 1
            if (r4 >= r0) goto L47
            if (r4 <= r2) goto L43
            r2 = r4
        L43:
            java.lang.String r7 = r7.substring(r2)
        L47:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.CompactFormatter.simpleClassName(java.lang.String):java.lang.String");
    }

    private static String simpleFileName(String str) {
        int lastIndexOf;
        return (str == null || (lastIndexOf = str.lastIndexOf(46)) <= -1) ? str : str.substring(0, lastIndexOf);
    }

    private static boolean isNullOrSpaces(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Alternate implements Formattable {
        private final String left;
        private final String right;

        Alternate(String str, String str2) {
            this.left = String.valueOf(str);
            this.right = String.valueOf(str2);
        }

        @Override // java.util.Formattable
        public void formatTo(java.util.Formatter formatter, int i, int i2, int i3) {
            String str = this.left;
            String str2 = this.right;
            if ((i & 2) == 2) {
                str = str.toUpperCase(formatter.locale());
                str2 = str2.toUpperCase(formatter.locale());
            }
            if ((i & 4) == 4) {
                str = CompactFormatter.this.toAlternate(str);
                str2 = CompactFormatter.this.toAlternate(str2);
            }
            if (i3 <= 0) {
                i3 = Integer.MAX_VALUE;
            }
            int min = Math.min(str.length(), i3);
            if (min > (i3 >> 1)) {
                min = Math.max(min - str2.length(), min >> 1);
            }
            if (min > 0) {
                if (min > str.length() && Character.isHighSurrogate(str.charAt(min - 1))) {
                    min--;
                }
                str = str.substring(0, min);
            }
            String substring = str2.substring(0, Math.min(i3 - min, str2.length()));
            if (i2 > 0) {
                int i4 = i2 >> 1;
                if (str.length() < i4) {
                    str = pad(i, str, i4);
                }
                if (substring.length() < i4) {
                    substring = pad(i, substring, i4);
                }
            }
            Object[] array = Collections.emptySet().toArray();
            formatter.format(str, array);
            if (str.length() != 0 && substring.length() != 0) {
                formatter.format("|", array);
            }
            formatter.format(substring, array);
        }

        private String pad(int i, String str, int i2) {
            int length = i2 - str.length();
            StringBuilder sb = new StringBuilder(i2);
            int i3 = 0;
            if ((i & 1) == 1) {
                while (i3 < length) {
                    sb.append(' ');
                    i3++;
                }
                sb.append(str);
            } else {
                sb.append(str);
                while (i3 < length) {
                    sb.append(' ');
                    i3++;
                }
            }
            return sb.toString();
        }
    }
}
