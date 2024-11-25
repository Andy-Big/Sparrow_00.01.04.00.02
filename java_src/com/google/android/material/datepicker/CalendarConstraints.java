package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() { // from class: com.google.android.material.datepicker.CalendarConstraints.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CalendarConstraints[] newArray(int i) {
            return new CalendarConstraints[i];
        }
    };
    private final Month end;
    private final int monthSpan;
    private final Month openAt;
    private final Month start;
    private final DateValidator validator;
    private final int yearSpan;

    /* loaded from: classes.dex */
    public interface DateValidator extends Parcelable {
        boolean isValid(long j);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private CalendarConstraints(Month month, Month month2, Month month3, DateValidator dateValidator) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.monthSpan = month.monthsUntil(month2) + 1;
        this.yearSpan = (month2.year - month.year) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isWithinBounds(long j) {
        if (this.start.getDay(1) <= j) {
            Month month = this.end;
            if (j <= month.getDay(month.daysInMonth)) {
                return true;
            }
        }
        return false;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month getStart() {
        return this.start;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month getEnd() {
        return this.end;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month getOpenAt() {
        return this.openAt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMonthSpan() {
        return this.monthSpan;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getYearSpan() {
        return this.yearSpan;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CalendarConstraints) {
            CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
            return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && this.openAt.equals(calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month clamp(Month month) {
        if (month.compareTo(this.start) < 0) {
            return this.start;
        }
        return month.compareTo(this.end) > 0 ? this.end : month;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        private long end;
        private Long openAt;
        private long start;
        private DateValidator validator;
        static final long DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
        static final long DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);

        public Builder() {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(CalendarConstraints calendarConstraints) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.start = calendarConstraints.start.timeInMillis;
            this.end = calendarConstraints.end.timeInMillis;
            this.openAt = Long.valueOf(calendarConstraints.openAt.timeInMillis);
            this.validator = calendarConstraints.validator;
        }

        public Builder setStart(long j) {
            this.start = j;
            return this;
        }

        public Builder setEnd(long j) {
            this.end = j;
            return this;
        }

        public Builder setOpenAt(long j) {
            this.openAt = Long.valueOf(j);
            return this;
        }

        public Builder setValidator(DateValidator dateValidator) {
            this.validator = dateValidator;
            return this;
        }

        public CalendarConstraints build() {
            if (this.openAt == null) {
                long thisMonthInUtcMilliseconds = MaterialDatePicker.thisMonthInUtcMilliseconds();
                if (this.start > thisMonthInUtcMilliseconds || thisMonthInUtcMilliseconds > this.end) {
                    thisMonthInUtcMilliseconds = this.start;
                }
                this.openAt = Long.valueOf(thisMonthInUtcMilliseconds);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            return new CalendarConstraints(Month.create(this.start), Month.create(this.end), Month.create(this.openAt.longValue()), (DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY));
        }
    }
}
