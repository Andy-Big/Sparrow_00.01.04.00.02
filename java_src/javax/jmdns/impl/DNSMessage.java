package javax.jmdns.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.jmdns.impl.constants.DNSConstants;
import kotlin.UByte;
/* loaded from: classes2.dex */
public abstract class DNSMessage {
    public static final boolean MULTICAST = true;
    public static final boolean UNICAST = false;
    private int _flags;
    private int _id;
    boolean _multicast;
    protected final List<DNSQuestion> _questions = Collections.synchronizedList(new LinkedList());
    protected final List<DNSRecord> _answers = Collections.synchronizedList(new LinkedList());
    protected final List<DNSRecord> _authoritativeAnswers = Collections.synchronizedList(new LinkedList());
    protected final List<DNSRecord> _additionals = Collections.synchronizedList(new LinkedList());

    /* JADX INFO: Access modifiers changed from: protected */
    public DNSMessage(int i, int i2, boolean z) {
        this._flags = i;
        this._id = i2;
        this._multicast = z;
    }

    public int getId() {
        if (this._multicast) {
            return 0;
        }
        return this._id;
    }

    public void setId(int i) {
        this._id = i;
    }

    public int getFlags() {
        return this._flags;
    }

    public void setFlags(int i) {
        this._flags = i;
    }

    public boolean isMulticast() {
        return this._multicast;
    }

    public Collection<? extends DNSQuestion> getQuestions() {
        return this._questions;
    }

    public int getNumberOfQuestions() {
        return getQuestions().size();
    }

    public List<DNSRecord> getAllAnswers() {
        ArrayList arrayList = new ArrayList(this._answers.size() + this._authoritativeAnswers.size() + this._additionals.size());
        arrayList.addAll(this._answers);
        arrayList.addAll(this._authoritativeAnswers);
        arrayList.addAll(this._additionals);
        return arrayList;
    }

    public Collection<? extends DNSRecord> getAnswers() {
        return this._answers;
    }

    public int getNumberOfAnswers() {
        return getAnswers().size();
    }

    public Collection<? extends DNSRecord> getAuthorities() {
        return this._authoritativeAnswers;
    }

    public int getNumberOfAuthorities() {
        return getAuthorities().size();
    }

    public Collection<? extends DNSRecord> getAdditionals() {
        return this._additionals;
    }

    public int getNumberOfAdditionals() {
        return getAdditionals().size();
    }

    public boolean isValidResponseCode() {
        return (this._flags & 15) == 0;
    }

    public int getOperationCode() {
        return (this._flags & DNSConstants.FLAGS_OPCODE) >> 11;
    }

    public boolean isTruncated() {
        return (this._flags & 512) != 0;
    }

    public boolean isAuthoritativeAnswer() {
        return (this._flags & 1024) != 0;
    }

    public boolean isQuery() {
        return (this._flags & 32768) == 0;
    }

    public boolean isResponse() {
        return (this._flags & 32768) == 32768;
    }

    public boolean isEmpty() {
        return ((getNumberOfQuestions() + getNumberOfAnswers()) + getNumberOfAuthorities()) + getNumberOfAdditionals() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String print() {
        StringBuilder sb = new StringBuilder(200);
        sb.append(toString());
        sb.append("\n");
        for (DNSQuestion dNSQuestion : this._questions) {
            sb.append("\tquestion:      ");
            sb.append(dNSQuestion);
            sb.append("\n");
        }
        for (DNSRecord dNSRecord : this._answers) {
            sb.append("\tanswer:        ");
            sb.append(dNSRecord);
            sb.append("\n");
        }
        for (DNSRecord dNSRecord2 : this._authoritativeAnswers) {
            sb.append("\tauthoritative: ");
            sb.append(dNSRecord2);
            sb.append("\n");
        }
        for (DNSRecord dNSRecord3 : this._additionals) {
            sb.append("\tadditional:    ");
            sb.append(dNSRecord3);
            sb.append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String print(byte[] bArr) {
        StringBuilder sb = new StringBuilder(4000);
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int min = Math.min(32, length - i);
            if (i < 16) {
                sb.append(' ');
            }
            if (i < 256) {
                sb.append(' ');
            }
            if (i < 4096) {
                sb.append(' ');
            }
            sb.append(Integer.toHexString(i));
            sb.append(':');
            int i2 = 0;
            while (i2 < min) {
                if (i2 % 8 == 0) {
                    sb.append(' ');
                }
                int i3 = i + i2;
                sb.append(Integer.toHexString((bArr[i3] & 240) >> 4));
                sb.append(Integer.toHexString((bArr[i3] & 15) >> 0));
                i2++;
            }
            if (i2 < 32) {
                while (i2 < 32) {
                    if (i2 % 8 == 0) {
                        sb.append(' ');
                    }
                    sb.append("  ");
                    i2++;
                }
            }
            sb.append("    ");
            for (int i4 = 0; i4 < min; i4++) {
                if (i4 % 8 == 0) {
                    sb.append(' ');
                }
                int i5 = bArr[i + i4] & UByte.MAX_VALUE;
                sb.append((i5 <= 32 || i5 >= 127) ? '.' : (char) i5);
            }
            sb.append("\n");
            i += 32;
            if (i >= 2048) {
                sb.append("....\n");
                break;
            }
        }
        return sb.toString();
    }
}
