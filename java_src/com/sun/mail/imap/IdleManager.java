package com.sun.mail.imap;

import com.sun.mail.util.MailLogger;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
/* loaded from: classes2.dex */
public class IdleManager {
    private Executor es;
    private MailLogger logger;
    private volatile boolean running;
    private volatile boolean die = false;
    private Queue<IMAPFolder> toWatch = new ConcurrentLinkedQueue();
    private Queue<IMAPFolder> toAbort = new ConcurrentLinkedQueue();
    private Selector selector = Selector.open();

    public IdleManager(Session session, Executor executor) throws IOException {
        this.es = executor;
        this.logger = new MailLogger(getClass(), "DEBUG IMAP", session.getDebug(), session.getDebugOut());
        executor.execute(new Runnable() { // from class: com.sun.mail.imap.IdleManager.1
            @Override // java.lang.Runnable
            public void run() {
                IdleManager.this.logger.fine("IdleManager select starting");
                try {
                    IdleManager.this.running = true;
                    IdleManager.this.select();
                } finally {
                    IdleManager.this.running = false;
                    IdleManager.this.logger.fine("IdleManager select terminating");
                }
            }
        });
    }

    public boolean isRunning() {
        return this.running;
    }

    public void watch(Folder folder) throws MessagingException {
        if (this.die) {
            throw new MessagingException("IdleManager is not running");
        }
        if (!(folder instanceof IMAPFolder)) {
            throw new MessagingException("Can only watch IMAP folders");
        }
        IMAPFolder iMAPFolder = (IMAPFolder) folder;
        if (iMAPFolder.getChannel() == null) {
            if (folder.isOpen()) {
                throw new MessagingException("Folder is not using SocketChannels");
            }
            throw new MessagingException("Folder is not open");
        }
        if (this.logger.isLoggable(Level.FINEST)) {
            this.logger.log(Level.FINEST, "IdleManager watching {0}", folderName(iMAPFolder));
        }
        int i = 0;
        while (!iMAPFolder.startIdle(this)) {
            if (this.logger.isLoggable(Level.FINEST)) {
                this.logger.log(Level.FINEST, "IdleManager.watch startIdle failed for {0}", folderName(iMAPFolder));
            }
            i++;
        }
        if (this.logger.isLoggable(Level.FINEST)) {
            if (i > 0) {
                MailLogger mailLogger = this.logger;
                Level level = Level.FINEST;
                mailLogger.log(level, "IdleManager.watch startIdle succeeded for {0} after " + i + " tries", folderName(iMAPFolder));
            } else {
                this.logger.log(Level.FINEST, "IdleManager.watch startIdle succeeded for {0}", folderName(iMAPFolder));
            }
        }
        synchronized (this) {
            this.toWatch.add(iMAPFolder);
            this.selector.wakeup();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestAbort(IMAPFolder iMAPFolder) {
        this.toAbort.add(iMAPFolder);
        this.selector.wakeup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void select() {
        this.die = false;
        while (!this.die) {
            try {
                try {
                    try {
                        try {
                            watchAll();
                            this.logger.finest("IdleManager waiting...");
                            int select = this.selector.select();
                            if (this.logger.isLoggable(Level.FINEST)) {
                                this.logger.log(Level.FINEST, "IdleManager selected {0} channels", Integer.valueOf(select));
                            }
                            if (this.die || Thread.currentThread().isInterrupted()) {
                                break;
                            }
                            while (true) {
                                processKeys();
                                if (this.selector.selectNow() > 0 || !this.toAbort.isEmpty()) {
                                }
                            }
                        } catch (IOException e) {
                            this.logger.log(Level.FINEST, "IdleManager got I/O exception", (Throwable) e);
                            this.die = true;
                            this.logger.finest("IdleManager unwatchAll");
                            try {
                                unwatchAll();
                                this.selector.close();
                            } catch (IOException e2) {
                                e = e2;
                                this.logger.log(Level.FINEST, "IdleManager unwatch exception", (Throwable) e);
                                this.logger.fine("IdleManager exiting");
                            }
                        }
                    } catch (Exception e3) {
                        this.logger.log(Level.FINEST, "IdleManager got exception", (Throwable) e3);
                        this.die = true;
                        this.logger.finest("IdleManager unwatchAll");
                        try {
                            unwatchAll();
                            this.selector.close();
                        } catch (IOException e4) {
                            e = e4;
                            this.logger.log(Level.FINEST, "IdleManager unwatch exception", (Throwable) e);
                            this.logger.fine("IdleManager exiting");
                        }
                    }
                } catch (InterruptedIOException e5) {
                    this.logger.log(Level.FINEST, "IdleManager interrupted", (Throwable) e5);
                    this.die = true;
                    this.logger.finest("IdleManager unwatchAll");
                    try {
                        unwatchAll();
                        this.selector.close();
                    } catch (IOException e6) {
                        e = e6;
                        this.logger.log(Level.FINEST, "IdleManager unwatch exception", (Throwable) e);
                        this.logger.fine("IdleManager exiting");
                    }
                }
            } catch (Throwable th) {
                this.die = true;
                this.logger.finest("IdleManager unwatchAll");
                try {
                    unwatchAll();
                    this.selector.close();
                } catch (IOException e7) {
                    this.logger.log(Level.FINEST, "IdleManager unwatch exception", (Throwable) e7);
                }
                this.logger.fine("IdleManager exiting");
                throw th;
            }
        }
        this.die = true;
        this.logger.finest("IdleManager unwatchAll");
        try {
            unwatchAll();
            this.selector.close();
        } catch (IOException e8) {
            e = e8;
            this.logger.log(Level.FINEST, "IdleManager unwatch exception", (Throwable) e);
            this.logger.fine("IdleManager exiting");
        }
        this.logger.fine("IdleManager exiting");
    }

    private void watchAll() {
        while (true) {
            IMAPFolder poll = this.toWatch.poll();
            if (poll == null) {
                return;
            }
            if (this.logger.isLoggable(Level.FINEST)) {
                this.logger.log(Level.FINEST, "IdleManager adding {0} to selector", folderName(poll));
            }
            try {
                SocketChannel channel = poll.getChannel();
                if (channel != null) {
                    channel.configureBlocking(false);
                    channel.register(this.selector, 1, poll);
                }
            } catch (IOException e) {
                this.logger.log(Level.FINEST, "IdleManager can't register folder", (Throwable) e);
            } catch (CancelledKeyException e2) {
                this.logger.log(Level.FINEST, "IdleManager can't register folder", (Throwable) e2);
            }
        }
    }

    private void processKeys() throws IOException {
        Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            next.cancel();
            IMAPFolder iMAPFolder = (IMAPFolder) next.attachment();
            if (this.logger.isLoggable(Level.FINEST)) {
                this.logger.log(Level.FINEST, "IdleManager selected folder: {0}", folderName(iMAPFolder));
            }
            next.channel().configureBlocking(true);
            try {
                if (iMAPFolder.handleIdle(false)) {
                    if (this.logger.isLoggable(Level.FINEST)) {
                        this.logger.log(Level.FINEST, "IdleManager continue watching folder {0}", folderName(iMAPFolder));
                    }
                    this.toWatch.add(iMAPFolder);
                } else if (this.logger.isLoggable(Level.FINEST)) {
                    this.logger.log(Level.FINEST, "IdleManager done watching folder {0}", folderName(iMAPFolder));
                }
            } catch (MessagingException e) {
                MailLogger mailLogger = this.logger;
                Level level = Level.FINEST;
                mailLogger.log(level, "IdleManager got exception for folder: " + folderName(iMAPFolder), (Throwable) e);
            }
        }
        while (true) {
            final IMAPFolder poll = this.toAbort.poll();
            if (poll == null) {
                return;
            }
            if (this.logger.isLoggable(Level.FINEST)) {
                this.logger.log(Level.FINEST, "IdleManager aborting IDLE for folder: {0}", folderName(poll));
            }
            SocketChannel channel = poll.getChannel();
            if (channel != null) {
                SelectionKey keyFor = channel.keyFor(this.selector);
                if (keyFor != null) {
                    keyFor.cancel();
                }
                channel.configureBlocking(true);
                Socket socket = channel.socket();
                if (socket != null && socket.getSoTimeout() > 0) {
                    this.logger.finest("IdleManager requesting DONE with timeout");
                    this.toWatch.remove(poll);
                    this.es.execute(new Runnable() { // from class: com.sun.mail.imap.IdleManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            poll.idleAbortWait();
                        }
                    });
                } else {
                    poll.idleAbort();
                    this.toWatch.add(poll);
                }
            }
        }
    }

    private void unwatchAll() {
        for (SelectionKey selectionKey : this.selector.keys()) {
            selectionKey.cancel();
            IMAPFolder iMAPFolder = (IMAPFolder) selectionKey.attachment();
            if (this.logger.isLoggable(Level.FINEST)) {
                this.logger.log(Level.FINEST, "IdleManager no longer watching folder: {0}", folderName(iMAPFolder));
            }
            try {
                selectionKey.channel().configureBlocking(true);
                iMAPFolder.idleAbortWait();
            } catch (IOException e) {
                MailLogger mailLogger = this.logger;
                Level level = Level.FINEST;
                mailLogger.log(level, "IdleManager exception while aborting idle for folder: " + folderName(iMAPFolder), (Throwable) e);
            }
        }
        while (true) {
            IMAPFolder poll = this.toWatch.poll();
            if (poll == null) {
                return;
            }
            if (this.logger.isLoggable(Level.FINEST)) {
                this.logger.log(Level.FINEST, "IdleManager aborting IDLE for unwatched folder: {0}", folderName(poll));
            }
            SocketChannel channel = poll.getChannel();
            if (channel != null) {
                try {
                    channel.configureBlocking(true);
                    poll.idleAbortWait();
                } catch (IOException e2) {
                    MailLogger mailLogger2 = this.logger;
                    Level level2 = Level.FINEST;
                    mailLogger2.log(level2, "IdleManager exception while aborting idle for folder: " + folderName(poll), (Throwable) e2);
                }
            }
        }
    }

    public synchronized void stop() {
        this.die = true;
        this.logger.fine("IdleManager stopping");
        this.selector.wakeup();
    }

    private static String folderName(Folder folder) {
        try {
            return folder.getURLName().toString();
        } catch (MessagingException unused) {
            return folder.getStore().toString() + "/" + folder.toString();
        }
    }
}
