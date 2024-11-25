package com.shockwave.pdfium.util;
/* loaded from: classes2.dex */
public class Size {
    private final int height;
    private final int width;

    public Size(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.width == size.width && this.height == size.height;
        }
        return false;
    }

    public String toString() {
        return this.width + "x" + this.height;
    }

    public int hashCode() {
        int i = this.height;
        int i2 = this.width;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }
}
