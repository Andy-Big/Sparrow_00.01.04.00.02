package javax.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;
/* loaded from: classes2.dex */
public abstract class Transport extends Service {
    private volatile Vector<TransportListener> transportListeners;

    public abstract void sendMessage(Message message, Address[] addressArr) throws MessagingException;

    public Transport(Session session, URLName uRLName) {
        super(session, uRLName);
        this.transportListeners = null;
    }

    public static void send(Message message) throws MessagingException {
        message.saveChanges();
        send0(message, message.getAllRecipients(), null, null);
    }

    public static void send(Message message, Address[] addressArr) throws MessagingException {
        message.saveChanges();
        send0(message, addressArr, null, null);
    }

    public static void send(Message message, String str, String str2) throws MessagingException {
        message.saveChanges();
        send0(message, message.getAllRecipients(), str, str2);
    }

    public static void send(Message message, Address[] addressArr, String str, String str2) throws MessagingException {
        message.saveChanges();
        send0(message, addressArr, str, str2);
    }

    private static void send0(Message message, Address[] addressArr, String str, String str2) throws MessagingException {
        Address[] addressArr2;
        Address[] addressArr3;
        Transport transport;
        if (addressArr == null || addressArr.length == 0) {
            throw new SendFailedException("No recipient addresses");
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < addressArr.length; i++) {
            if (hashMap.containsKey(addressArr[i].getType())) {
                ((List) hashMap.get(addressArr[i].getType())).add(addressArr[i]);
            } else {
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(addressArr[i]);
                hashMap.put(addressArr[i].getType(), arrayList4);
            }
        }
        int size = hashMap.size();
        if (size == 0) {
            throw new SendFailedException("No recipient addresses");
        }
        Address[] addressArr4 = null;
        Session defaultInstance = message.session != null ? message.session : Session.getDefaultInstance(System.getProperties(), null);
        if (size == 1) {
            transport = defaultInstance.getTransport(addressArr[0]);
            try {
                if (str != null) {
                    transport.connect(str, str2);
                } else {
                    transport.connect();
                }
                transport.sendMessage(message, addressArr);
                return;
            } finally {
            }
        }
        boolean z = false;
        SendFailedException sendFailedException = null;
        for (List list : hashMap.values()) {
            int size2 = list.size();
            Address[] addressArr5 = new Address[size2];
            list.toArray(addressArr5);
            transport = defaultInstance.getTransport(addressArr5[0]);
            if (transport == null) {
                for (int i2 = 0; i2 < size2; i2++) {
                    arrayList.add(addressArr5[i2]);
                }
            } else {
                try {
                    try {
                        transport.connect();
                        transport.sendMessage(message, addressArr5);
                    } catch (SendFailedException e) {
                        if (sendFailedException == null) {
                            sendFailedException = e;
                        } else {
                            sendFailedException.setNextException(e);
                        }
                        Address[] invalidAddresses = e.getInvalidAddresses();
                        if (invalidAddresses != null) {
                            for (Address address : invalidAddresses) {
                                arrayList.add(address);
                            }
                        }
                        Address[] validSentAddresses = e.getValidSentAddresses();
                        if (validSentAddresses != null) {
                            for (Address address2 : validSentAddresses) {
                                arrayList2.add(address2);
                            }
                        }
                        Address[] validUnsentAddresses = e.getValidUnsentAddresses();
                        if (validUnsentAddresses != null) {
                            for (Address address3 : validUnsentAddresses) {
                                arrayList3.add(address3);
                            }
                        }
                        transport.close();
                        z = true;
                    } catch (MessagingException e2) {
                        if (sendFailedException == null) {
                            sendFailedException = e2;
                        } else {
                            sendFailedException.setNextException(e2);
                        }
                        transport.close();
                        z = true;
                    }
                } finally {
                }
            }
        }
        if (!z && arrayList.size() == 0 && arrayList3.size() == 0) {
            return;
        }
        if (arrayList2.size() > 0) {
            Address[] addressArr6 = new Address[arrayList2.size()];
            arrayList2.toArray(addressArr6);
            addressArr2 = addressArr6;
        } else {
            addressArr2 = null;
        }
        if (arrayList3.size() > 0) {
            Address[] addressArr7 = new Address[arrayList3.size()];
            arrayList3.toArray(addressArr7);
            addressArr3 = addressArr7;
        } else {
            addressArr3 = null;
        }
        if (arrayList.size() > 0) {
            addressArr4 = new Address[arrayList.size()];
            arrayList.toArray(addressArr4);
        }
        throw new SendFailedException("Sending failed", sendFailedException, addressArr2, addressArr3, addressArr4);
    }

    public synchronized void addTransportListener(TransportListener transportListener) {
        if (this.transportListeners == null) {
            this.transportListeners = new Vector<>();
        }
        this.transportListeners.addElement(transportListener);
    }

    public synchronized void removeTransportListener(TransportListener transportListener) {
        if (this.transportListeners != null) {
            this.transportListeners.removeElement(transportListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyTransportListeners(int i, Address[] addressArr, Address[] addressArr2, Address[] addressArr3, Message message) {
        if (this.transportListeners == null) {
            return;
        }
        queueEvent(new TransportEvent(this, i, addressArr, addressArr2, addressArr3, message), this.transportListeners);
    }
}
