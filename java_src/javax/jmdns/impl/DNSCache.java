package javax.jmdns.impl;

import com.rigol.util.PackageUtilKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes2.dex */
public class DNSCache extends ConcurrentHashMap<String, List<DNSEntry>> {
    private static Logger logger = LoggerFactory.getLogger(DNSCache.class.getName());
    private static final long serialVersionUID = 3024739453186759259L;

    public DNSCache() {
        this(1024);
    }

    public DNSCache(DNSCache dNSCache) {
        this(dNSCache != null ? dNSCache.size() : 1024);
        if (dNSCache != null) {
            putAll(dNSCache);
        }
    }

    public DNSCache(int i) {
        super(i);
    }

    @Override // java.util.AbstractMap
    protected Object clone() throws CloneNotSupportedException {
        return new DNSCache(this);
    }

    public Collection<DNSEntry> allValues() {
        ArrayList arrayList = new ArrayList();
        for (List<DNSEntry> list : values()) {
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    public Collection<? extends DNSEntry> getDNSEntryList(String str) {
        ArrayList arrayList;
        Collection<? extends DNSEntry> _getDNSEntryList = _getDNSEntryList(str);
        if (_getDNSEntryList != null) {
            synchronized (_getDNSEntryList) {
                arrayList = new ArrayList(_getDNSEntryList);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    private Collection<? extends DNSEntry> _getDNSEntryList(String str) {
        return get(str != null ? str.toLowerCase() : null);
    }

    public DNSEntry getDNSEntry(DNSEntry dNSEntry) {
        Collection<? extends DNSEntry> _getDNSEntryList;
        DNSEntry dNSEntry2 = null;
        if (dNSEntry != null && (_getDNSEntryList = _getDNSEntryList(dNSEntry.getKey())) != null) {
            synchronized (_getDNSEntryList) {
                Iterator<? extends DNSEntry> it = _getDNSEntryList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DNSEntry next = it.next();
                    if (next.isSameEntry(dNSEntry)) {
                        dNSEntry2 = next;
                        break;
                    }
                }
            }
        }
        return dNSEntry2;
    }

    public DNSEntry getDNSEntry(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass) {
        Collection<? extends DNSEntry> _getDNSEntryList = _getDNSEntryList(str);
        DNSEntry dNSEntry = null;
        if (_getDNSEntryList != null) {
            synchronized (_getDNSEntryList) {
                Iterator<? extends DNSEntry> it = _getDNSEntryList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DNSEntry next = it.next();
                    if (next.matchRecordType(dNSRecordType) && next.matchRecordClass(dNSRecordClass)) {
                        dNSEntry = next;
                        break;
                    }
                }
            }
        }
        return dNSEntry;
    }

    public Collection<? extends DNSEntry> getDNSEntryList(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass) {
        ArrayList arrayList;
        Collection<? extends DNSEntry> _getDNSEntryList = _getDNSEntryList(str);
        if (_getDNSEntryList != null) {
            synchronized (_getDNSEntryList) {
                arrayList = new ArrayList(_getDNSEntryList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    DNSEntry dNSEntry = (DNSEntry) it.next();
                    if (!dNSEntry.matchRecordType(dNSRecordType) || !dNSEntry.matchRecordClass(dNSRecordClass)) {
                        it.remove();
                    }
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public boolean addDNSEntry(DNSEntry dNSEntry) {
        if (dNSEntry != null) {
            List<DNSEntry> list = get(dNSEntry.getKey());
            if (list == null) {
                putIfAbsent(dNSEntry.getKey(), new ArrayList());
                list = get(dNSEntry.getKey());
            }
            synchronized (list) {
                list.add(dNSEntry);
            }
            return true;
        }
        return false;
    }

    public boolean removeDNSEntry(DNSEntry dNSEntry) {
        boolean z = false;
        if (dNSEntry != null) {
            List<DNSEntry> list = get(dNSEntry.getKey());
            if (list != null) {
                synchronized (list) {
                    z = list.remove(dNSEntry);
                }
            }
            if (z && list.isEmpty()) {
                remove(dNSEntry.getKey());
            }
        }
        return z;
    }

    public boolean replaceDNSEntry(DNSEntry dNSEntry, DNSEntry dNSEntry2) {
        if (dNSEntry == null || dNSEntry2 == null || !dNSEntry.getKey().equals(dNSEntry2.getKey())) {
            return false;
        }
        List<DNSEntry> list = get(dNSEntry.getKey());
        if (list == null) {
            putIfAbsent(dNSEntry.getKey(), new ArrayList());
            list = get(dNSEntry.getKey());
        }
        synchronized (list) {
            list.remove(dNSEntry2);
            list.add(dNSEntry);
        }
        return true;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap
    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder((int) PackageUtilKt.ERROR_PACKAGE_FILE_DOWNLOAD);
        sb.append("\n\t---- cache ----");
        for (Map.Entry<String, List<DNSEntry>> entry : entrySet()) {
            sb.append("\n\n\t\tname '");
            sb.append(entry.getKey());
            sb.append('\'');
            List<DNSEntry> value = entry.getValue();
            if (value != null && !value.isEmpty()) {
                synchronized (value) {
                    for (DNSEntry dNSEntry : value) {
                        sb.append("\n\t\t\t");
                        sb.append(dNSEntry.toString());
                    }
                }
            } else {
                sb.append(" : no entries");
            }
        }
        return sb.toString();
    }

    public void logCachedContent() {
        if (logger.isTraceEnabled()) {
            logger.trace("Cached DNSEntries: {}", toString());
        }
    }
}
