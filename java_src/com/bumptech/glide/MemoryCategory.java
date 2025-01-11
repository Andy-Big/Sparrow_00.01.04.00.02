package com.bumptech.glide;

/* loaded from: classes.dex */
public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private final float multiplier;

    MemoryCategory(float f) {
        this.multiplier = f;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
