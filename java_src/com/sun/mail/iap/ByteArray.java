package com.sun.mail.iap;

import java.io.ByteArrayInputStream;
/* loaded from: classes2.dex */
public class ByteArray {
    private byte[] bytes;
    private int count;
    private int start;

    public ByteArray(byte[] bArr, int i, int i2) {
        this.bytes = bArr;
        this.start = i;
        this.count = i2;
    }

    public ByteArray(int i) {
        this(new byte[i], 0, i);
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public byte[] getNewBytes() {
        int i = this.count;
        byte[] bArr = new byte[i];
        System.arraycopy(this.bytes, this.start, bArr, 0, i);
        return bArr;
    }

    public int getStart() {
        return this.start;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public ByteArrayInputStream toByteArrayInputStream() {
        return new ByteArrayInputStream(this.bytes, this.start, this.count);
    }

    public void grow(int i) {
        byte[] bArr = this.bytes;
        byte[] bArr2 = new byte[bArr.length + i];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.bytes = bArr2;
    }
}
