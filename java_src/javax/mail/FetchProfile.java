package javax.mail;

import java.util.Vector;
/* loaded from: classes2.dex */
public class FetchProfile {
    private Vector<Item> specials = null;
    private Vector<String> headers = null;

    /* loaded from: classes2.dex */
    public static class Item {
        private String name;
        public static final Item ENVELOPE = new Item("ENVELOPE");
        public static final Item CONTENT_INFO = new Item("CONTENT_INFO");
        public static final Item SIZE = new Item("SIZE");
        public static final Item FLAGS = new Item("FLAGS");

        /* JADX INFO: Access modifiers changed from: protected */
        public Item(String str) {
            this.name = str;
        }

        public String toString() {
            return getClass().getName() + "[" + this.name + "]";
        }
    }

    public void add(Item item) {
        if (this.specials == null) {
            this.specials = new Vector<>();
        }
        this.specials.addElement(item);
    }

    public void add(String str) {
        if (this.headers == null) {
            this.headers = new Vector<>();
        }
        this.headers.addElement(str);
    }

    public boolean contains(Item item) {
        Vector<Item> vector = this.specials;
        return vector != null && vector.contains(item);
    }

    public boolean contains(String str) {
        Vector<String> vector = this.headers;
        return vector != null && vector.contains(str);
    }

    public Item[] getItems() {
        Vector<Item> vector = this.specials;
        if (vector == null) {
            return new Item[0];
        }
        Item[] itemArr = new Item[vector.size()];
        this.specials.copyInto(itemArr);
        return itemArr;
    }

    public String[] getHeaderNames() {
        Vector<String> vector = this.headers;
        if (vector == null) {
            return new String[0];
        }
        String[] strArr = new String[vector.size()];
        this.headers.copyInto(strArr);
        return strArr;
    }
}
