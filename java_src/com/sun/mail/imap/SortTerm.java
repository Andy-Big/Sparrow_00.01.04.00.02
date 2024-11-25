package com.sun.mail.imap;
/* loaded from: classes2.dex */
public final class SortTerm {
    public static final SortTerm ARRIVAL = new SortTerm("ARRIVAL");
    public static final SortTerm CC = new SortTerm("CC");
    public static final SortTerm DATE = new SortTerm("DATE");
    public static final SortTerm FROM = new SortTerm("FROM");
    public static final SortTerm REVERSE = new SortTerm("REVERSE");
    public static final SortTerm SIZE = new SortTerm("SIZE");
    public static final SortTerm SUBJECT = new SortTerm("SUBJECT");
    public static final SortTerm TO = new SortTerm("TO");
    private String term;

    private SortTerm(String str) {
        this.term = str;
    }

    public String toString() {
        return this.term;
    }
}
