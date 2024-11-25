package com.blankj.utilcode.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ArrayUtils {
    public static final int INDEX_NOT_FOUND = -1;

    /* loaded from: classes.dex */
    public interface Closure<E> {
        void execute(int i, E e);
    }

    @SafeVarargs
    public static <T> T[] newArray(T... tArr) {
        return tArr;
    }

    public static boolean[] newBooleanArray(boolean... zArr) {
        return zArr;
    }

    public static byte[] newByteArray(byte... bArr) {
        return bArr;
    }

    public static char[] newCharArray(char... cArr) {
        return cArr;
    }

    public static double[] newDoubleArray(double... dArr) {
        return dArr;
    }

    public static float[] newFloatArray(float... fArr) {
        return fArr;
    }

    public static int[] newIntArray(int... iArr) {
        return iArr;
    }

    public static long[] newLongArray(long... jArr) {
        return jArr;
    }

    public static short[] newShortArray(short... sArr) {
        return sArr;
    }

    private ArrayUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isEmpty(Object obj) {
        return getLength(obj) == 0;
    }

    public static int getLength(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static boolean isSameLength(Object obj, Object obj2) {
        return getLength(obj) == getLength(obj2);
    }

    public static Object get(Object obj, int i) {
        return get(obj, i, null);
    }

    public static Object get(Object obj, int i, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        try {
            return Array.get(obj, i);
        } catch (Exception unused) {
            return obj2;
        }
    }

    public static void set(Object obj, int i, Object obj2) {
        if (obj == null) {
            return;
        }
        Array.set(obj, i, obj2);
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        return Arrays.deepEquals(objArr, objArr2);
    }

    public static boolean equals(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    public static boolean equals(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public static boolean equals(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    public static boolean equals(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    public static boolean equals(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    public static <T> void reverse(T[] tArr) {
        if (tArr == null) {
            return;
        }
        int length = tArr.length - 1;
        for (int i = 0; length > i; i++) {
            T t = tArr[length];
            tArr[length] = tArr[i];
            tArr[i] = t;
            length--;
        }
    }

    public static void reverse(long[] jArr) {
        if (jArr == null) {
            return;
        }
        int length = jArr.length - 1;
        for (int i = 0; length > i; i++) {
            long j = jArr[length];
            jArr[length] = jArr[i];
            jArr[i] = j;
            length--;
        }
    }

    public static void reverse(int[] iArr) {
        if (iArr == null) {
            return;
        }
        int length = iArr.length - 1;
        for (int i = 0; length > i; i++) {
            int i2 = iArr[length];
            iArr[length] = iArr[i];
            iArr[i] = i2;
            length--;
        }
    }

    public static void reverse(short[] sArr) {
        if (sArr == null) {
            return;
        }
        int length = sArr.length - 1;
        for (int i = 0; length > i; i++) {
            short s = sArr[length];
            sArr[length] = sArr[i];
            sArr[i] = s;
            length--;
        }
    }

    public static void reverse(char[] cArr) {
        if (cArr == null) {
            return;
        }
        int length = cArr.length - 1;
        for (int i = 0; length > i; i++) {
            char c = cArr[length];
            cArr[length] = cArr[i];
            cArr[i] = c;
            length--;
        }
    }

    public static void reverse(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int length = bArr.length - 1;
        for (int i = 0; length > i; i++) {
            byte b = bArr[length];
            bArr[length] = bArr[i];
            bArr[i] = b;
            length--;
        }
    }

    public static void reverse(double[] dArr) {
        if (dArr == null) {
            return;
        }
        int length = dArr.length - 1;
        for (int i = 0; length > i; i++) {
            double d = dArr[length];
            dArr[length] = dArr[i];
            dArr[i] = d;
            length--;
        }
    }

    public static void reverse(float[] fArr) {
        if (fArr == null) {
            return;
        }
        int length = fArr.length - 1;
        for (int i = 0; length > i; i++) {
            float f = fArr[length];
            fArr[length] = fArr[i];
            fArr[i] = f;
            length--;
        }
    }

    public static void reverse(boolean[] zArr) {
        if (zArr == null) {
            return;
        }
        int length = zArr.length - 1;
        for (int i = 0; length > i; i++) {
            boolean z = zArr[length];
            zArr[length] = zArr[i];
            zArr[i] = z;
            length--;
        }
    }

    public static <T> T[] copy(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) subArray(tArr, 0, tArr.length);
    }

    public static long[] copy(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return subArray(jArr, 0, jArr.length);
    }

    public static int[] copy(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return subArray(iArr, 0, iArr.length);
    }

    public static short[] copy(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return subArray(sArr, 0, sArr.length);
    }

    public static char[] copy(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return subArray(cArr, 0, cArr.length);
    }

    public static byte[] copy(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return subArray(bArr, 0, bArr.length);
    }

    public static double[] copy(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return subArray(dArr, 0, dArr.length);
    }

    public static float[] copy(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return subArray(fArr, 0, fArr.length);
    }

    public static boolean[] copy(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return subArray(zArr, 0, zArr.length);
    }

    private static Object realCopy(Object obj) {
        if (obj == null) {
            return null;
        }
        return realSubArray(obj, 0, getLength(obj));
    }

    public static <T> T[] subArray(T[] tArr, int i, int i2) {
        return (T[]) ((Object[]) realSubArray(tArr, i, i2));
    }

    public static long[] subArray(long[] jArr, int i, int i2) {
        return (long[]) realSubArray(jArr, i, i2);
    }

    public static int[] subArray(int[] iArr, int i, int i2) {
        return (int[]) realSubArray(iArr, i, i2);
    }

    public static short[] subArray(short[] sArr, int i, int i2) {
        return (short[]) realSubArray(sArr, i, i2);
    }

    public static char[] subArray(char[] cArr, int i, int i2) {
        return (char[]) realSubArray(cArr, i, i2);
    }

    public static byte[] subArray(byte[] bArr, int i, int i2) {
        return (byte[]) realSubArray(bArr, i, i2);
    }

    public static double[] subArray(double[] dArr, int i, int i2) {
        return (double[]) realSubArray(dArr, i, i2);
    }

    public static float[] subArray(float[] fArr, int i, int i2) {
        return (float[]) realSubArray(fArr, i, i2);
    }

    public static boolean[] subArray(boolean[] zArr, int i, int i2) {
        return (boolean[]) realSubArray(zArr, i, i2);
    }

    private static Object realSubArray(Object obj, int i, int i2) {
        if (obj == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        int length = getLength(obj);
        if (i2 > length) {
            i2 = length;
        }
        int i3 = i2 - i;
        Class<?> componentType = obj.getClass().getComponentType();
        if (i3 <= 0) {
            return Array.newInstance(componentType, 0);
        }
        Object newInstance = Array.newInstance(componentType, i3);
        System.arraycopy(obj, i, newInstance, 0, i3);
        return newInstance;
    }

    public static <T> T[] add(T[] tArr, T t) {
        Class cls;
        if (tArr != null) {
            cls = tArr.getClass();
        } else {
            cls = t != null ? t.getClass() : Object.class;
        }
        return (T[]) ((Object[]) realAddOne(tArr, t, cls));
    }

    public static boolean[] add(boolean[] zArr, boolean z) {
        return (boolean[]) realAddOne(zArr, Boolean.valueOf(z), Boolean.TYPE);
    }

    public static byte[] add(byte[] bArr, byte b) {
        return (byte[]) realAddOne(bArr, Byte.valueOf(b), Byte.TYPE);
    }

    public static char[] add(char[] cArr, char c) {
        return (char[]) realAddOne(cArr, Character.valueOf(c), Character.TYPE);
    }

    public static double[] add(double[] dArr, double d) {
        return (double[]) realAddOne(dArr, Double.valueOf(d), Double.TYPE);
    }

    public static float[] add(float[] fArr, float f) {
        return (float[]) realAddOne(fArr, Float.valueOf(f), Float.TYPE);
    }

    public static int[] add(int[] iArr, int i) {
        return (int[]) realAddOne(iArr, Integer.valueOf(i), Integer.TYPE);
    }

    public static long[] add(long[] jArr, long j) {
        return (long[]) realAddOne(jArr, Long.valueOf(j), Long.TYPE);
    }

    public static short[] add(short[] sArr, short s) {
        return (short[]) realAddOne(sArr, Short.valueOf(s), Short.TYPE);
    }

    private static Object realAddOne(Object obj, Object obj2, Class cls) {
        Object newInstance;
        int i = 0;
        if (obj != null) {
            int length = getLength(obj);
            newInstance = Array.newInstance(obj.getClass().getComponentType(), length + 1);
            System.arraycopy(obj, 0, newInstance, 0, length);
            i = length;
        } else {
            newInstance = Array.newInstance(cls, 1);
        }
        Array.set(newInstance, i, obj2);
        return newInstance;
    }

    public static <T> T[] add(T[] tArr, T[] tArr2) {
        return (T[]) ((Object[]) realAddArr(tArr, tArr2));
    }

    public static boolean[] add(boolean[] zArr, boolean[] zArr2) {
        return (boolean[]) realAddArr(zArr, zArr2);
    }

    public static char[] add(char[] cArr, char[] cArr2) {
        return (char[]) realAddArr(cArr, cArr2);
    }

    public static byte[] add(byte[] bArr, byte[] bArr2) {
        return (byte[]) realAddArr(bArr, bArr2);
    }

    public static short[] add(short[] sArr, short[] sArr2) {
        return (short[]) realAddArr(sArr, sArr2);
    }

    public static int[] add(int[] iArr, int[] iArr2) {
        return (int[]) realAddArr(iArr, iArr2);
    }

    public static long[] add(long[] jArr, long[] jArr2) {
        return (long[]) realAddArr(jArr, jArr2);
    }

    public static float[] add(float[] fArr, float[] fArr2) {
        return (float[]) realAddArr(fArr, fArr2);
    }

    public static double[] add(double[] dArr, double[] dArr2) {
        return (double[]) realAddArr(dArr, dArr2);
    }

    private static Object realAddArr(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return null;
        }
        if (obj == null) {
            return realCopy(obj2);
        }
        if (obj2 == null) {
            return realCopy(obj);
        }
        int length = getLength(obj);
        int length2 = getLength(obj2);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        return newInstance;
    }

    public static <T> T[] add(T[] tArr, int i, T[] tArr2) {
        Class<?> componentType;
        if (tArr != null) {
            componentType = tArr.getClass().getComponentType();
        } else if (tArr2 != null) {
            componentType = tArr2.getClass().getComponentType();
        } else {
            return (T[]) new Object[]{null};
        }
        return (T[]) ((Object[]) realAddArr(tArr, i, tArr2, componentType));
    }

    public static boolean[] add(boolean[] zArr, int i, boolean[] zArr2) {
        return (boolean[]) realAddArr(zArr, i, zArr2, Boolean.TYPE);
    }

    public static char[] add(char[] cArr, int i, char[] cArr2) {
        return (char[]) realAddArr(cArr, i, cArr2, Character.TYPE);
    }

    public static byte[] add(byte[] bArr, int i, byte[] bArr2) {
        return (byte[]) realAddArr(bArr, i, bArr2, Byte.TYPE);
    }

    public static short[] add(short[] sArr, int i, short[] sArr2) {
        return (short[]) realAddArr(sArr, i, sArr2, Short.TYPE);
    }

    public static int[] add(int[] iArr, int i, int[] iArr2) {
        return (int[]) realAddArr(iArr, i, iArr2, Integer.TYPE);
    }

    public static long[] add(long[] jArr, int i, long[] jArr2) {
        return (long[]) realAddArr(jArr, i, jArr2, Long.TYPE);
    }

    public static float[] add(float[] fArr, int i, float[] fArr2) {
        return (float[]) realAddArr(fArr, i, fArr2, Float.TYPE);
    }

    public static double[] add(double[] dArr, int i, double[] dArr2) {
        return (double[]) realAddArr(dArr, i, dArr2, Double.TYPE);
    }

    private static Object realAddArr(Object obj, int i, Object obj2, Class cls) {
        if (obj == null && obj2 == null) {
            return null;
        }
        int length = getLength(obj);
        int length2 = getLength(obj2);
        if (length == 0) {
            if (i != 0) {
                throw new IndexOutOfBoundsException("Index: " + i + ", array1 Length: 0");
            }
            return realCopy(obj2);
        } else if (length2 == 0) {
            return realCopy(obj);
        } else {
            if (i > length || i < 0) {
                throw new IndexOutOfBoundsException("Index: " + i + ", array1 Length: " + length);
            }
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + length2);
            if (i == length) {
                System.arraycopy(obj, 0, newInstance, 0, length);
                System.arraycopy(obj2, 0, newInstance, length, length2);
            } else if (i == 0) {
                System.arraycopy(obj2, 0, newInstance, 0, length2);
                System.arraycopy(obj, 0, newInstance, length2, length);
            } else {
                System.arraycopy(obj, 0, newInstance, 0, i);
                System.arraycopy(obj2, 0, newInstance, i, length2);
                System.arraycopy(obj, i, newInstance, length2 + i, length - i);
            }
            return newInstance;
        }
    }

    public static <T> T[] add(T[] tArr, int i, T t) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass().getComponentType();
        } else if (t != null) {
            cls = t.getClass();
        } else {
            return (T[]) new Object[]{null};
        }
        return (T[]) ((Object[]) realAdd(tArr, i, t, cls));
    }

    public static boolean[] add(boolean[] zArr, int i, boolean z) {
        return (boolean[]) realAdd(zArr, i, Boolean.valueOf(z), Boolean.TYPE);
    }

    public static char[] add(char[] cArr, int i, char c) {
        return (char[]) realAdd(cArr, i, Character.valueOf(c), Character.TYPE);
    }

    public static byte[] add(byte[] bArr, int i, byte b) {
        return (byte[]) realAdd(bArr, i, Byte.valueOf(b), Byte.TYPE);
    }

    public static short[] add(short[] sArr, int i, short s) {
        return (short[]) realAdd(sArr, i, Short.valueOf(s), Short.TYPE);
    }

    public static int[] add(int[] iArr, int i, int i2) {
        return (int[]) realAdd(iArr, i, Integer.valueOf(i2), Integer.TYPE);
    }

    public static long[] add(long[] jArr, int i, long j) {
        return (long[]) realAdd(jArr, i, Long.valueOf(j), Long.TYPE);
    }

    public static float[] add(float[] fArr, int i, float f) {
        return (float[]) realAdd(fArr, i, Float.valueOf(f), Float.TYPE);
    }

    public static double[] add(double[] dArr, int i, double d) {
        return (double[]) realAdd(dArr, i, Double.valueOf(d), Double.TYPE);
    }

    private static Object realAdd(Object obj, int i, Object obj2, Class cls) {
        if (obj == null) {
            if (i != 0) {
                throw new IndexOutOfBoundsException("Index: " + i + ", Length: 0");
            }
            Object newInstance = Array.newInstance(cls, 1);
            Array.set(newInstance, 0, obj2);
            return newInstance;
        }
        int length = Array.getLength(obj);
        if (i > length || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + length);
        }
        Object newInstance2 = Array.newInstance(cls, length + 1);
        System.arraycopy(obj, 0, newInstance2, 0, i);
        Array.set(newInstance2, i, obj2);
        if (i < length) {
            System.arraycopy(obj, i, newInstance2, i + 1, length - i);
        }
        return newInstance2;
    }

    public static Object[] remove(Object[] objArr, int i) {
        return (Object[]) remove((Object) objArr, i);
    }

    public static Object[] removeElement(Object[] objArr, Object obj) {
        int indexOf = indexOf(objArr, obj);
        if (indexOf == -1) {
            return copy(objArr);
        }
        return remove(objArr, indexOf);
    }

    public static boolean[] remove(boolean[] zArr, int i) {
        return (boolean[]) remove((Object) zArr, i);
    }

    public static boolean[] removeElement(boolean[] zArr, boolean z) {
        int indexOf = indexOf(zArr, z);
        if (indexOf == -1) {
            return copy(zArr);
        }
        return remove(zArr, indexOf);
    }

    public static byte[] remove(byte[] bArr, int i) {
        return (byte[]) remove((Object) bArr, i);
    }

    public static byte[] removeElement(byte[] bArr, byte b) {
        int indexOf = indexOf(bArr, b);
        if (indexOf == -1) {
            return copy(bArr);
        }
        return remove(bArr, indexOf);
    }

    public static char[] remove(char[] cArr, int i) {
        return (char[]) remove((Object) cArr, i);
    }

    public static char[] removeElement(char[] cArr, char c) {
        int indexOf = indexOf(cArr, c);
        if (indexOf == -1) {
            return copy(cArr);
        }
        return remove(cArr, indexOf);
    }

    public static double[] remove(double[] dArr, int i) {
        return (double[]) remove((Object) dArr, i);
    }

    public static double[] removeElement(double[] dArr, double d) {
        int indexOf = indexOf(dArr, d);
        if (indexOf == -1) {
            return copy(dArr);
        }
        return remove(dArr, indexOf);
    }

    public static float[] remove(float[] fArr, int i) {
        return (float[]) remove((Object) fArr, i);
    }

    public static float[] removeElement(float[] fArr, float f) {
        int indexOf = indexOf(fArr, f);
        if (indexOf == -1) {
            return copy(fArr);
        }
        return remove(fArr, indexOf);
    }

    public static int[] remove(int[] iArr, int i) {
        return (int[]) remove((Object) iArr, i);
    }

    public static int[] removeElement(int[] iArr, int i) {
        int indexOf = indexOf(iArr, i);
        if (indexOf == -1) {
            return copy(iArr);
        }
        return remove(iArr, indexOf);
    }

    public static long[] remove(long[] jArr, int i) {
        return (long[]) remove((Object) jArr, i);
    }

    public static long[] removeElement(long[] jArr, long j) {
        int indexOf = indexOf(jArr, j);
        if (indexOf == -1) {
            return copy(jArr);
        }
        return remove(jArr, indexOf);
    }

    public static short[] remove(short[] sArr, int i) {
        return (short[]) remove((Object) sArr, i);
    }

    public static short[] removeElement(short[] sArr, short s) {
        int indexOf = indexOf(sArr, s);
        if (indexOf == -1) {
            return copy(sArr);
        }
        return remove(sArr, indexOf);
    }

    private static Object remove(Object obj, int i) {
        int length = getLength(obj);
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + length);
        }
        int i2 = length - 1;
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i2);
        System.arraycopy(obj, 0, newInstance, 0, i);
        if (i < i2) {
            System.arraycopy(obj, i + 1, newInstance, i, (length - i) - 1);
        }
        return newInstance;
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return indexOf(objArr, obj, 0);
    }

    public static int indexOf(Object[] objArr, Object obj, int i) {
        if (objArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        if (obj == null) {
            while (i < objArr.length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < objArr.length) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        return lastIndexOf(objArr, obj, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i) {
        if (objArr != null && i >= 0) {
            if (i >= objArr.length) {
                i = objArr.length - 1;
            }
            if (obj == null) {
                while (i >= 0) {
                    if (objArr[i] == null) {
                        return i;
                    }
                    i--;
                }
            } else {
                while (i >= 0) {
                    if (obj.equals(objArr[i])) {
                        return i;
                    }
                    i--;
                }
            }
            return -1;
        }
        return -1;
    }

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    public static int indexOf(long[] jArr, long j) {
        return indexOf(jArr, j, 0);
    }

    public static int indexOf(long[] jArr, long j, int i) {
        if (jArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < jArr.length) {
            if (j == jArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(long[] jArr, long j) {
        return lastIndexOf(jArr, j, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(long[] jArr, long j, int i) {
        if (jArr != null && i >= 0) {
            if (i >= jArr.length) {
                i = jArr.length - 1;
            }
            while (i >= 0) {
                if (j == jArr[i]) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        return -1;
    }

    public static boolean contains(long[] jArr, long j) {
        return indexOf(jArr, j) != -1;
    }

    public static int indexOf(int[] iArr, int i) {
        return indexOf(iArr, i, 0);
    }

    public static int indexOf(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < iArr.length) {
            if (i == iArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOf(int[] iArr, int i) {
        return lastIndexOf(iArr, i, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(int[] iArr, int i, int i2) {
        if (iArr != null && i2 >= 0) {
            if (i2 >= iArr.length) {
                i2 = iArr.length - 1;
            }
            while (i2 >= 0) {
                if (i == iArr[i2]) {
                    return i2;
                }
                i2--;
            }
            return -1;
        }
        return -1;
    }

    public static boolean contains(int[] iArr, int i) {
        return indexOf(iArr, i) != -1;
    }

    public static int indexOf(short[] sArr, short s) {
        return indexOf(sArr, s, 0);
    }

    public static int indexOf(short[] sArr, short s, int i) {
        if (sArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < sArr.length) {
            if (s == sArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(short[] sArr, short s) {
        return lastIndexOf(sArr, s, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(short[] sArr, short s, int i) {
        if (sArr != null && i >= 0) {
            if (i >= sArr.length) {
                i = sArr.length - 1;
            }
            while (i >= 0) {
                if (s == sArr[i]) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        return -1;
    }

    public static boolean contains(short[] sArr, short s) {
        return indexOf(sArr, s) != -1;
    }

    public static int indexOf(char[] cArr, char c) {
        return indexOf(cArr, c, 0);
    }

    public static int indexOf(char[] cArr, char c, int i) {
        if (cArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < cArr.length) {
            if (c == cArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(char[] cArr, char c) {
        return lastIndexOf(cArr, c, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(char[] cArr, char c, int i) {
        if (cArr != null && i >= 0) {
            if (i >= cArr.length) {
                i = cArr.length - 1;
            }
            while (i >= 0) {
                if (c == cArr[i]) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        return -1;
    }

    public static boolean contains(char[] cArr, char c) {
        return indexOf(cArr, c) != -1;
    }

    public static int indexOf(byte[] bArr, byte b) {
        return indexOf(bArr, b, 0);
    }

    public static int indexOf(byte[] bArr, byte b, int i) {
        if (bArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < bArr.length) {
            if (b == bArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(byte[] bArr, byte b) {
        return lastIndexOf(bArr, b, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(byte[] bArr, byte b, int i) {
        if (bArr != null && i >= 0) {
            if (i >= bArr.length) {
                i = bArr.length - 1;
            }
            while (i >= 0) {
                if (b == bArr[i]) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        return -1;
    }

    public static boolean contains(byte[] bArr, byte b) {
        return indexOf(bArr, b) != -1;
    }

    public static int indexOf(double[] dArr, double d) {
        return indexOf(dArr, d, 0);
    }

    public static int indexOf(double[] dArr, double d, double d2) {
        return indexOf(dArr, d, 0, d2);
    }

    public static int indexOf(double[] dArr, double d, int i) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < dArr.length) {
            if (d == dArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(double[] dArr, double d, int i, double d2) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        double d3 = d - d2;
        double d4 = d + d2;
        while (i < dArr.length) {
            if (dArr[i] >= d3 && dArr[i] <= d4) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArr, double d) {
        return lastIndexOf(dArr, d, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(double[] dArr, double d, double d2) {
        return lastIndexOf(dArr, d, Integer.MAX_VALUE, d2);
    }

    public static int lastIndexOf(double[] dArr, double d, int i) {
        if (!isEmpty(dArr) && i >= 0) {
            if (i >= dArr.length) {
                i = dArr.length - 1;
            }
            while (i >= 0) {
                if (d == dArr[i]) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArr, double d, int i, double d2) {
        if (!isEmpty(dArr) && i >= 0) {
            if (i >= dArr.length) {
                i = dArr.length - 1;
            }
            double d3 = d - d2;
            double d4 = d + d2;
            while (i >= 0) {
                if (dArr[i] >= d3 && dArr[i] <= d4) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        return -1;
    }

    public static boolean contains(double[] dArr, double d) {
        return indexOf(dArr, d) != -1;
    }

    public static boolean contains(double[] dArr, double d, double d2) {
        return indexOf(dArr, d, 0, d2) != -1;
    }

    public static int indexOf(float[] fArr, float f) {
        return indexOf(fArr, f, 0);
    }

    public static int indexOf(float[] fArr, float f, int i) {
        if (isEmpty(fArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < fArr.length) {
            if (f == fArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(float[] fArr, float f) {
        return lastIndexOf(fArr, f, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(float[] fArr, float f, int i) {
        if (!isEmpty(fArr) && i >= 0) {
            if (i >= fArr.length) {
                i = fArr.length - 1;
            }
            while (i >= 0) {
                if (f == fArr[i]) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        return -1;
    }

    public static boolean contains(float[] fArr, float f) {
        return indexOf(fArr, f) != -1;
    }

    public static int indexOf(boolean[] zArr, boolean z) {
        return indexOf(zArr, z, 0);
    }

    public static int indexOf(boolean[] zArr, boolean z, int i) {
        if (isEmpty(zArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < zArr.length) {
            if (z == zArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z) {
        return lastIndexOf(zArr, z, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(boolean[] zArr, boolean z, int i) {
        if (!isEmpty(zArr) && i >= 0) {
            if (i >= zArr.length) {
                i = zArr.length - 1;
            }
            while (i >= 0) {
                if (z == zArr[i]) {
                    return i;
                }
                i--;
            }
            return -1;
        }
        return -1;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        return indexOf(zArr, z) != -1;
    }

    public static char[] toPrimitive(Character[] chArr) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return new char[0];
        }
        char[] cArr = new char[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            cArr[i] = chArr[i].charValue();
        }
        return cArr;
    }

    public static char[] toPrimitive(Character[] chArr, char c) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return new char[0];
        }
        char[] cArr = new char[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            Character ch2 = chArr[i];
            cArr[i] = ch2 == null ? c : ch2.charValue();
        }
        return cArr;
    }

    public static Character[] toObject(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return new Character[0];
        }
        Character[] chArr = new Character[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            chArr[i] = new Character(cArr[i]);
        }
        return chArr;
    }

    public static long[] toPrimitive(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    public static long[] toPrimitive(Long[] lArr, long j) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            Long l = lArr[i];
            jArr[i] = l == null ? j : l.longValue();
        }
        return jArr;
    }

    public static Long[] toObject(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return new Long[0];
        }
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = new Long(jArr[i]);
        }
        return lArr;
    }

    public static int[] toPrimitive(Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return new int[0];
        }
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public static int[] toPrimitive(Integer[] numArr, int i) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return new int[0];
        }
        int[] iArr = new int[numArr.length];
        for (int i2 = 0; i2 < numArr.length; i2++) {
            Integer num = numArr[i2];
            iArr[i2] = num == null ? i : num.intValue();
        }
        return iArr;
    }

    public static Integer[] toObject(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return new Integer[0];
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = new Integer(iArr[i]);
        }
        return numArr;
    }

    public static short[] toPrimitive(Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return new short[0];
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            sArr[i] = shArr[i].shortValue();
        }
        return sArr;
    }

    public static short[] toPrimitive(Short[] shArr, short s) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return new short[0];
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            Short sh = shArr[i];
            sArr[i] = sh == null ? s : sh.shortValue();
        }
        return sArr;
    }

    public static Short[] toObject(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return new Short[0];
        }
        Short[] shArr = new Short[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            shArr[i] = new Short(sArr[i]);
        }
        return shArr;
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    public static byte[] toPrimitive(Byte[] bArr, byte b) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            Byte b2 = bArr[i];
            bArr2[i] = b2 == null ? b : b2.byteValue();
        }
        return bArr2;
    }

    public static Byte[] toObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new Byte[0];
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = new Byte(bArr[i]);
        }
        return bArr2;
    }

    public static double[] toPrimitive(Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    public static double[] toPrimitive(Double[] dArr, double d) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            Double d2 = dArr[i];
            dArr2[i] = d2 == null ? d : d2.doubleValue();
        }
        return dArr2;
    }

    public static Double[] toObject(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new Double[0];
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = new Double(dArr[i]);
        }
        return dArr2;
    }

    public static float[] toPrimitive(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new float[0];
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    public static float[] toPrimitive(Float[] fArr, float f) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new float[0];
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            Float f2 = fArr[i];
            fArr2[i] = f2 == null ? f : f2.floatValue();
        }
        return fArr2;
    }

    public static Float[] toObject(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new Float[0];
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = new Float(fArr[i]);
        }
        return fArr2;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr, boolean z) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            Boolean bool = boolArr[i];
            zArr[i] = bool == null ? z : bool.booleanValue();
        }
        return zArr;
    }

    public static Boolean[] toObject(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return new Boolean[0];
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = zArr[i] ? Boolean.TRUE : Boolean.FALSE;
        }
        return boolArr;
    }

    public static <T> List<T> asList(T... tArr) {
        if (tArr == null || tArr.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(tArr);
    }

    public static <T> List<T> asUnmodifiableList(T... tArr) {
        return Collections.unmodifiableList(asList(tArr));
    }

    public static <T> List<T> asArrayList(T... tArr) {
        ArrayList arrayList = new ArrayList();
        if (tArr != null && tArr.length != 0) {
            arrayList.addAll(Arrays.asList(tArr));
        }
        return arrayList;
    }

    public static <T> List<T> asLinkedList(T... tArr) {
        LinkedList linkedList = new LinkedList();
        if (tArr != null && tArr.length != 0) {
            linkedList.addAll(Arrays.asList(tArr));
        }
        return linkedList;
    }

    public static <T> void sort(T[] tArr, Comparator<? super T> comparator) {
        if (tArr == null || tArr.length < 2) {
            return;
        }
        Arrays.sort(tArr, comparator);
    }

    public static void sort(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return;
        }
        Arrays.sort(bArr);
    }

    public static void sort(char[] cArr) {
        if (cArr == null || cArr.length < 2) {
            return;
        }
        Arrays.sort(cArr);
    }

    public static void sort(double[] dArr) {
        if (dArr == null || dArr.length < 2) {
            return;
        }
        Arrays.sort(dArr);
    }

    public static void sort(float[] fArr) {
        if (fArr == null || fArr.length < 2) {
            return;
        }
        Arrays.sort(fArr);
    }

    public static void sort(int[] iArr) {
        if (iArr == null || iArr.length < 2) {
            return;
        }
        Arrays.sort(iArr);
    }

    public static void sort(long[] jArr) {
        if (jArr == null || jArr.length < 2) {
            return;
        }
        Arrays.sort(jArr);
    }

    public static void sort(short[] sArr) {
        if (sArr == null || sArr.length < 2) {
            return;
        }
        Arrays.sort(sArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void forAllDo(Object obj, Closure<E> closure) {
        if (obj == null || closure == 0) {
            return;
        }
        int i = 0;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            while (i < length) {
                closure.execute(i, objArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length2 = zArr.length;
            while (i < length2) {
                closure.execute(i, zArr[i] ? Boolean.TRUE : Boolean.FALSE);
                i++;
            }
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length3 = bArr.length;
            while (i < length3) {
                closure.execute(i, Byte.valueOf(bArr[i]));
                i++;
            }
        } else if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            int length4 = cArr.length;
            while (i < length4) {
                closure.execute(i, Character.valueOf(cArr[i]));
                i++;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length5 = sArr.length;
            while (i < length5) {
                closure.execute(i, Short.valueOf(sArr[i]));
                i++;
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length6 = iArr.length;
            while (i < length6) {
                closure.execute(i, Integer.valueOf(iArr[i]));
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length7 = jArr.length;
            while (i < length7) {
                closure.execute(i, Long.valueOf(jArr[i]));
                i++;
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length8 = fArr.length;
            while (i < length8) {
                closure.execute(i, Float.valueOf(fArr[i]));
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length9 = dArr.length;
            while (i < length9) {
                closure.execute(i, Double.valueOf(dArr[i]));
                i++;
            }
        } else {
            throw new IllegalArgumentException("Not an array: " + obj.getClass());
        }
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof Object[]) {
            return Arrays.deepToString((Object[]) obj);
        }
        if (obj instanceof boolean[]) {
            return Arrays.toString((boolean[]) obj);
        }
        if (obj instanceof byte[]) {
            return Arrays.toString((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return Arrays.toString((char[]) obj);
        }
        if (obj instanceof double[]) {
            return Arrays.toString((double[]) obj);
        }
        if (obj instanceof float[]) {
            return Arrays.toString((float[]) obj);
        }
        if (obj instanceof int[]) {
            return Arrays.toString((int[]) obj);
        }
        if (obj instanceof long[]) {
            return Arrays.toString((long[]) obj);
        }
        if (obj instanceof short[]) {
            return Arrays.toString((short[]) obj);
        }
        throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
    }
}
