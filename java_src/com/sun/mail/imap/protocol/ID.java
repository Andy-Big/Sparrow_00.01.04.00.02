package com.sun.mail.imap.protocol;

import com.sun.mail.iap.Argument;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class ID {
    private Map<String, String> serverParams;

    public ID(Response response) throws ProtocolException {
        this.serverParams = null;
        response.skipSpaces();
        byte peekByte = response.peekByte();
        if (peekByte == 78 || peekByte == 110) {
            return;
        }
        if (peekByte != 40) {
            throw new ProtocolException("Missing '(' at start of ID");
        }
        this.serverParams = new HashMap();
        String[] readStringList = response.readStringList();
        if (readStringList != null) {
            for (int i = 0; i < readStringList.length; i += 2) {
                String str = readStringList[i];
                if (str == null) {
                    throw new ProtocolException("ID field name null");
                }
                int i2 = i + 1;
                if (i2 >= readStringList.length) {
                    throw new ProtocolException("ID field without value: " + str);
                }
                this.serverParams.put(str, readStringList[i2]);
            }
        }
        this.serverParams = Collections.unmodifiableMap(this.serverParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> getServerParams() {
        return this.serverParams;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Argument getArgumentList(Map<String, String> map) {
        Argument argument = new Argument();
        if (map == null) {
            argument.writeAtom("NIL");
            return argument;
        }
        Argument argument2 = new Argument();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            argument2.writeNString(entry.getKey());
            argument2.writeNString(entry.getValue());
        }
        argument.writeArgument(argument2);
        return argument;
    }
}
