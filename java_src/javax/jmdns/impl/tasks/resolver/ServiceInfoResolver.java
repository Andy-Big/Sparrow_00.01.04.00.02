package javax.jmdns.impl.tasks.resolver;

import java.io.IOException;
import java.util.Iterator;
import javax.jmdns.impl.DNSEntry;
import javax.jmdns.impl.DNSOutgoing;
import javax.jmdns.impl.DNSQuestion;
import javax.jmdns.impl.DNSRecord;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.ServiceInfoImpl;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
/* loaded from: classes2.dex */
public class ServiceInfoResolver extends DNSResolverTask {
    private final ServiceInfoImpl _info;

    public ServiceInfoResolver(JmDNSImpl jmDNSImpl, ServiceInfoImpl serviceInfoImpl) {
        super(jmDNSImpl);
        this._info = serviceInfoImpl;
        serviceInfoImpl.setDns(getDns());
        getDns().addListener(serviceInfoImpl, DNSQuestion.newQuestion(serviceInfoImpl.getQualifiedName(), DNSRecordType.TYPE_ANY, DNSRecordClass.CLASS_IN, false));
    }

    @Override // javax.jmdns.impl.tasks.DNSTask
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceInfoResolver(");
        sb.append(getDns() != null ? getDns().getName() : "");
        sb.append(")");
        return sb.toString();
    }

    @Override // java.util.TimerTask
    public boolean cancel() {
        boolean cancel = super.cancel();
        if (!this._info.isPersistent()) {
            getDns().removeListener(this._info);
        }
        return cancel;
    }

    @Override // javax.jmdns.impl.tasks.resolver.DNSResolverTask
    protected DNSOutgoing addAnswers(DNSOutgoing dNSOutgoing) throws IOException {
        if (!this._info.hasData()) {
            long currentTimeMillis = System.currentTimeMillis();
            dNSOutgoing = addAnswer(addAnswer(dNSOutgoing, (DNSRecord) getDns().getCache().getDNSEntry(this._info.getQualifiedName(), DNSRecordType.TYPE_SRV, DNSRecordClass.CLASS_IN), currentTimeMillis), (DNSRecord) getDns().getCache().getDNSEntry(this._info.getQualifiedName(), DNSRecordType.TYPE_TXT, DNSRecordClass.CLASS_IN), currentTimeMillis);
            if (this._info.getServer().length() > 0) {
                Iterator<? extends DNSEntry> it = getDns().getCache().getDNSEntryList(this._info.getServer(), DNSRecordType.TYPE_A, DNSRecordClass.CLASS_IN).iterator();
                while (it.hasNext()) {
                    dNSOutgoing = addAnswer(dNSOutgoing, (DNSRecord) it.next(), currentTimeMillis);
                }
                Iterator<? extends DNSEntry> it2 = getDns().getCache().getDNSEntryList(this._info.getServer(), DNSRecordType.TYPE_AAAA, DNSRecordClass.CLASS_IN).iterator();
                while (it2.hasNext()) {
                    dNSOutgoing = addAnswer(dNSOutgoing, (DNSRecord) it2.next(), currentTimeMillis);
                }
            }
        }
        return dNSOutgoing;
    }

    @Override // javax.jmdns.impl.tasks.resolver.DNSResolverTask
    protected DNSOutgoing addQuestions(DNSOutgoing dNSOutgoing) throws IOException {
        if (this._info.hasData()) {
            return dNSOutgoing;
        }
        DNSOutgoing addQuestion = addQuestion(addQuestion(dNSOutgoing, DNSQuestion.newQuestion(this._info.getQualifiedName(), DNSRecordType.TYPE_SRV, DNSRecordClass.CLASS_IN, false)), DNSQuestion.newQuestion(this._info.getQualifiedName(), DNSRecordType.TYPE_TXT, DNSRecordClass.CLASS_IN, false));
        return this._info.getServer().length() > 0 ? addQuestion(addQuestion(addQuestion, DNSQuestion.newQuestion(this._info.getServer(), DNSRecordType.TYPE_A, DNSRecordClass.CLASS_IN, false)), DNSQuestion.newQuestion(this._info.getServer(), DNSRecordType.TYPE_AAAA, DNSRecordClass.CLASS_IN, false)) : addQuestion;
    }

    @Override // javax.jmdns.impl.tasks.resolver.DNSResolverTask
    protected String description() {
        StringBuilder sb = new StringBuilder();
        sb.append("querying service info: ");
        ServiceInfoImpl serviceInfoImpl = this._info;
        sb.append(serviceInfoImpl != null ? serviceInfoImpl.getQualifiedName() : "null");
        return sb.toString();
    }
}
