package com.rigol.lib.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Firmware implements Parcelable {
    public static final Parcelable.Creator<Firmware> CREATOR = new Parcelable.Creator<Firmware>() { // from class: com.rigol.lib.data.Firmware.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Firmware createFromParcel(Parcel parcel) {
            return new Firmware(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Firmware[] newArray(int i) {
            return new Firmware[i];
        }
    };
    private String comment_cn;
    private String comment_en;
    private String series;
    private String url;
    private String version;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Firmware() {
    }

    public Firmware(String str, String str2, String str3, String str4, String str5) {
        this.series = str;
        this.version = str2;
        this.url = str3;
        this.comment_cn = str4;
        this.comment_en = str5;
    }

    protected Firmware(Parcel parcel) {
        this.series = parcel.readString();
        this.version = parcel.readString();
        this.url = parcel.readString();
        this.comment_cn = parcel.readString();
        this.comment_en = parcel.readString();
    }

    public String getComment_cn() {
        return this.comment_cn;
    }

    public String getComment_en() {
        return this.comment_en;
    }

    public String getSeries() {
        return this.series;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setComment_cn(String str) {
        this.comment_cn = str;
    }

    public void setComment_en(String str) {
        this.comment_en = str;
    }

    public void setSeries(String str) {
        this.series = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.series);
        parcel.writeString(this.version);
        parcel.writeString(this.url);
        parcel.writeString(this.comment_cn);
        parcel.writeString(this.comment_en);
    }
}
