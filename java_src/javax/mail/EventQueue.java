package javax.mail;

import java.util.EventListener;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import javax.mail.event.MailEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class EventQueue implements Runnable {
    private static WeakHashMap<ClassLoader, EventQueue> appq;
    private Executor executor;
    private volatile BlockingQueue<QueueElement> q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TerminatorEvent extends MailEvent {
        private static final long serialVersionUID = -2481895000841664111L;

        TerminatorEvent() {
            super(new Object());
        }

        @Override // javax.mail.event.MailEvent
        public void dispatch(Object obj) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class QueueElement {
        MailEvent event;
        Vector<? extends EventListener> vector;

        QueueElement(MailEvent mailEvent, Vector<? extends EventListener> vector) {
            this.event = null;
            this.vector = null;
            this.event = mailEvent;
            this.vector = vector;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventQueue(Executor executor) {
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void enqueue(MailEvent mailEvent, Vector<? extends EventListener> vector) {
        if (this.q == null) {
            this.q = new LinkedBlockingQueue();
            if (this.executor != null) {
                this.executor.execute(this);
            } else {
                Thread thread = new Thread(this, "Jakarta-Mail-EventQueue");
                thread.setDaemon(true);
                thread.start();
            }
        }
        this.q.add(new QueueElement(mailEvent, vector));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void terminateQueue() {
        if (this.q != null) {
            Vector vector = new Vector();
            vector.setSize(1);
            this.q.add(new QueueElement(new TerminatorEvent(), vector));
            this.q = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized EventQueue getApplicationEventQueue(Executor executor) {
        EventQueue eventQueue;
        synchronized (EventQueue.class) {
            ClassLoader contextClassLoader = Session.getContextClassLoader();
            if (appq == null) {
                appq = new WeakHashMap<>();
            }
            eventQueue = appq.get(contextClassLoader);
            if (eventQueue == null) {
                eventQueue = new EventQueue(executor);
                appq.put(contextClassLoader, eventQueue);
            }
        }
        return eventQueue;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016 A[Catch: all -> 0x001e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {InterruptedException -> 0x0027, blocks: (B:5:0x0005, B:6:0x0010, B:8:0x0016), top: B:17:0x0005 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r5 = this;
            java.util.concurrent.BlockingQueue<javax.mail.EventQueue$QueueElement> r0 = r5.q
            if (r0 != 0) goto L5
            return
        L5:
            java.lang.Object r1 = r0.take()     // Catch: java.lang.InterruptedException -> L27
            javax.mail.EventQueue$QueueElement r1 = (javax.mail.EventQueue.QueueElement) r1     // Catch: java.lang.InterruptedException -> L27
            javax.mail.event.MailEvent r2 = r1.event     // Catch: java.lang.InterruptedException -> L27
            java.util.Vector<? extends java.util.EventListener> r1 = r1.vector     // Catch: java.lang.InterruptedException -> L27
            r3 = 0
        L10:
            int r4 = r1.size()     // Catch: java.lang.InterruptedException -> L27
            if (r3 >= r4) goto L5
            java.lang.Object r4 = r1.elementAt(r3)     // Catch: java.lang.Throwable -> L1e
            r2.dispatch(r4)     // Catch: java.lang.Throwable -> L1e
            goto L24
        L1e:
            r4 = move-exception
            boolean r4 = r4 instanceof java.lang.InterruptedException     // Catch: java.lang.InterruptedException -> L27
            if (r4 == 0) goto L24
            goto L27
        L24:
            int r3 = r3 + 1
            goto L10
        L27:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.EventQueue.run():void");
    }
}
