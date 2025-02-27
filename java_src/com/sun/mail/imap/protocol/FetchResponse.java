package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.util.ASCIIUtility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class FetchResponse extends IMAPResponse {
    private static final char[] HEADER = {'.', 'H', 'E', 'A', 'D', 'E', 'R'};
    private static final char[] TEXT = {'.', 'T', 'E', 'X', 'T'};
    private Map<String, Object> extensionItems;
    private final FetchItem[] fitems;
    private Item[] items;

    public FetchResponse(Protocol protocol) throws IOException, ProtocolException {
        super(protocol);
        this.fitems = null;
        parse();
    }

    public FetchResponse(IMAPResponse iMAPResponse) throws IOException, ProtocolException {
        this(iMAPResponse, null);
    }

    public FetchResponse(IMAPResponse iMAPResponse, FetchItem[] fetchItemArr) throws IOException, ProtocolException {
        super(iMAPResponse);
        this.fitems = fetchItemArr;
        parse();
    }

    public int getItemCount() {
        return this.items.length;
    }

    public Item getItem(int i) {
        return this.items[i];
    }

    public <T extends Item> T getItem(Class<T> cls) {
        int i = 0;
        while (true) {
            Item[] itemArr = this.items;
            if (i >= itemArr.length) {
                return null;
            }
            if (cls.isInstance(itemArr[i])) {
                return cls.cast(this.items[i]);
            }
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T extends Item> T getItem(Response[] responseArr, int i, Class<T> cls) {
        if (responseArr == null) {
            return null;
        }
        for (int i2 = 0; i2 < responseArr.length; i2++) {
            if (responseArr[i2] != null && (responseArr[i2] instanceof FetchResponse) && ((FetchResponse) responseArr[i2]).getNumber() == i) {
                FetchResponse fetchResponse = (FetchResponse) responseArr[i2];
                int i3 = 0;
                while (true) {
                    Item[] itemArr = fetchResponse.items;
                    if (i3 < itemArr.length) {
                        if (cls.isInstance(itemArr[i3])) {
                            return cls.cast(fetchResponse.items[i3]);
                        }
                        i3++;
                    }
                }
            }
        }
        return null;
    }

    public static <T extends Item> List<T> getItems(Response[] responseArr, int i, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (responseArr == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < responseArr.length; i2++) {
            if (responseArr[i2] != null && (responseArr[i2] instanceof FetchResponse) && ((FetchResponse) responseArr[i2]).getNumber() == i) {
                FetchResponse fetchResponse = (FetchResponse) responseArr[i2];
                int i3 = 0;
                while (true) {
                    Item[] itemArr = fetchResponse.items;
                    if (i3 < itemArr.length) {
                        if (cls.isInstance(itemArr[i3])) {
                            arrayList.add(cls.cast(fetchResponse.items[i3]));
                        }
                        i3++;
                    }
                }
            }
        }
        return arrayList;
    }

    public Map<String, Object> getExtensionItems() {
        return this.extensionItems;
    }

    private void parse() throws ParsingException {
        if (!isNextNonSpace('(')) {
            throw new ParsingException("error in FETCH parsing, missing '(' at index " + this.index);
        }
        ArrayList arrayList = new ArrayList();
        skipSpaces();
        while (this.index < this.size) {
            Item parseItem = parseItem();
            if (parseItem != null) {
                arrayList.add(parseItem);
            } else if (!parseExtensionItem()) {
                throw new ParsingException("error in FETCH parsing, unrecognized item at index " + this.index + ", starts with \"" + next20() + "\"");
            }
            if (isNextNonSpace(')')) {
                this.items = (Item[]) arrayList.toArray(new Item[arrayList.size()]);
                return;
            }
        }
        throw new ParsingException("error in FETCH parsing, ran off end of buffer, size " + this.size);
    }

    private String next20() {
        if (this.index + 20 > this.size) {
            return ASCIIUtility.toString(this.buffer, this.index, this.size);
        }
        return ASCIIUtility.toString(this.buffer, this.index, this.index + 20) + "...";
    }

    private Item parseItem() throws ParsingException {
        byte b = this.buffer[this.index];
        if (b != 66) {
            if (b != 73) {
                if (b != 77) {
                    if (b != 82) {
                        if (b != 85) {
                            if (b != 98) {
                                if (b != 105) {
                                    if (b != 109) {
                                        if (b != 114) {
                                            if (b != 117) {
                                                if (b != 69) {
                                                    if (b != 70) {
                                                        if (b != 101) {
                                                            if (b != 102) {
                                                                return null;
                                                            }
                                                        }
                                                    }
                                                    if (match(FLAGS.name)) {
                                                        return new FLAGS(this);
                                                    }
                                                    return null;
                                                }
                                                if (match(ENVELOPE.name)) {
                                                    return new ENVELOPE(this);
                                                }
                                                return null;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (match(UID.name)) {
                            return new UID(this);
                        }
                        return null;
                    }
                    if (match(RFC822SIZE.name)) {
                        return new RFC822SIZE(this);
                    }
                    if (match(RFC822DATA.name)) {
                        boolean z = false;
                        if (match(HEADER)) {
                            z = true;
                        } else {
                            match(TEXT);
                        }
                        return new RFC822DATA(this, z);
                    }
                    return null;
                }
                if (match(MODSEQ.name)) {
                    return new MODSEQ(this);
                }
                return null;
            }
            if (match(INTERNALDATE.name)) {
                return new INTERNALDATE(this);
            }
            return null;
        }
        if (match(BODYSTRUCTURE.name)) {
            return new BODYSTRUCTURE(this);
        }
        if (match(BODY.name)) {
            if (this.buffer[this.index] == 91) {
                return new BODY(this);
            }
            return new BODYSTRUCTURE(this);
        }
        return null;
    }

    private boolean parseExtensionItem() throws ParsingException {
        if (this.fitems == null) {
            return false;
        }
        int i = 0;
        while (true) {
            FetchItem[] fetchItemArr = this.fitems;
            if (i >= fetchItemArr.length) {
                return false;
            }
            if (match(fetchItemArr[i].getName())) {
                if (this.extensionItems == null) {
                    this.extensionItems = new HashMap();
                }
                this.extensionItems.put(this.fitems[i].getName(), this.fitems[i].parseItem(this));
                return true;
            }
            i++;
        }
    }

    private boolean match(char[] cArr) {
        int length = cArr.length;
        int i = this.index;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            int i4 = i2 + 1;
            if (Character.toUpperCase((char) this.buffer[i]) != cArr[i2]) {
                return false;
            }
            i2 = i4;
            i = i3;
        }
        this.index += length;
        return true;
    }

    private boolean match(String str) {
        int length = str.length();
        int i = this.index;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            int i4 = i2 + 1;
            if (Character.toUpperCase((char) this.buffer[i]) != str.charAt(i2)) {
                return false;
            }
            i2 = i4;
            i = i3;
        }
        this.index += length;
        return true;
    }
}
