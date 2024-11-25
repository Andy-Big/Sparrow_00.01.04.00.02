package javax.jmdns.impl.tasks.resolver;

import java.io.IOException;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.DNSOutgoing;
import javax.jmdns.impl.DNSQuestion;
import javax.jmdns.impl.DNSRecord;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.constants.DNSConstants;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
/* loaded from: classes2.dex */
public class ServiceResolver extends DNSResolverTask {
    private final String _type;

    @Override // javax.jmdns.impl.tasks.resolver.DNSResolverTask
    protected String description() {
        return "querying service";
    }

    public ServiceResolver(JmDNSImpl jmDNSImpl, String str) {
        super(jmDNSImpl);
        this._type = str;
    }

    @Override // javax.jmdns.impl.tasks.DNSTask
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceResolver(");
        sb.append(getDns() != null ? getDns().getName() : "");
        sb.append(")");
        return sb.toString();
    }

    @Override // javax.jmdns.impl.tasks.resolver.DNSResolverTask
    protected DNSOutgoing addAnswers(DNSOutgoing dNSOutgoing) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        for (ServiceInfo serviceInfo : getDns().getServices().values()) {
            dNSOutgoing = addAnswer(dNSOutgoing, new DNSRecord.Pointer(serviceInfo.getType(), DNSRecordClass.CLASS_IN, false, DNSConstants.DNS_TTL, serviceInfo.getQualifiedName()), currentTimeMillis);
        }
        return dNSOutgoing;
    }

    @Override // javax.jmdns.impl.tasks.resolver.DNSResolverTask
    protected DNSOutgoing addQuestions(DNSOutgoing dNSOutgoing) throws IOException {
        return addQuestion(dNSOutgoing, DNSQuestion.newQuestion(this._type, DNSRecordType.TYPE_PTR, DNSRecordClass.CLASS_IN, false));
    }
}
