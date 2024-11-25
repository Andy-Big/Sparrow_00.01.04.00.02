package com.rigol.pinyinkeyboard;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
/* loaded from: classes.dex */
public class PinyinIme {
    private static final String TAG = "[PinyinIme]";
    private static AssetManager assetManager;
    private static int file;
    private static AssetFileDescriptor fileDescriptor;
    private static PinyinIme instance;
    private static long length;
    private static boolean mOpenSucceeded;
    private static long startOffset;

    private static native int nativeCancelLastChoice();

    private static native int nativeChoose(int i);

    private static native void nativeCloseDecoder();

    private static native int nativeDelsearch(int i);

    private static native void nativeEnableShmAsSzm(boolean z);

    private static native void nativeEnableYmAsSzm(boolean z);

    private static native String[] nativeGetAllPredicts(String str);

    private static native String nativeGetCandidate(int i);

    private static native int nativeGetFixedLen();

    private static native int nativeGetPredictsNum(String str);

    private static native SpellingString nativeGetSpellingString();

    private static native boolean nativeOpenDecoder(String str, String str2);

    private static native boolean nativeOpenDecoderFromAssets(int i, long j, long j2, String str);

    private static native void nativeResetSearch();

    private static native String[] nativeSearchAll(String str);

    private static native int nativeSearchAllNum(String str);

    private static native void nativeflushCache();

    static {
        System.loadLibrary("kbd-lib");
        instance = null;
        mOpenSucceeded = false;
    }

    private PinyinIme() {
    }

    public static PinyinIme getInstance() {
        if (instance == null) {
            synchronized (PinyinIme.class) {
                instance = new PinyinIme();
            }
        }
        return instance;
    }

    /* loaded from: classes.dex */
    public static class SpellingString {
        public int decodedLen;
        public String spellingStr;

        public SpellingString(String str, int i) {
            this.decodedLen = i;
            this.spellingStr = str;
        }
    }

    public static void openDecoderFromAssets(String str, Context context) {
        try {
            AssetManager assets = context.getAssets();
            assetManager = assets;
            AssetFileDescriptor openFd = assets.openFd("raw/dict_pinyin.dat");
            fileDescriptor = openFd;
            startOffset = openFd.getStartOffset();
            length = fileDescriptor.getLength();
            file = fileDescriptor.getParcelFileDescriptor().detachFd();
            fileDescriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!mOpenSucceeded) {
            boolean nativeOpenDecoderFromAssets = nativeOpenDecoderFromAssets(file, startOffset, length, str);
            mOpenSucceeded = nativeOpenDecoderFromAssets;
            if (nativeOpenDecoderFromAssets) {
                return;
            }
            Log.e(TAG, "[openDecoderFromAssets] failed to open decoder, assetFile is " + file + ", userDict is " + str);
            return;
        }
        Log.e(TAG, "[openDecoderFromAssets] has opned!");
    }

    public static void openDecoder(String str, String str2) {
        if (!mOpenSucceeded) {
            boolean nativeOpenDecoder = nativeOpenDecoder(str, str2);
            mOpenSucceeded = nativeOpenDecoder;
            if (nativeOpenDecoder) {
                return;
            }
            Log.e(TAG, "[openDecoder] failed to open decoder, sysDict is " + str + ", userDict is " + str2);
            return;
        }
        Log.e(TAG, "[openDecoder] has opned!");
    }

    public static boolean isInited() {
        return mOpenSucceeded;
    }

    public static void closeDecoder() {
        if (mOpenSucceeded) {
            nativeCloseDecoder();
            mOpenSucceeded = false;
        }
    }

    public static int searchAllNum(String str) {
        if (mOpenSucceeded) {
            return nativeSearchAllNum(str);
        }
        return 0;
    }

    public static String[] searchAll(String str) {
        if (mOpenSucceeded) {
            return nativeSearchAll(str);
        }
        return null;
    }

    public static int getPredictsNum(String str) {
        if (mOpenSucceeded) {
            return nativeGetPredictsNum(str);
        }
        return 0;
    }

    public static String[] getAllPredicts(String str) {
        if (mOpenSucceeded) {
            return nativeGetAllPredicts(str);
        }
        return null;
    }

    public static void flushCache() {
        if (mOpenSucceeded) {
            nativeflushCache();
        }
    }

    public static int delSearch(int i) {
        if (mOpenSucceeded) {
            return nativeDelsearch(i);
        }
        return -1;
    }

    public static void enableShmAsSzm(boolean z) {
        if (mOpenSucceeded) {
            nativeEnableShmAsSzm(z);
        }
    }

    public static void enableYmAsSzm(boolean z) {
        if (mOpenSucceeded) {
            nativeEnableYmAsSzm(z);
        }
    }

    public static int cancelLastChoice() {
        if (mOpenSucceeded) {
            return nativeCancelLastChoice();
        }
        return 0;
    }

    public static int choose(int i) {
        if (mOpenSucceeded) {
            return nativeChoose(i);
        }
        return 0;
    }

    public static SpellingString getSpellingString() {
        if (mOpenSucceeded) {
            return nativeGetSpellingString();
        }
        return null;
    }

    public static String getCandidate(int i) {
        if (mOpenSucceeded) {
            return nativeGetCandidate(i);
        }
        return null;
    }

    public static void resetSearch() {
        if (mOpenSucceeded) {
            nativeResetSearch();
        }
    }

    public static int getFixedLen() {
        if (mOpenSucceeded) {
            return nativeGetFixedLen();
        }
        return 0;
    }
}
