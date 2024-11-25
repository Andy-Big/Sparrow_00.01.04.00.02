package javax.jmdns.impl;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import javax.jmdns.NetworkTopologyDiscovery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes2.dex */
public class NetworkTopologyDiscoveryImpl implements NetworkTopologyDiscovery {
    private static final Logger logger = LoggerFactory.getLogger(NetworkTopologyDiscoveryImpl.class.getName());

    @Override // javax.jmdns.NetworkTopologyDiscovery
    public void lockInetAddress(InetAddress inetAddress) {
    }

    @Override // javax.jmdns.NetworkTopologyDiscovery
    public void unlockInetAddress(InetAddress inetAddress) {
    }

    @Override // javax.jmdns.NetworkTopologyDiscovery
    public InetAddress[] getInetAddresses() {
        HashSet hashSet = new HashSet();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    logger.trace("Found NetworkInterface/InetAddress: {} -- {}", nextElement, nextElement2);
                    if (useInetAddress(nextElement, nextElement2)) {
                        hashSet.add(nextElement2);
                    }
                }
            }
        } catch (SocketException e) {
            Logger logger2 = logger;
            logger2.warn("Error while fetching network interfaces addresses: " + e);
        }
        return (InetAddress[]) hashSet.toArray(new InetAddress[hashSet.size()]);
    }

    @Override // javax.jmdns.NetworkTopologyDiscovery
    public boolean useInetAddress(NetworkInterface networkInterface, InetAddress inetAddress) {
        try {
            if (networkInterface.isUp() && networkInterface.supportsMulticast()) {
                return !networkInterface.isLoopback();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
