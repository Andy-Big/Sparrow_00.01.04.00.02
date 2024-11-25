package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kotlin.UByte;
/* loaded from: classes2.dex */
public class Response {
    private static String ASTRING_CHAR_DELIM = " (){%*\"\\";
    private static String ATOM_CHAR_DELIM = " (){%*\"\\]";
    public static final int BAD = 12;
    public static final int BYE = 16;
    public static final int CONTINUATION = 1;
    public static final int NO = 8;
    public static final int OK = 4;
    public static final int SYNTHETIC = 32;
    public static final int TAGGED = 2;
    public static final int TAG_MASK = 3;
    public static final int TYPE_MASK = 28;
    public static final int UNTAGGED = 3;
    private static final int increment = 100;
    protected byte[] buffer;
    protected Exception ex;
    protected int index;
    protected int pindex;
    protected int size;
    protected String tag;
    protected int type;
    protected boolean utf8;

    public Response(String str) {
        this(str, true);
    }

    public Response(String str, boolean z) {
        this.buffer = null;
        this.type = 0;
        this.tag = null;
        if (z) {
            this.buffer = str.getBytes(StandardCharsets.UTF_8);
        } else {
            this.buffer = str.getBytes(StandardCharsets.US_ASCII);
        }
        this.size = this.buffer.length;
        this.utf8 = z;
        parse();
    }

    public Response(Protocol protocol) throws IOException, ProtocolException {
        this.buffer = null;
        this.type = 0;
        this.tag = null;
        ByteArray readResponse = protocol.getInputStream().readResponse(protocol.getResponseBuffer());
        this.buffer = readResponse.getBytes();
        this.size = readResponse.getCount() - 2;
        this.utf8 = protocol.supportsUtf8();
        parse();
    }

    public Response(Response response) {
        this.buffer = null;
        this.type = 0;
        this.tag = null;
        this.index = response.index;
        this.pindex = response.pindex;
        this.size = response.size;
        this.buffer = response.buffer;
        this.type = response.type;
        this.tag = response.tag;
        this.ex = response.ex;
        this.utf8 = response.utf8;
    }

    public static Response byeResponse(Exception exc) {
        Response response = new Response(("* BYE Jakarta Mail Exception: " + exc.toString()).replace('\r', ' ').replace('\n', ' '));
        response.type = response.type | 32;
        response.ex = exc;
        return response;
    }

    public boolean supportsUtf8() {
        return this.utf8;
    }

    private void parse() {
        this.index = 0;
        if (this.size == 0) {
            return;
        }
        byte[] bArr = this.buffer;
        if (bArr[0] == 43) {
            this.type |= 1;
            this.index = 0 + 1;
            return;
        }
        if (bArr[0] == 42) {
            this.type |= 3;
            this.index = 0 + 1;
        } else {
            this.type |= 2;
            String readAtom = readAtom();
            this.tag = readAtom;
            if (readAtom == null) {
                this.tag = "";
            }
        }
        int i = this.index;
        String readAtom2 = readAtom();
        String str = readAtom2 != null ? readAtom2 : "";
        if (str.equalsIgnoreCase("OK")) {
            this.type |= 4;
        } else if (str.equalsIgnoreCase("NO")) {
            this.type |= 8;
        } else if (str.equalsIgnoreCase("BAD")) {
            this.type |= 12;
        } else if (str.equalsIgnoreCase("BYE")) {
            this.type |= 16;
        } else {
            this.index = i;
        }
        this.pindex = this.index;
    }

    public void skipSpaces() {
        while (true) {
            int i = this.index;
            if (i >= this.size || this.buffer[i] != 32) {
                return;
            }
            this.index = i + 1;
        }
    }

    public boolean isNextNonSpace(char c) {
        skipSpaces();
        int i = this.index;
        if (i >= this.size || this.buffer[i] != ((byte) c)) {
            return false;
        }
        this.index = i + 1;
        return true;
    }

    public void skipToken() {
        while (true) {
            int i = this.index;
            if (i >= this.size || this.buffer[i] == 32) {
                return;
            }
            this.index = i + 1;
        }
    }

    public void skip(int i) {
        this.index += i;
    }

    public byte peekByte() {
        int i = this.index;
        if (i < this.size) {
            return this.buffer[i];
        }
        return (byte) 0;
    }

    public byte readByte() {
        int i = this.index;
        if (i < this.size) {
            byte[] bArr = this.buffer;
            this.index = i + 1;
            return bArr[i];
        }
        return (byte) 0;
    }

    public String readAtom() {
        return readDelimString(ATOM_CHAR_DELIM);
    }

    private String readDelimString(String str) {
        int i;
        skipSpaces();
        int i2 = this.index;
        if (i2 >= this.size) {
            return null;
        }
        while (true) {
            int i3 = this.index;
            if (i3 >= this.size || (i = this.buffer[i3] & UByte.MAX_VALUE) < 32 || str.indexOf((char) i) >= 0 || i == 127) {
                break;
            }
            this.index++;
        }
        return toString(this.buffer, i2, this.index);
    }

    public String readString(char c) {
        skipSpaces();
        int i = this.index;
        if (i >= this.size) {
            return null;
        }
        while (true) {
            int i2 = this.index;
            if (i2 >= this.size || this.buffer[i2] == c) {
                break;
            }
            this.index = i2 + 1;
        }
        return toString(this.buffer, i, this.index);
    }

    public String[] readStringList() {
        return readStringList(false);
    }

    public String[] readAtomStringList() {
        return readStringList(true);
    }

    private String[] readStringList(boolean z) {
        skipSpaces();
        byte[] bArr = this.buffer;
        int i = this.index;
        if (bArr[i] != 40) {
            return null;
        }
        this.index = i + 1;
        ArrayList arrayList = new ArrayList();
        while (!isNextNonSpace(')')) {
            String readAtomString = z ? readAtomString() : readString();
            if (readAtomString == null) {
                break;
            }
            arrayList.add(readAtomString);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public int readNumber() {
        skipSpaces();
        int i = this.index;
        while (true) {
            int i2 = this.index;
            if (i2 >= this.size || !Character.isDigit((char) this.buffer[i2])) {
                break;
            }
            this.index++;
        }
        int i3 = this.index;
        if (i3 > i) {
            try {
                return ASCIIUtility.parseInt(this.buffer, i, i3);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return -1;
    }

    public long readLong() {
        skipSpaces();
        int i = this.index;
        while (true) {
            int i2 = this.index;
            if (i2 >= this.size || !Character.isDigit((char) this.buffer[i2])) {
                break;
            }
            this.index++;
        }
        int i3 = this.index;
        if (i3 > i) {
            try {
                return ASCIIUtility.parseLong(this.buffer, i, i3);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return -1L;
    }

    public String readString() {
        return (String) parseString(false, true);
    }

    public ByteArrayInputStream readBytes() {
        ByteArray readByteArray = readByteArray();
        if (readByteArray != null) {
            return readByteArray.toByteArrayInputStream();
        }
        return null;
    }

    public ByteArray readByteArray() {
        if (isContinuation()) {
            skipSpaces();
            byte[] bArr = this.buffer;
            int i = this.index;
            return new ByteArray(bArr, i, this.size - i);
        }
        return (ByteArray) parseString(false, false);
    }

    public String readAtomString() {
        return (String) parseString(true, true);
    }

    private Object parseString(boolean z, boolean z2) {
        byte[] bArr;
        int i;
        byte b;
        skipSpaces();
        byte[] bArr2 = this.buffer;
        int i2 = this.index;
        byte b2 = bArr2[i2];
        if (b2 == 34) {
            int i3 = i2 + 1;
            this.index = i3;
            int i4 = i3;
            while (true) {
                int i5 = this.index;
                if (i5 >= this.size || (b = this.buffer[i5]) == 34) {
                    break;
                }
                if (b == 92) {
                    this.index = i5 + 1;
                }
                int i6 = this.index;
                if (i6 != i4) {
                    byte[] bArr3 = this.buffer;
                    bArr3[i4] = bArr3[i6];
                }
                i4++;
                this.index++;
            }
            int i7 = this.index;
            if (i7 >= this.size) {
                return null;
            }
            this.index = i7 + 1;
            if (z2) {
                return toString(this.buffer, i3, i4);
            }
            return new ByteArray(this.buffer, i3, i4 - i3);
        } else if (b2 != 123) {
            if (z) {
                return z2 ? readDelimString(ASTRING_CHAR_DELIM) : new ByteArray(this.buffer, i2, this.index);
            } else if (b2 == 78 || b2 == 110) {
                this.index += 3;
                return null;
            } else {
                return null;
            }
        } else {
            int i8 = i2 + 1;
            this.index = i8;
            while (true) {
                bArr = this.buffer;
                i = this.index;
                if (bArr[i] == 125) {
                    try {
                        break;
                    } catch (NumberFormatException unused) {
                        return null;
                    }
                }
                this.index = i + 1;
            }
            int parseInt = ASCIIUtility.parseInt(bArr, i8, i);
            int i9 = this.index + 3;
            int i10 = i9 + parseInt;
            this.index = i10;
            if (z2) {
                return toString(this.buffer, i9, i10);
            }
            return new ByteArray(this.buffer, i9, parseInt);
        }
    }

    private String toString(byte[] bArr, int i, int i2) {
        return this.utf8 ? new String(bArr, i, i2 - i, StandardCharsets.UTF_8) : ASCIIUtility.toString(bArr, i, i2);
    }

    public int getType() {
        return this.type;
    }

    public boolean isContinuation() {
        return (this.type & 3) == 1;
    }

    public boolean isTagged() {
        return (this.type & 3) == 2;
    }

    public boolean isUnTagged() {
        return (this.type & 3) == 3;
    }

    public boolean isOK() {
        return (this.type & 28) == 4;
    }

    public boolean isNO() {
        return (this.type & 28) == 8;
    }

    public boolean isBAD() {
        return (this.type & 28) == 12;
    }

    public boolean isBYE() {
        return (this.type & 28) == 16;
    }

    public boolean isSynthetic() {
        return (this.type & 32) == 32;
    }

    public String getTag() {
        return this.tag;
    }

    public String getRest() {
        skipSpaces();
        return toString(this.buffer, this.index, this.size);
    }

    public Exception getException() {
        return this.ex;
    }

    public void reset() {
        this.index = this.pindex;
    }

    public String toString() {
        return toString(this.buffer, 0, this.size);
    }
}
