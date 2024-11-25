package javax.jmdns.impl.tasks;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import javax.jmdns.impl.DNSIncoming;
import javax.jmdns.impl.DNSOutgoing;
import javax.jmdns.impl.DNSQuestion;
import javax.jmdns.impl.DNSRecord;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.constants.DNSConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes2.dex */
public class Responder extends DNSTask {
    static Logger logger = LoggerFactory.getLogger(Responder.class.getName());
    private final InetAddress _addr;
    private final DNSIncoming _in;
    private final int _port;
    private final boolean _unicast;

    public Responder(JmDNSImpl jmDNSImpl, DNSIncoming dNSIncoming, InetAddress inetAddress, int i) {
        super(jmDNSImpl);
        this._in = dNSIncoming;
        this._addr = inetAddress;
        this._port = i;
        this._unicast = i != DNSConstants.MDNS_PORT;
    }

    @Override // javax.jmdns.impl.tasks.DNSTask
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append("Responder(");
        sb.append(getDns() != null ? getDns().getName() : "");
        sb.append(")");
        return sb.toString();
    }

    @Override // javax.jmdns.impl.tasks.DNSTask
    public String toString() {
        return super.toString() + " incomming: " + this._in;
    }

    @Override // javax.jmdns.impl.tasks.DNSTask
    public void start(Timer timer) {
        boolean z = true;
        for (DNSQuestion dNSQuestion : this._in.getQuestions()) {
            logger.trace("{}.start() question={}", getName(), dNSQuestion);
            z = dNSQuestion.iAmTheOnlyOne(getDns());
            if (!z) {
                break;
            }
        }
        int nextInt = (!z || this._in.isTruncated()) ? (JmDNSImpl.getRandom().nextInt(96) + 20) - this._in.elapseSinceArrival() : 0;
        int i = nextInt >= 0 ? nextInt : 0;
        logger.trace("{}.start() Responder chosen delay={}", getName(), Integer.valueOf(i));
        if (getDns().isCanceling() || getDns().isCanceled()) {
            return;
        }
        timer.schedule(this, i);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        getDns().respondToQuery(this._in);
        HashSet<DNSQuestion> hashSet = new HashSet();
        Set<DNSRecord> hashSet2 = new HashSet<>();
        if (getDns().isAnnounced()) {
            try {
                for (DNSQuestion dNSQuestion : this._in.getQuestions()) {
                    logger.debug("{}.run() JmDNS responding to: {}", getName(), dNSQuestion);
                    if (this._unicast) {
                        hashSet.add(dNSQuestion);
                    }
                    dNSQuestion.addAnswers(getDns(), hashSet2);
                }
                long currentTimeMillis = System.currentTimeMillis();
                for (DNSRecord dNSRecord : this._in.getAnswers()) {
                    if (dNSRecord.isStale(currentTimeMillis)) {
                        hashSet2.remove(dNSRecord);
                        logger.debug("{} - JmDNS Responder Known Answer Removed", getName());
                    }
                }
                if (hashSet2.isEmpty()) {
                    return;
                }
                logger.debug("{}.run() JmDNS responding", getName());
                DNSOutgoing dNSOutgoing = new DNSOutgoing(33792, !this._unicast, this._in.getSenderUDPPayload());
                if (this._unicast) {
                    dNSOutgoing.setDestination(new InetSocketAddress(this._addr, this._port));
                }
                dNSOutgoing.setId(this._in.getId());
                for (DNSQuestion dNSQuestion2 : hashSet) {
                    if (dNSQuestion2 != null) {
                        dNSOutgoing = addQuestion(dNSOutgoing, dNSQuestion2);
                    }
                }
                for (DNSRecord dNSRecord2 : hashSet2) {
                    if (dNSRecord2 != null) {
                        dNSOutgoing = addAnswer(dNSOutgoing, this._in, dNSRecord2);
                    }
                }
                if (dNSOutgoing.isEmpty()) {
                    return;
                }
                getDns().send(dNSOutgoing);
            } catch (Throwable th) {
                Logger logger2 = logger;
                logger2.warn(getName() + "run() exception ", th);
                getDns().close();
            }
        }
    }
}
