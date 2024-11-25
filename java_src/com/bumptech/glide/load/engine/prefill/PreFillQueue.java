package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
final class PreFillQueue {
    private final Map<PreFillType, Integer> bitmapsPerType;
    private int bitmapsRemaining;
    private int keyIndex;
    private final List<PreFillType> keyList;

    public PreFillQueue(Map<PreFillType, Integer> map) {
        this.bitmapsPerType = map;
        this.keyList = new ArrayList(map.keySet());
        for (Integer num : map.values()) {
            this.bitmapsRemaining += num.intValue();
        }
    }

    public PreFillType remove() {
        PreFillType preFillType = this.keyList.get(this.keyIndex);
        Integer num = this.bitmapsPerType.get(preFillType);
        if (num.intValue() == 1) {
            this.bitmapsPerType.remove(preFillType);
            this.keyList.remove(this.keyIndex);
        } else {
            this.bitmapsPerType.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.bitmapsRemaining--;
        this.keyIndex = this.keyList.isEmpty() ? 0 : (this.keyIndex + 1) % this.keyList.size();
        return preFillType;
    }

    public int getSize() {
        return this.bitmapsRemaining;
    }

    public boolean isEmpty() {
        return this.bitmapsRemaining == 0;
    }
}
