package com.sun.mail.imap.protocol;

import java.util.ArrayList;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
public class UIDSet {
    public long end;
    public long start;

    public UIDSet() {
    }

    public UIDSet(long j, long j2) {
        this.start = j;
        this.end = j2;
    }

    public long size() {
        return (this.end - this.start) + 1;
    }

    public static UIDSet[] createUIDSets(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < jArr.length) {
            UIDSet uIDSet = new UIDSet();
            uIDSet.start = jArr[i];
            do {
                i++;
                if (i < jArr.length) {
                }
                int i2 = i - 1;
                uIDSet.end = jArr[i2];
                arrayList.add(uIDSet);
                i = i2 + 1;
            } while (jArr[i] == jArr[i - 1] + 1);
            int i22 = i - 1;
            uIDSet.end = jArr[i22];
            arrayList.add(uIDSet);
            i = i22 + 1;
        }
        return (UIDSet[]) arrayList.toArray(new UIDSet[arrayList.size()]);
    }

    public static UIDSet[] parseUIDSets(String str) {
        UIDSet uIDSet;
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",:", true);
        loop0: while (true) {
            uIDSet = null;
            while (stringTokenizer.hasMoreTokens()) {
                try {
                    String nextToken = stringTokenizer.nextToken();
                    if (nextToken.equals(",")) {
                        if (uIDSet != null) {
                            arrayList.add(uIDSet);
                        }
                    } else if (!nextToken.equals(":")) {
                        long parseLong = Long.parseLong(nextToken);
                        if (uIDSet != null) {
                            uIDSet.end = parseLong;
                        } else {
                            uIDSet = new UIDSet(parseLong, parseLong);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
            break loop0;
        }
        if (uIDSet != null) {
            arrayList.add(uIDSet);
        }
        return (UIDSet[]) arrayList.toArray(new UIDSet[arrayList.size()]);
    }

    public static String toString(UIDSet[] uIDSetArr) {
        if (uIDSetArr == null) {
            return null;
        }
        if (uIDSetArr.length == 0) {
            return "";
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int length = uIDSetArr.length;
        while (true) {
            long j = uIDSetArr[i].start;
            long j2 = uIDSetArr[i].end;
            if (j2 > j) {
                sb.append(j);
                sb.append(':');
                sb.append(j2);
            } else {
                sb.append(j);
            }
            i++;
            if (i < length) {
                sb.append(',');
            } else {
                return sb.toString();
            }
        }
    }

    public static long[] toArray(UIDSet[] uIDSetArr) {
        if (uIDSetArr == null) {
            return null;
        }
        long[] jArr = new long[(int) size(uIDSetArr)];
        int i = 0;
        for (UIDSet uIDSet : uIDSetArr) {
            long j = uIDSet.start;
            while (j <= uIDSet.end) {
                jArr[i] = j;
                j++;
                i++;
            }
        }
        return jArr;
    }

    public static long[] toArray(UIDSet[] uIDSetArr, long j) {
        if (uIDSetArr == null) {
            return null;
        }
        long[] jArr = new long[(int) size(uIDSetArr, j)];
        int i = 0;
        for (UIDSet uIDSet : uIDSetArr) {
            long j2 = uIDSet.start;
            while (j2 <= uIDSet.end && (j < 0 || j2 <= j)) {
                jArr[i] = j2;
                j2++;
                i++;
            }
        }
        return jArr;
    }

    public static long size(UIDSet[] uIDSetArr) {
        long j = 0;
        if (uIDSetArr != null) {
            for (UIDSet uIDSet : uIDSetArr) {
                j += uIDSet.size();
            }
        }
        return j;
    }

    private static long size(UIDSet[] uIDSetArr, long j) {
        long j2;
        if (uIDSetArr != null) {
            long j3 = 0;
            for (UIDSet uIDSet : uIDSetArr) {
                if (j < 0) {
                    j2 = uIDSet.size();
                } else {
                    long j4 = uIDSet.start;
                    if (j4 <= j) {
                        long j5 = uIDSet.end;
                        if (j5 < j) {
                            j3 += (j5 - j4) + 1;
                        } else {
                            j2 = (j - j4) + 1;
                        }
                    }
                }
                j3 += j2;
            }
            return j3;
        }
        return 0L;
    }
}
