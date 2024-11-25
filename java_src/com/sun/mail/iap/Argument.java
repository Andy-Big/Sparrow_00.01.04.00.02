package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;
/* loaded from: classes2.dex */
public class Argument {
    protected List<Object> items = new ArrayList(1);

    public Argument append(Argument argument) {
        this.items.addAll(argument.items);
        return this;
    }

    public Argument writeString(String str) {
        this.items.add(new AString(ASCIIUtility.getBytes(str)));
        return this;
    }

    public Argument writeString(String str, String str2) throws UnsupportedEncodingException {
        if (str2 == null) {
            writeString(str);
        } else {
            this.items.add(new AString(str.getBytes(str2)));
        }
        return this;
    }

    public Argument writeString(String str, Charset charset) {
        if (charset == null) {
            writeString(str);
        } else {
            this.items.add(new AString(str.getBytes(charset)));
        }
        return this;
    }

    public Argument writeNString(String str) {
        if (str == null) {
            this.items.add(new NString(null));
        } else {
            this.items.add(new NString(ASCIIUtility.getBytes(str)));
        }
        return this;
    }

    public Argument writeNString(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            this.items.add(new NString(null));
        } else if (str2 == null) {
            writeString(str);
        } else {
            this.items.add(new NString(str.getBytes(str2)));
        }
        return this;
    }

    public Argument writeNString(String str, Charset charset) {
        if (str == null) {
            this.items.add(new NString(null));
        } else if (charset == null) {
            writeString(str);
        } else {
            this.items.add(new NString(str.getBytes(charset)));
        }
        return this;
    }

    public Argument writeBytes(byte[] bArr) {
        this.items.add(bArr);
        return this;
    }

    public Argument writeBytes(ByteArrayOutputStream byteArrayOutputStream) {
        this.items.add(byteArrayOutputStream);
        return this;
    }

    public Argument writeBytes(Literal literal) {
        this.items.add(literal);
        return this;
    }

    public Argument writeAtom(String str) {
        this.items.add(new Atom(str));
        return this;
    }

    public Argument writeNumber(int i) {
        this.items.add(Integer.valueOf(i));
        return this;
    }

    public Argument writeNumber(long j) {
        this.items.add(Long.valueOf(j));
        return this;
    }

    public Argument writeArgument(Argument argument) {
        this.items.add(argument);
        return this;
    }

    public void write(Protocol protocol) throws IOException, ProtocolException {
        List<Object> list = this.items;
        int size = list != null ? list.size() : 0;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                dataOutputStream.write(32);
            }
            Object obj = this.items.get(i);
            if (obj instanceof Atom) {
                dataOutputStream.writeBytes(((Atom) obj).string);
            } else if (obj instanceof Number) {
                dataOutputStream.writeBytes(((Number) obj).toString());
            } else if (obj instanceof AString) {
                astring(((AString) obj).bytes, protocol);
            } else if (obj instanceof NString) {
                nstring(((NString) obj).bytes, protocol);
            } else if (obj instanceof byte[]) {
                literal((byte[]) obj, protocol);
            } else if (obj instanceof ByteArrayOutputStream) {
                literal((ByteArrayOutputStream) obj, protocol);
            } else if (obj instanceof Literal) {
                literal((Literal) obj, protocol);
            } else if (obj instanceof Argument) {
                dataOutputStream.write(40);
                ((Argument) obj).write(protocol);
                dataOutputStream.write(41);
            }
        }
    }

    private void astring(byte[] bArr, Protocol protocol) throws IOException, ProtocolException {
        nastring(bArr, protocol, false);
    }

    private void nstring(byte[] bArr, Protocol protocol) throws IOException, ProtocolException {
        if (bArr == null) {
            ((DataOutputStream) protocol.getOutputStream()).writeBytes("NIL");
        } else {
            nastring(bArr, protocol, true);
        }
    }

    private void nastring(byte[] bArr, Protocol protocol, boolean z) throws IOException, ProtocolException {
        int i;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        int length = bArr.length;
        if (length > 1024) {
            literal(bArr, protocol);
            return;
        }
        boolean z2 = true;
        boolean z3 = length == 0 ? true : z;
        boolean supportsUtf8 = protocol.supportsUtf8();
        boolean z4 = false;
        for (byte b : bArr) {
            if (b == 0 || b == 13 || b == 10 || (!supportsUtf8 && (b & UByte.MAX_VALUE) > 127)) {
                literal(bArr, protocol);
                return;
            }
            if (b == 42 || b == 37 || b == 40 || b == 41 || b == 123 || b == 34 || b == 92 || (i = b & UByte.MAX_VALUE) <= 32 || i > 127) {
                if (b == 34 || b == 92) {
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = true;
                }
            }
        }
        if (z3 || bArr.length != 3 || ((bArr[0] != 78 && bArr[0] != 110) || ((bArr[1] != 73 && bArr[1] != 105) || (bArr[2] != 76 && bArr[2] != 108)))) {
            z2 = z3;
        }
        if (z2) {
            dataOutputStream.write(34);
        }
        if (z4) {
            for (byte b2 : bArr) {
                if (b2 == 34 || b2 == 92) {
                    dataOutputStream.write(92);
                }
                dataOutputStream.write(b2);
            }
        } else {
            dataOutputStream.write(bArr);
        }
        if (z2) {
            dataOutputStream.write(34);
        }
    }

    private void literal(byte[] bArr, Protocol protocol) throws IOException, ProtocolException {
        startLiteral(protocol, bArr.length).write(bArr);
    }

    private void literal(ByteArrayOutputStream byteArrayOutputStream, Protocol protocol) throws IOException, ProtocolException {
        byteArrayOutputStream.writeTo(startLiteral(protocol, byteArrayOutputStream.size()));
    }

    private void literal(Literal literal, Protocol protocol) throws IOException, ProtocolException {
        literal.writeTo(startLiteral(protocol, literal.size()));
    }

    private OutputStream startLiteral(Protocol protocol, int i) throws IOException, ProtocolException {
        Response readResponse;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        boolean supportsNonSyncLiterals = protocol.supportsNonSyncLiterals();
        dataOutputStream.write(123);
        dataOutputStream.writeBytes(Integer.toString(i));
        if (supportsNonSyncLiterals) {
            dataOutputStream.writeBytes("+}\r\n");
        } else {
            dataOutputStream.writeBytes("}\r\n");
        }
        dataOutputStream.flush();
        if (!supportsNonSyncLiterals) {
            do {
                readResponse = protocol.readResponse();
                if (readResponse.isContinuation()) {
                }
            } while (!readResponse.isTagged());
            throw new LiteralException(readResponse);
        }
        return dataOutputStream;
    }
}
