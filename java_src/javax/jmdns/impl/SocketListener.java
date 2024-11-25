package javax.jmdns.impl;

import java.io.IOException;
import java.net.DatagramPacket;
import javax.jmdns.impl.constants.DNSConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class SocketListener extends Thread {
    static Logger logger = LoggerFactory.getLogger(SocketListener.class.getName());
    private final JmDNSImpl _jmDNSImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SocketListener(javax.jmdns.impl.JmDNSImpl r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "SocketListener("
            r0.append(r1)
            if (r3 == 0) goto L11
            java.lang.String r1 = r3.getName()
            goto L13
        L11:
            java.lang.String r1 = ""
        L13:
            r0.append(r1)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            r0 = 1
            r2.setDaemon(r0)
            r2._jmDNSImpl = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.jmdns.impl.SocketListener.<init>(javax.jmdns.impl.JmDNSImpl):void");
    }

    private void sleepThread() {
        if (this._jmDNSImpl._threadSleepDurationMs > 0) {
            try {
                Thread.sleep(this._jmDNSImpl._threadSleepDurationMs);
            } catch (InterruptedException e) {
                Logger logger2 = logger;
                logger2.warn(getName() + ".run() interrupted ", (Throwable) e);
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[8972], 8972);
            while (!this._jmDNSImpl.isCanceling() && !this._jmDNSImpl.isCanceled()) {
                sleepThread();
                datagramPacket.setLength(8972);
                this._jmDNSImpl.getSocket().receive(datagramPacket);
                if (this._jmDNSImpl.isCanceling() || this._jmDNSImpl.isCanceled() || this._jmDNSImpl.isClosing() || this._jmDNSImpl.isClosed()) {
                    break;
                }
                try {
                    if (!this._jmDNSImpl.getLocalHost().shouldIgnorePacket(datagramPacket)) {
                        DNSIncoming dNSIncoming = new DNSIncoming(datagramPacket);
                        if (dNSIncoming.isValidResponseCode()) {
                            if (logger.isTraceEnabled()) {
                                logger.trace("{}.run() JmDNS in:{}", getName(), dNSIncoming.print(true));
                            }
                            if (dNSIncoming.isQuery()) {
                                if (datagramPacket.getPort() != DNSConstants.MDNS_PORT) {
                                    this._jmDNSImpl.handleQuery(dNSIncoming, datagramPacket.getAddress(), datagramPacket.getPort());
                                }
                                this._jmDNSImpl.handleQuery(dNSIncoming, this._jmDNSImpl.getGroup(), DNSConstants.MDNS_PORT);
                            } else {
                                this._jmDNSImpl.handleResponse(dNSIncoming);
                            }
                        } else if (logger.isDebugEnabled()) {
                            logger.debug("{}.run() JmDNS in message with error code: {}", getName(), dNSIncoming.print(true));
                        }
                    }
                } catch (IOException e) {
                    Logger logger2 = logger;
                    logger2.warn(getName() + ".run() exception ", (Throwable) e);
                }
            }
        } catch (IOException e2) {
            if (!this._jmDNSImpl.isCanceling() && !this._jmDNSImpl.isCanceled() && !this._jmDNSImpl.isClosing() && !this._jmDNSImpl.isClosed()) {
                Logger logger3 = logger;
                logger3.warn(getName() + ".run() exception ", (Throwable) e2);
                this._jmDNSImpl.recover();
            }
        }
        logger.trace("{}.run() exiting.", getName());
    }

    public JmDNSImpl getDns() {
        return this._jmDNSImpl;
    }
}
