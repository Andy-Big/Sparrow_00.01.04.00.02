package javax.mail.internet;

import com.rigol.util.PackageUtilKt;
import com.sun.mail.util.MailLogger;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
/* loaded from: classes2.dex */
public class MailDateFormat extends SimpleDateFormat {
    private static final int LEAP_SECOND = 60;
    private static final String PATTERN = "EEE, d MMM yyyy HH:mm:ss Z (z)";
    private static final int UNKNOWN_DAY_NAME = -1;
    private static final long serialVersionUID = -8148227605210628779L;
    private static final MailLogger LOGGER = new MailLogger((Class<?>) MailDateFormat.class, "DEBUG", false, System.out);
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");

    public MailDateFormat() {
        super(PATTERN, Locale.US);
    }

    private Object writeReplace() throws ObjectStreamException {
        MailDateFormat mailDateFormat = new MailDateFormat();
        mailDateFormat.superApplyPattern("EEE, d MMM yyyy HH:mm:ss 'XXXXX' (z)");
        mailDateFormat.setTimeZone(getTimeZone());
        return mailDateFormat;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        super.applyPattern(PATTERN);
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat, java.text.Format
    public MailDateFormat clone() {
        return (MailDateFormat) super.clone();
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return super.format(date, stringBuffer, fieldPosition);
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        if (str == null || parsePosition == null) {
            throw null;
        }
        if (parsePosition.getIndex() < 0 || parsePosition.getIndex() >= str.length()) {
            return null;
        }
        if (isLenient()) {
            return new Rfc2822LenientParser(str, parsePosition).parse();
        }
        return new Rfc2822StrictParser(str, parsePosition).parse();
    }

    @Override // java.text.DateFormat
    public void setCalendar(Calendar calendar) {
        throw new UnsupportedOperationException("Method setCalendar() shouldn't be called");
    }

    @Override // java.text.DateFormat
    public void setNumberFormat(NumberFormat numberFormat) {
        throw new UnsupportedOperationException("Method setNumberFormat() shouldn't be called");
    }

    @Override // java.text.SimpleDateFormat
    public void applyLocalizedPattern(String str) {
        throw new UnsupportedOperationException("Method applyLocalizedPattern() shouldn't be called");
    }

    @Override // java.text.SimpleDateFormat
    public void applyPattern(String str) {
        throw new UnsupportedOperationException("Method applyPattern() shouldn't be called");
    }

    private void superApplyPattern(String str) {
        super.applyPattern(str);
    }

    @Override // java.text.SimpleDateFormat
    public Date get2DigitYearStart() {
        throw new UnsupportedOperationException("Method get2DigitYearStart() shouldn't be called");
    }

    @Override // java.text.SimpleDateFormat
    public void set2DigitYearStart(Date date) {
        throw new UnsupportedOperationException("Method set2DigitYearStart() shouldn't be called");
    }

    @Override // java.text.SimpleDateFormat
    public void setDateFormatSymbols(DateFormatSymbols dateFormatSymbols) {
        throw new UnsupportedOperationException("Method setDateFormatSymbols() shouldn't be called");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Date toDate(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i7 == 60) {
            i7 = 59;
        }
        int i9 = i7;
        TimeZone timeZone = this.calendar.getTimeZone();
        try {
            this.calendar.setTimeZone(UTC);
            this.calendar.clear();
            this.calendar.set(i4, i3, i2, i5, i6, i9);
            if (i != -1 && i != this.calendar.get(7)) {
                throw new IllegalArgumentException("Inconsistent day-name");
            }
            this.calendar.add(12, i8);
            return this.calendar.getTime();
        } finally {
            this.calendar.setTimeZone(timeZone);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class AbstractDateParser {
        static final int INVALID_CHAR = -1;
        static final int MAX_YEAR_DIGITS = 8;
        final ParsePosition pos;
        final String text;

        abstract Date tryParse() throws java.text.ParseException;

        AbstractDateParser(String str, ParsePosition parsePosition) {
            this.text = str;
            this.pos = parsePosition;
        }

        final Date parse() {
            int index = this.pos.getIndex();
            try {
                return tryParse();
            } catch (Exception e) {
                if (MailDateFormat.LOGGER.isLoggable(Level.FINE)) {
                    MailLogger mailLogger = MailDateFormat.LOGGER;
                    Level level = Level.FINE;
                    mailLogger.log(level, "Bad date: '" + this.text + "'", (Throwable) e);
                }
                ParsePosition parsePosition = this.pos;
                parsePosition.setErrorIndex(parsePosition.getIndex());
                this.pos.setIndex(index);
                return null;
            }
        }

        final int parseDayName() throws java.text.ParseException {
            int i = getChar();
            if (i == -1) {
                throw new java.text.ParseException("Invalid day-name", this.pos.getIndex());
            }
            if (i != 70) {
                if (i != 77) {
                    if (i != 87) {
                        if (i != 83) {
                            if (i == 84) {
                                if (skipPair('u', 'e')) {
                                    return 3;
                                }
                                if (skipPair('h', 'u')) {
                                    return 5;
                                }
                            }
                        } else if (skipPair('u', 'n')) {
                            return 1;
                        } else {
                            if (skipPair('a', 't')) {
                                return 7;
                            }
                        }
                    } else if (skipPair('e', 'd')) {
                        return 4;
                    }
                } else if (skipPair('o', 'n')) {
                    return 2;
                }
            } else if (skipPair('r', 'i')) {
                return 6;
            }
            ParsePosition parsePosition = this.pos;
            parsePosition.setIndex(parsePosition.getIndex() - 1);
            throw new java.text.ParseException("Invalid day-name", this.pos.getIndex());
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
            if (r17 == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
            if (r17 == false) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
            if (r17 == false) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
            if (r17 == false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
            if (r17 == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0026, code lost:
            if (r17 == false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
            if (r17 == false) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
            if (r17 == false) goto L26;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final int parseMonthName(boolean r17) throws java.text.ParseException {
            /*
                Method dump skipped, instructions count: 454
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateFormat.AbstractDateParser.parseMonthName(boolean):int");
        }

        final int parseZoneOffset() throws java.text.ParseException {
            int i = getChar();
            if (i == 43 || i == 45) {
                int parseAsciiDigits = parseAsciiDigits(4, 4, true);
                if (!isValidZoneOffset(parseAsciiDigits)) {
                    ParsePosition parsePosition = this.pos;
                    parsePosition.setIndex(parsePosition.getIndex() - 5);
                    throw new java.text.ParseException("Invalid zone", this.pos.getIndex());
                }
                return (i != 43 ? 1 : -1) * (((parseAsciiDigits / 100) * 60) + (parseAsciiDigits % 100));
            }
            if (i != -1) {
                ParsePosition parsePosition2 = this.pos;
                parsePosition2.setIndex(parsePosition2.getIndex() - 1);
            }
            throw new java.text.ParseException("Invalid zone", this.pos.getIndex());
        }

        boolean isValidZoneOffset(int i) {
            return i % 100 < 60;
        }

        final int parseAsciiDigits(int i) throws java.text.ParseException {
            return parseAsciiDigits(i, i);
        }

        final int parseAsciiDigits(int i, int i2) throws java.text.ParseException {
            return parseAsciiDigits(i, i2, false);
        }

        final int parseAsciiDigits(int i, int i2, boolean z) throws java.text.ParseException {
            String str;
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && peekAsciiDigit()) {
                i4 = (i4 * 10) + getAsciiDigit();
                i3++;
            }
            if (i3 < i || (i3 == i2 && !z && peekAsciiDigit())) {
                ParsePosition parsePosition = this.pos;
                parsePosition.setIndex(parsePosition.getIndex() - i3);
                if (i == i2) {
                    str = Integer.toString(i);
                } else {
                    str = "between " + i + " and " + i2;
                }
                throw new java.text.ParseException("Invalid input: expected " + str + " ASCII digits", this.pos.getIndex());
            }
            return i4;
        }

        final void parseFoldingWhiteSpace() throws java.text.ParseException {
            if (!skipFoldingWhiteSpace()) {
                throw new java.text.ParseException("Invalid input: expected FWS", this.pos.getIndex());
            }
        }

        final void parseChar(char c) throws java.text.ParseException {
            if (skipChar(c)) {
                return;
            }
            throw new java.text.ParseException("Invalid input: expected '" + c + "'", this.pos.getIndex());
        }

        final int getAsciiDigit() {
            int i = getChar();
            if (48 > i || i > 57) {
                if (i != -1) {
                    ParsePosition parsePosition = this.pos;
                    parsePosition.setIndex(parsePosition.getIndex() - 1);
                }
                return -1;
            }
            return Character.digit((char) i, 10);
        }

        final int getChar() {
            if (this.pos.getIndex() < this.text.length()) {
                char charAt = this.text.charAt(this.pos.getIndex());
                ParsePosition parsePosition = this.pos;
                parsePosition.setIndex(parsePosition.getIndex() + 1);
                return charAt;
            }
            return -1;
        }

        boolean skipFoldingWhiteSpace() {
            if (skipChar(' ')) {
                if (!peekFoldingWhiteSpace()) {
                    return true;
                }
                ParsePosition parsePosition = this.pos;
                parsePosition.setIndex(parsePosition.getIndex() - 1);
            } else if (!peekFoldingWhiteSpace()) {
                return false;
            }
            int index = this.pos.getIndex();
            if (skipWhiteSpace()) {
                while (skipNewline()) {
                    if (!skipWhiteSpace()) {
                        this.pos.setIndex(index);
                        return false;
                    }
                }
                return true;
            } else if (skipNewline() && skipWhiteSpace()) {
                return true;
            } else {
                this.pos.setIndex(index);
                return false;
            }
        }

        final boolean skipWhiteSpace() {
            int index = this.pos.getIndex();
            do {
            } while (skipAlternative(' ', '\t'));
            return this.pos.getIndex() > index;
        }

        final boolean skipNewline() {
            return skipPair('\r', '\n');
        }

        final boolean skipAlternativeTriple(char c, char c2, char c3, char c4, char c5, char c6) {
            if (skipAlternativePair(c, c2, c3, c4)) {
                if (skipAlternative(c5, c6)) {
                    return true;
                }
                ParsePosition parsePosition = this.pos;
                parsePosition.setIndex(parsePosition.getIndex() - 2);
                return false;
            }
            return false;
        }

        final boolean skipAlternativePair(char c, char c2, char c3, char c4) {
            if (skipAlternative(c, c2)) {
                if (skipAlternative(c3, c4)) {
                    return true;
                }
                ParsePosition parsePosition = this.pos;
                parsePosition.setIndex(parsePosition.getIndex() - 1);
                return false;
            }
            return false;
        }

        final boolean skipAlternative(char c, char c2) {
            return skipChar(c) || skipChar(c2);
        }

        final boolean skipPair(char c, char c2) {
            if (skipChar(c)) {
                if (skipChar(c2)) {
                    return true;
                }
                ParsePosition parsePosition = this.pos;
                parsePosition.setIndex(parsePosition.getIndex() - 1);
                return false;
            }
            return false;
        }

        final boolean skipChar(char c) {
            if (this.pos.getIndex() >= this.text.length() || this.text.charAt(this.pos.getIndex()) != c) {
                return false;
            }
            ParsePosition parsePosition = this.pos;
            parsePosition.setIndex(parsePosition.getIndex() + 1);
            return true;
        }

        final boolean peekAsciiDigit() {
            return this.pos.getIndex() < this.text.length() && '0' <= this.text.charAt(this.pos.getIndex()) && this.text.charAt(this.pos.getIndex()) <= '9';
        }

        boolean peekFoldingWhiteSpace() {
            return this.pos.getIndex() < this.text.length() && (this.text.charAt(this.pos.getIndex()) == ' ' || this.text.charAt(this.pos.getIndex()) == '\t' || this.text.charAt(this.pos.getIndex()) == '\r');
        }

        final boolean peekChar(char c) {
            return this.pos.getIndex() < this.text.length() && this.text.charAt(this.pos.getIndex()) == c;
        }
    }

    /* loaded from: classes2.dex */
    private class Rfc2822StrictParser extends AbstractDateParser {
        boolean isMonthNameCaseSensitive() {
            return true;
        }

        Rfc2822StrictParser(String str, ParsePosition parsePosition) {
            super(str, parsePosition);
        }

        @Override // javax.mail.internet.MailDateFormat.AbstractDateParser
        Date tryParse() throws java.text.ParseException {
            int parseOptionalBegin = parseOptionalBegin();
            int parseDay = parseDay();
            int parseMonth = parseMonth();
            int parseYear = parseYear();
            parseFoldingWhiteSpace();
            int parseHour = parseHour();
            parseChar(':');
            int parseMinute = parseMinute();
            int parseSecond = skipChar(':') ? parseSecond() : 0;
            parseFwsBetweenTimeOfDayAndZone();
            try {
                return MailDateFormat.this.toDate(parseOptionalBegin, parseDay, parseMonth, parseYear, parseHour, parseMinute, parseSecond, parseZone());
            } catch (IllegalArgumentException unused) {
                throw new java.text.ParseException("Invalid input: some of the calendar fields have invalid values, or day-name is inconsistent with date", this.pos.getIndex());
            }
        }

        int parseOptionalBegin() throws java.text.ParseException {
            if (peekAsciiDigit()) {
                return -1;
            }
            skipFoldingWhiteSpace();
            int parseDayName = parseDayName();
            parseChar(',');
            return parseDayName;
        }

        int parseDay() throws java.text.ParseException {
            skipFoldingWhiteSpace();
            return parseAsciiDigits(1, 2);
        }

        int parseMonth() throws java.text.ParseException {
            parseFwsInMonth();
            int parseMonthName = parseMonthName(isMonthNameCaseSensitive());
            parseFwsInMonth();
            return parseMonthName;
        }

        void parseFwsInMonth() throws java.text.ParseException {
            parseFoldingWhiteSpace();
        }

        int parseYear() throws java.text.ParseException {
            int parseAsciiDigits = parseAsciiDigits(4, 8);
            if (parseAsciiDigits >= 1900) {
                return parseAsciiDigits;
            }
            this.pos.setIndex(this.pos.getIndex() - 4);
            while (this.text.charAt(this.pos.getIndex() - 1) == '0') {
                this.pos.setIndex(this.pos.getIndex() - 1);
            }
            throw new java.text.ParseException("Invalid year", this.pos.getIndex());
        }

        int parseHour() throws java.text.ParseException {
            return parseAsciiDigits(2);
        }

        int parseMinute() throws java.text.ParseException {
            return parseAsciiDigits(2);
        }

        int parseSecond() throws java.text.ParseException {
            return parseAsciiDigits(2);
        }

        void parseFwsBetweenTimeOfDayAndZone() throws java.text.ParseException {
            parseFoldingWhiteSpace();
        }

        int parseZone() throws java.text.ParseException {
            return parseZoneOffset();
        }
    }

    /* loaded from: classes2.dex */
    private class Rfc2822LenientParser extends Rfc2822StrictParser {
        private Boolean hasDefaultFws;

        @Override // javax.mail.internet.MailDateFormat.Rfc2822StrictParser
        boolean isMonthNameCaseSensitive() {
            return false;
        }

        @Override // javax.mail.internet.MailDateFormat.AbstractDateParser
        boolean isValidZoneOffset(int i) {
            return true;
        }

        Rfc2822LenientParser(String str, ParsePosition parsePosition) {
            super(str, parsePosition);
        }

        @Override // javax.mail.internet.MailDateFormat.Rfc2822StrictParser
        int parseOptionalBegin() {
            while (this.pos.getIndex() < this.text.length() && !peekAsciiDigit()) {
                this.pos.setIndex(this.pos.getIndex() + 1);
            }
            return -1;
        }

        @Override // javax.mail.internet.MailDateFormat.Rfc2822StrictParser
        int parseDay() throws java.text.ParseException {
            skipFoldingWhiteSpace();
            return parseAsciiDigits(1, 3);
        }

        @Override // javax.mail.internet.MailDateFormat.Rfc2822StrictParser
        void parseFwsInMonth() throws java.text.ParseException {
            Boolean bool = this.hasDefaultFws;
            if (bool == null) {
                this.hasDefaultFws = Boolean.valueOf(!skipChar('-'));
                skipFoldingWhiteSpace();
            } else if (bool.booleanValue()) {
                skipFoldingWhiteSpace();
            } else {
                parseChar('-');
            }
        }

        @Override // javax.mail.internet.MailDateFormat.Rfc2822StrictParser
        int parseYear() throws java.text.ParseException {
            int parseAsciiDigits = parseAsciiDigits(1, 8);
            return parseAsciiDigits >= 1000 ? parseAsciiDigits : parseAsciiDigits >= 50 ? parseAsciiDigits + 1900 : parseAsciiDigits + PackageUtilKt.ERROR_PACKAGE_FILE_DOWNLOAD;
        }

        @Override // javax.mail.internet.MailDateFormat.Rfc2822StrictParser
        int parseHour() throws java.text.ParseException {
            return parseAsciiDigits(1, 2);
        }

        @Override // javax.mail.internet.MailDateFormat.Rfc2822StrictParser
        int parseMinute() throws java.text.ParseException {
            return parseAsciiDigits(1, 2);
        }

        @Override // javax.mail.internet.MailDateFormat.Rfc2822StrictParser
        int parseSecond() throws java.text.ParseException {
            return parseAsciiDigits(1, 2);
        }

        @Override // javax.mail.internet.MailDateFormat.Rfc2822StrictParser
        void parseFwsBetweenTimeOfDayAndZone() throws java.text.ParseException {
            skipFoldingWhiteSpace();
        }

        @Override // javax.mail.internet.MailDateFormat.Rfc2822StrictParser
        int parseZone() throws java.text.ParseException {
            int i;
            try {
                if (this.pos.getIndex() >= this.text.length()) {
                    throw new java.text.ParseException("Missing zone", this.pos.getIndex());
                }
                if (!peekChar('+') && !peekChar('-')) {
                    if (skipAlternativePair('U', 'u', 'T', 't') || skipAlternativeTriple('G', 'g', 'M', 'm', 'T', 't')) {
                        return 0;
                    }
                    if (skipAlternative('E', 'e')) {
                        i = 4;
                    } else if (skipAlternative('C', 'c')) {
                        i = 5;
                    } else if (skipAlternative('M', 'm')) {
                        i = 6;
                    } else if (!skipAlternative('P', 'p')) {
                        throw new java.text.ParseException("Invalid zone", this.pos.getIndex());
                    } else {
                        i = 7;
                    }
                    if (skipAlternativePair('S', 's', 'T', 't')) {
                        i++;
                    } else if (!skipAlternativePair('D', 'd', 'T', 't')) {
                        this.pos.setIndex(this.pos.getIndex() - 1);
                        throw new java.text.ParseException("Invalid zone", this.pos.getIndex());
                    }
                    return i * 60;
                }
                return parseZoneOffset();
            } catch (java.text.ParseException e) {
                if (MailDateFormat.LOGGER.isLoggable(Level.FINE)) {
                    MailLogger mailLogger = MailDateFormat.LOGGER;
                    Level level = Level.FINE;
                    mailLogger.log(level, "No timezone? : '" + this.text + "'", (Throwable) e);
                }
                return 0;
            }
        }

        @Override // javax.mail.internet.MailDateFormat.AbstractDateParser
        boolean skipFoldingWhiteSpace() {
            char charAt;
            boolean peekFoldingWhiteSpace = peekFoldingWhiteSpace();
            while (this.pos.getIndex() < this.text.length() && ((charAt = this.text.charAt(this.pos.getIndex())) == '\t' || charAt == '\n' || charAt == '\r' || charAt == ' ')) {
                this.pos.setIndex(this.pos.getIndex() + 1);
            }
            return peekFoldingWhiteSpace;
        }

        @Override // javax.mail.internet.MailDateFormat.AbstractDateParser
        boolean peekFoldingWhiteSpace() {
            return super.peekFoldingWhiteSpace() || (this.pos.getIndex() < this.text.length() && this.text.charAt(this.pos.getIndex()) == '\n');
        }
    }
}
