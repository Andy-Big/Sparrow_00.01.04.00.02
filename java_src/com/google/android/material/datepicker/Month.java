package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() { // from class: com.google.android.material.datepicker.Month.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Month createFromParcel(Parcel parcel) {
            return Month.create(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Month[] newArray(int i) {
            return new Month[i];
        }
    };
    final int daysInMonth;
    final int daysInWeek;
    private final Calendar firstOfMonth;
    private final String longName;
    final int month;
    final long timeInMillis;
    final int year;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar dayCopy = UtcDates.getDayCopy(calendar);
        this.firstOfMonth = dayCopy;
        this.month = dayCopy.get(2);
        this.year = this.firstOfMonth.get(1);
        this.daysInWeek = this.firstOfMonth.getMaximum(7);
        this.daysInMonth = this.firstOfMonth.getActualMaximum(5);
        this.longName = UtcDates.getYearMonthFormat().format(this.firstOfMonth.getTime());
        this.timeInMillis = this.firstOfMonth.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month create(long j) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return new Month(utcCalendar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month create(int i, int i2) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.set(1, i);
        utcCalendar.set(2, i2);
        return new Month(utcCalendar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month current() {
        return new Month(UtcDates.getTodayCalendar());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int daysFromStartOfWeekToFirstOfMonth() {
        int firstDayOfWeek = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.daysInWeek : firstDayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Month) {
            Month month = (Month) obj;
            return this.month == month.month && this.year == month.year;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    @Override // java.lang.Comparable
    public int compareTo(Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int monthsUntil(Month month) {
        if (this.firstOfMonth instanceof GregorianCalendar) {
            return ((month.year - this.year) * 12) + (month.month - this.month);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getDay(int i) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.set(5, i);
        return dayCopy.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month monthsLater(int i) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.add(2, i);
        return new Month(dayCopy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLongName() {
        return this.longName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }
}
