package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
class UtcDates {
    static final String UTC = "UTC";
    static AtomicReference<TimeSource> timeSourceRef = new AtomicReference<>();

    static void setTimeSource(TimeSource timeSource) {
        timeSourceRef.set(timeSource);
    }

    static TimeSource getTimeSource() {
        TimeSource timeSource = timeSourceRef.get();
        return timeSource == null ? TimeSource.system() : timeSource;
    }

    private UtcDates() {
    }

    private static TimeZone getTimeZone() {
        return TimeZone.getTimeZone(UTC);
    }

    private static android.icu.util.TimeZone getUtcAndroidTimeZone() {
        return android.icu.util.TimeZone.getTimeZone(UTC);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar getTodayCalendar() {
        Calendar now = getTimeSource().now();
        now.set(11, 0);
        now.set(12, 0);
        now.set(13, 0);
        now.set(14, 0);
        now.setTimeZone(getTimeZone());
        return now;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar getUtcCalendar() {
        return getUtcCalendarOf(null);
    }

    static Calendar getUtcCalendarOf(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(getTimeZone());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar getDayCopy(Calendar calendar) {
        Calendar utcCalendarOf = getUtcCalendarOf(calendar);
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.set(utcCalendarOf.get(1), utcCalendarOf.get(2), utcCalendarOf.get(5));
        return utcCalendar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long canonicalYearMonthDay(long j) {
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return getDayCopy(utcCalendar).getTimeInMillis();
    }

    private static DateFormat getAndroidFormat(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(getUtcAndroidTimeZone());
        return instanceForSkeleton;
    }

    private static java.text.DateFormat getFormat(int i, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i, locale);
        dateInstance.setTimeZone(getTimeZone());
        return dateInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SimpleDateFormat getTextInputFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(getTimeZone());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getTextInputHint(Resources resources, SimpleDateFormat simpleDateFormat) {
        String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll("d", resources.getString(R.string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(R.string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(R.string.mtrl_picker_text_input_year_abbr));
    }

    static SimpleDateFormat getSimpleFormat(String str) {
        return getSimpleFormat(str, Locale.getDefault());
    }

    private static SimpleDateFormat getSimpleFormat(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(getTimeZone());
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat getYearAbbrMonthDayFormat(Locale locale) {
        return getAndroidFormat("yMMMd", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat getAbbrMonthDayFormat(Locale locale) {
        return getAndroidFormat("MMMd", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat getAbbrMonthWeekdayDayFormat(Locale locale) {
        return getAndroidFormat("MMMEd", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat getYearAbbrMonthWeekdayDayFormat(Locale locale) {
        return getAndroidFormat("yMMMEd", locale);
    }

    static java.text.DateFormat getMediumFormat() {
        return getMediumFormat(Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat getMediumFormat(Locale locale) {
        return getFormat(2, locale);
    }

    static java.text.DateFormat getMediumNoYear() {
        return getMediumNoYear(Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat getMediumNoYear(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) getMediumFormat(locale);
        simpleDateFormat.applyPattern(removeYearFromDateFormatPattern(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    static java.text.DateFormat getFullFormat() {
        return getFullFormat(Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat getFullFormat(Locale locale) {
        return getFormat(0, locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SimpleDateFormat getYearMonthFormat() {
        return getYearMonthFormat(Locale.getDefault());
    }

    private static SimpleDateFormat getYearMonthFormat(Locale locale) {
        return getSimpleFormat("LLLL, yyyy", locale);
    }

    private static String removeYearFromDateFormatPattern(String str) {
        int findCharactersInDateFormatPattern = findCharactersInDateFormatPattern(str, "yY", 1, 0);
        if (findCharactersInDateFormatPattern >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int findCharactersInDateFormatPattern2 = findCharactersInDateFormatPattern(str, "EMd", 1, findCharactersInDateFormatPattern);
        if (findCharactersInDateFormatPattern2 < str.length()) {
            str2 = "EMd,";
        }
        return str.replace(str.substring(findCharactersInDateFormatPattern(str, str2, -1, findCharactersInDateFormatPattern) + 1, findCharactersInDateFormatPattern2), " ").trim();
    }

    private static int findCharactersInDateFormatPattern(String str, String str2, int i, int i2) {
        while (i2 >= 0 && i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            if (str.charAt(i2) == '\'') {
                do {
                    i2 += i;
                    if (i2 >= 0 && i2 < str.length()) {
                    }
                } while (str.charAt(i2) != '\'');
            }
            i2 += i;
        }
        return i2;
    }
}
