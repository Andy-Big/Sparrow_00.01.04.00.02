package javax.jmdns.impl.tasks.resolver;

import java.io.IOException;
import java.util.Timer;
import javax.jmdns.impl.DNSOutgoing;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.tasks.DNSTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes2.dex */
public abstract class DNSResolverTask extends DNSTask {
    private static Logger logger = LoggerFactory.getLogger(DNSResolverTask.class.getName());
    protected int _count;

    protected abstract DNSOutgoing addAnswers(DNSOutgoing dNSOutgoing) throws IOException;

    protected abstract DNSOutgoing addQuestions(DNSOutgoing dNSOutgoing) throws IOException;

    protected abstract String description();

    public DNSResolverTask(JmDNSImpl jmDNSImpl) {
        super(jmDNSImpl);
        this._count = 0;
    }

    @Override // javax.jmdns.impl.tasks.DNSTask
    public String toString() {
        return super.toString() + " count: " + this._count;
    }

    @Override // javax.jmdns.impl.tasks.DNSTask
    public void start(Timer timer) {
        if (getDns().isCanceling() || getDns().isCanceled()) {
            return;
        }
        timer.schedule(this, 225L, 225L);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            if (!getDns().isCanceling() && !getDns().isCanceled()) {
                int i = this._count;
                this._count = i + 1;
                if (i < 3) {
                    logger.debug("{}.run() JmDNS {}", getName(), description());
                    DNSOutgoing addQuestions = addQuestions(new DNSOutgoing(0));
                    if (getDns().isAnnounced()) {
                        addQuestions = addAnswers(addQuestions);
                    }
                    if (addQuestions.isEmpty()) {
                        return;
                    }
                    getDns().send(addQuestions);
                    return;
                }
                cancel();
                return;
            }
            cancel();
        } catch (Throwable th) {
            Logger logger2 = logger;
            logger2.warn(getName() + ".run() exception ", th);
            getDns().recover();
        }
    }
}
