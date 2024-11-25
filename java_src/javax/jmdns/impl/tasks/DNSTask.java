package javax.jmdns.impl.tasks;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.jmdns.impl.DNSIncoming;
import javax.jmdns.impl.DNSOutgoing;
import javax.jmdns.impl.DNSQuestion;
import javax.jmdns.impl.DNSRecord;
import javax.jmdns.impl.JmDNSImpl;
/* loaded from: classes2.dex */
public abstract class DNSTask extends TimerTask {
    private final JmDNSImpl _jmDNSImpl;

    public abstract String getName();

    public abstract void start(Timer timer);

    /* JADX INFO: Access modifiers changed from: protected */
    public DNSTask(JmDNSImpl jmDNSImpl) {
        this._jmDNSImpl = jmDNSImpl;
    }

    public JmDNSImpl getDns() {
        return this._jmDNSImpl;
    }

    public String toString() {
        return getName();
    }

    public DNSOutgoing addQuestion(DNSOutgoing dNSOutgoing, DNSQuestion dNSQuestion) throws IOException {
        try {
            dNSOutgoing.addQuestion(dNSQuestion);
            return dNSOutgoing;
        } catch (IOException unused) {
            int flags = dNSOutgoing.getFlags();
            boolean isMulticast = dNSOutgoing.isMulticast();
            int maxUDPPayload = dNSOutgoing.getMaxUDPPayload();
            int id = dNSOutgoing.getId();
            dNSOutgoing.setFlags(flags | 512);
            dNSOutgoing.setId(id);
            this._jmDNSImpl.send(dNSOutgoing);
            DNSOutgoing dNSOutgoing2 = new DNSOutgoing(flags, isMulticast, maxUDPPayload);
            dNSOutgoing2.addQuestion(dNSQuestion);
            return dNSOutgoing2;
        }
    }

    public DNSOutgoing addAnswer(DNSOutgoing dNSOutgoing, DNSIncoming dNSIncoming, DNSRecord dNSRecord) throws IOException {
        try {
            dNSOutgoing.addAnswer(dNSIncoming, dNSRecord);
            return dNSOutgoing;
        } catch (IOException unused) {
            int flags = dNSOutgoing.getFlags();
            boolean isMulticast = dNSOutgoing.isMulticast();
            int maxUDPPayload = dNSOutgoing.getMaxUDPPayload();
            int id = dNSOutgoing.getId();
            dNSOutgoing.setFlags(flags | 512);
            dNSOutgoing.setId(id);
            this._jmDNSImpl.send(dNSOutgoing);
            DNSOutgoing dNSOutgoing2 = new DNSOutgoing(flags, isMulticast, maxUDPPayload);
            dNSOutgoing2.addAnswer(dNSIncoming, dNSRecord);
            return dNSOutgoing2;
        }
    }

    public DNSOutgoing addAnswer(DNSOutgoing dNSOutgoing, DNSRecord dNSRecord, long j) throws IOException {
        try {
            dNSOutgoing.addAnswer(dNSRecord, j);
            return dNSOutgoing;
        } catch (IOException unused) {
            int flags = dNSOutgoing.getFlags();
            boolean isMulticast = dNSOutgoing.isMulticast();
            int maxUDPPayload = dNSOutgoing.getMaxUDPPayload();
            int id = dNSOutgoing.getId();
            dNSOutgoing.setFlags(flags | 512);
            dNSOutgoing.setId(id);
            this._jmDNSImpl.send(dNSOutgoing);
            DNSOutgoing dNSOutgoing2 = new DNSOutgoing(flags, isMulticast, maxUDPPayload);
            dNSOutgoing2.addAnswer(dNSRecord, j);
            return dNSOutgoing2;
        }
    }

    public DNSOutgoing addAuthoritativeAnswer(DNSOutgoing dNSOutgoing, DNSRecord dNSRecord) throws IOException {
        try {
            dNSOutgoing.addAuthorativeAnswer(dNSRecord);
            return dNSOutgoing;
        } catch (IOException unused) {
            int flags = dNSOutgoing.getFlags();
            boolean isMulticast = dNSOutgoing.isMulticast();
            int maxUDPPayload = dNSOutgoing.getMaxUDPPayload();
            int id = dNSOutgoing.getId();
            dNSOutgoing.setFlags(flags | 512);
            dNSOutgoing.setId(id);
            this._jmDNSImpl.send(dNSOutgoing);
            DNSOutgoing dNSOutgoing2 = new DNSOutgoing(flags, isMulticast, maxUDPPayload);
            dNSOutgoing2.addAuthorativeAnswer(dNSRecord);
            return dNSOutgoing2;
        }
    }

    public DNSOutgoing addAdditionalAnswer(DNSOutgoing dNSOutgoing, DNSIncoming dNSIncoming, DNSRecord dNSRecord) throws IOException {
        try {
            dNSOutgoing.addAdditionalAnswer(dNSIncoming, dNSRecord);
            return dNSOutgoing;
        } catch (IOException unused) {
            int flags = dNSOutgoing.getFlags();
            boolean isMulticast = dNSOutgoing.isMulticast();
            int maxUDPPayload = dNSOutgoing.getMaxUDPPayload();
            int id = dNSOutgoing.getId();
            dNSOutgoing.setFlags(flags | 512);
            dNSOutgoing.setId(id);
            this._jmDNSImpl.send(dNSOutgoing);
            DNSOutgoing dNSOutgoing2 = new DNSOutgoing(flags, isMulticast, maxUDPPayload);
            dNSOutgoing2.addAdditionalAnswer(dNSIncoming, dNSRecord);
            return dNSOutgoing2;
        }
    }
}
