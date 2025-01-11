package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private int[] stack = new int[32];
    private int stackSize = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public final void setHtmlSafe(boolean z) {
        this.htmlSafe = z;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public final void setSerializeNulls(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return open(1, "[");
    }

    public JsonWriter endArray() throws IOException {
        return close(1, 2, "]");
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return open(3, "{");
    }

    public JsonWriter endObject() throws IOException {
        return close(3, 5, "}");
    }

    private JsonWriter open(int i, String str) throws IOException {
        beforeValue();
        push(i);
        this.out.write(str);
        return this;
    }

    private JsonWriter close(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
        this.stackSize--;
        if (peek == i2) {
            newline();
        }
        this.out.write(str);
        return this;
    }

    private void push(int i) {
        int i2 = this.stackSize;
        int[] iArr = this.stack;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.stack = iArr2;
        }
        int[] iArr3 = this.stack;
        int i3 = this.stackSize;
        this.stackSize = i3 + 1;
        iArr3[i3] = i;
    }

    private int peek() {
        int i = this.stackSize;
        if (i == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.stack[i - 1];
    }

    private void replaceTop(int i) {
        this.stack[this.stackSize - 1] = i;
    }

    public JsonWriter name(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException();
        }
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.deferredName = str;
        return this;
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        string(str);
        return this;
    }

    public JsonWriter jsonValue(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.append((CharSequence) str);
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (this.serializeNulls) {
                writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(z ? "true" : "false");
        return this;
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public JsonWriter value(double d) throws IOException {
        writeDeferredName();
        if (!this.lenient && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        beforeValue();
        this.out.append((CharSequence) Double.toString(d));
        return this;
    }

    public JsonWriter value(long j) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(j));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        writeDeferredName();
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        beforeValue();
        this.out.append((CharSequence) obj);
        return this;
    }

    public void flush() throws IOException {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int i = this.stackSize;
        if (i > 1 || (i == 1 && this.stack[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i;
        String str2;
        String[] strArr = this.htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
        this.out.write("\"");
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                str2 = strArr[charAt];
                i = str2 == null ? i + 1 : 0;
                if (i2 < i) {
                    this.out.write(str, i2, i - i2);
                }
                this.out.write(str2);
                i2 = i + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i) {
                }
                this.out.write(str2);
                i2 = i + 1;
            }
        }
        if (i2 < length) {
            this.out.write(str, i2, length - i2);
        }
        this.out.write("\"");
    }

    private void newline() throws IOException {
        if (this.indent == null) {
            return;
        }
        this.out.write("\n");
        int i = this.stackSize;
        for (int i2 = 1; i2 < i; i2++) {
            this.out.write(this.indent);
        }
    }

    private void beforeName() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.out.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue() throws IOException {
        int peek = peek();
        if (peek == 1) {
            replaceTop(2);
            newline();
        } else if (peek == 2) {
            this.out.append(',');
            newline();
        } else if (peek != 4) {
            if (peek != 6) {
                if (peek == 7) {
                    if (!this.lenient) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            replaceTop(7);
        } else {
            this.out.append((CharSequence) this.separator);
            replaceTop(5);
        }
    }
}
