package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes.dex */
public final class MemorySizeCalculator {
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int arrayPoolSize;
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    /* loaded from: classes.dex */
    interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    MemorySizeCalculator(Builder builder) {
        int i;
        this.context = builder.context;
        if (isLowMemoryDevice(builder.activityManager)) {
            i = builder.arrayPoolSizeBytes / 2;
        } else {
            i = builder.arrayPoolSizeBytes;
        }
        this.arrayPoolSize = i;
        int maxSize = getMaxSize(builder.activityManager, builder.maxSizeMultiplier, builder.lowMemoryMaxSizeMultiplier);
        float widthPixels = builder.screenDimensions.getWidthPixels() * builder.screenDimensions.getHeightPixels() * 4;
        int round = Math.round(builder.bitmapPoolScreens * widthPixels);
        int round2 = Math.round(widthPixels * builder.memoryCacheScreens);
        int i2 = maxSize - this.arrayPoolSize;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.memoryCacheSize = round2;
            this.bitmapPoolSize = round;
        } else {
            float f = i2 / (builder.bitmapPoolScreens + builder.memoryCacheScreens);
            this.memoryCacheSize = Math.round(builder.memoryCacheScreens * f);
            this.bitmapPoolSize = Math.round(f * builder.bitmapPoolScreens);
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(toMb(this.memoryCacheSize));
            sb.append(", pool size: ");
            sb.append(toMb(this.bitmapPoolSize));
            sb.append(", byte array size: ");
            sb.append(toMb(this.arrayPoolSize));
            sb.append(", memory class limited? ");
            sb.append(i3 > maxSize);
            sb.append(", max size: ");
            sb.append(toMb(maxSize));
            sb.append(", memoryClass: ");
            sb.append(builder.activityManager.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(isLowMemoryDevice(builder.activityManager));
            Log.d(TAG, sb.toString());
        }
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getArrayPoolSizeInBytes() {
        return this.arrayPoolSize;
    }

    private static int getMaxSize(ActivityManager activityManager, float f, float f2) {
        boolean isLowMemoryDevice = isLowMemoryDevice(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (isLowMemoryDevice) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    private String toMb(int i) {
        return Formatter.formatFileSize(this.context, i);
    }

    static boolean isLowMemoryDevice(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        static final int ARRAY_POOL_SIZE_BYTES = 4194304;
        static final int BITMAP_POOL_TARGET_SCREENS;
        static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
        static final float MAX_SIZE_MULTIPLIER = 0.4f;
        static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        ActivityManager activityManager;
        float bitmapPoolScreens;
        final Context context;
        ScreenDimensions screenDimensions;
        float memoryCacheScreens = 2.0f;
        float maxSizeMultiplier = MAX_SIZE_MULTIPLIER;
        float lowMemoryMaxSizeMultiplier = LOW_MEMORY_MAX_SIZE_MULTIPLIER;
        int arrayPoolSizeBytes = 4194304;

        static {
            BITMAP_POOL_TARGET_SCREENS = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public Builder(Context context) {
            this.bitmapPoolScreens = BITMAP_POOL_TARGET_SCREENS;
            this.context = context;
            this.activityManager = (ActivityManager) context.getSystemService("activity");
            this.screenDimensions = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !MemorySizeCalculator.isLowMemoryDevice(this.activityManager)) {
                return;
            }
            this.bitmapPoolScreens = 0.0f;
        }

        public Builder setMemoryCacheScreens(float f) {
            Preconditions.checkArgument(f >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.memoryCacheScreens = f;
            return this;
        }

        public Builder setBitmapPoolScreens(float f) {
            Preconditions.checkArgument(f >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.bitmapPoolScreens = f;
            return this;
        }

        public Builder setMaxSizeMultiplier(float f) {
            Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Size multiplier must be between 0 and 1");
            this.maxSizeMultiplier = f;
            return this;
        }

        public Builder setLowMemoryMaxSizeMultiplier(float f) {
            Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.lowMemoryMaxSizeMultiplier = f;
            return this;
        }

        public Builder setArrayPoolSize(int i) {
            this.arrayPoolSizeBytes = i;
            return this;
        }

        Builder setActivityManager(ActivityManager activityManager) {
            this.activityManager = activityManager;
            return this;
        }

        Builder setScreenDimensions(ScreenDimensions screenDimensions) {
            this.screenDimensions = screenDimensions;
            return this;
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }
    }

    /* loaded from: classes.dex */
    private static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }
    }
}
