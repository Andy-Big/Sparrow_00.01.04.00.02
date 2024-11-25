package me.jessyan.autosize.external;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class ExternalAdaptInfo implements Parcelable {
    public static final Parcelable.Creator<ExternalAdaptInfo> CREATOR = new Parcelable.Creator<ExternalAdaptInfo>() { // from class: me.jessyan.autosize.external.ExternalAdaptInfo.1
        @Override // android.os.Parcelable.Creator
        public ExternalAdaptInfo createFromParcel(Parcel parcel) {
            return new ExternalAdaptInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ExternalAdaptInfo[] newArray(int i) {
            return new ExternalAdaptInfo[i];
        }
    };
    private boolean isBaseOnWidth;
    private float sizeInDp;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ExternalAdaptInfo(boolean z) {
        this.isBaseOnWidth = z;
    }

    public ExternalAdaptInfo(boolean z, float f) {
        this.isBaseOnWidth = z;
        this.sizeInDp = f;
    }

    public boolean isBaseOnWidth() {
        return this.isBaseOnWidth;
    }

    public void setBaseOnWidth(boolean z) {
        this.isBaseOnWidth = z;
    }

    public float getSizeInDp() {
        return this.sizeInDp;
    }

    public void setSizeInDp(float f) {
        this.sizeInDp = f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isBaseOnWidth ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.sizeInDp);
    }

    protected ExternalAdaptInfo(Parcel parcel) {
        this.isBaseOnWidth = parcel.readByte() != 0;
        this.sizeInDp = parcel.readFloat();
    }

    public String toString() {
        return "ExternalAdaptInfo{isBaseOnWidth=" + this.isBaseOnWidth + ", sizeInDp=" + this.sizeInDp + '}';
    }
}
