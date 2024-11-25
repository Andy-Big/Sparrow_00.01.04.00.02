package com.sun.activation.registries;

import java.util.NoSuchElementException;
import java.util.Vector;
/* compiled from: MimeTypeFile.java */
/* loaded from: classes2.dex */
class LineTokenizer {
    private static final String singles = "=";
    private int maxPosition;
    private String str;
    private Vector stack = new Vector();
    private int currentPosition = 0;

    public LineTokenizer(String str) {
        this.str = str;
        this.maxPosition = str.length();
    }

    private void skipWhiteSpace() {
        while (true) {
            int i = this.currentPosition;
            if (i >= this.maxPosition || !Character.isWhitespace(this.str.charAt(i))) {
                return;
            }
            this.currentPosition++;
        }
    }

    public boolean hasMoreTokens() {
        if (this.stack.size() > 0) {
            return true;
        }
        skipWhiteSpace();
        return this.currentPosition < this.maxPosition;
    }

    public String nextToken() {
        int size = this.stack.size();
        if (size > 0) {
            int i = size - 1;
            String str = (String) this.stack.elementAt(i);
            this.stack.removeElementAt(i);
            return str;
        }
        skipWhiteSpace();
        int i2 = this.currentPosition;
        if (i2 >= this.maxPosition) {
            throw new NoSuchElementException();
        }
        char charAt = this.str.charAt(i2);
        if (charAt == '\"') {
            this.currentPosition++;
            boolean z = false;
            while (true) {
                int i3 = this.currentPosition;
                if (i3 >= this.maxPosition) {
                    break;
                }
                String str2 = this.str;
                this.currentPosition = i3 + 1;
                char charAt2 = str2.charAt(i3);
                if (charAt2 == '\\') {
                    this.currentPosition++;
                    z = true;
                } else if (charAt2 == '\"') {
                    if (z) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i4 = i2 + 1; i4 < this.currentPosition - 1; i4++) {
                            char charAt3 = this.str.charAt(i4);
                            if (charAt3 != '\\') {
                                stringBuffer.append(charAt3);
                            }
                        }
                        return stringBuffer.toString();
                    }
                    return this.str.substring(i2 + 1, this.currentPosition - 1);
                }
            }
        } else if (singles.indexOf(charAt) < 0) {
            while (true) {
                int i5 = this.currentPosition;
                if (i5 >= this.maxPosition || singles.indexOf(this.str.charAt(i5)) >= 0 || Character.isWhitespace(this.str.charAt(this.currentPosition))) {
                    break;
                }
                this.currentPosition++;
            }
        } else {
            this.currentPosition++;
        }
        return this.str.substring(i2, this.currentPosition);
    }

    public void pushToken(String str) {
        this.stack.addElement(str);
    }
}
