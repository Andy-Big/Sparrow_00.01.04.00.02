package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes.dex */
public final class PreFillType {
    static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    PreFillType(int i, int i2, Bitmap.Config config, int i3) {
        this.config = (Bitmap.Config) Preconditions.checkNotNull(config, "Config must not be null");
        this.width = i;
        this.height = i2;
        this.weight = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getWidth() {
        return this.width;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHeight() {
        return this.height;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap.Config getConfig() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getWeight() {
        return this.weight;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PreFillType) {
            PreFillType preFillType = (PreFillType) obj;
            return this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.config.hashCode()) * 31) + this.weight;
    }

    public String toString() {
        return "PreFillSize{width=" + this.width + ", height=" + this.height + ", config=" + this.config + ", weight=" + this.weight + '}';
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int i) {
            this(i, i);
        }

        public Builder(int i, int i2) {
            this.weight = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i2 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.width = i;
            this.height = i2;
        }

        public Builder setConfig(Bitmap.Config config) {
            this.config = config;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setWeight(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.weight = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }
    }
}
