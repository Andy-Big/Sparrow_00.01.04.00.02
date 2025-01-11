package com.google.android.material.shape;

/* loaded from: classes.dex */
public final class OffsetEdgeTreatment extends EdgeTreatment {
    private final float offset;
    private final EdgeTreatment other;

    public OffsetEdgeTreatment(EdgeTreatment edgeTreatment, float f) {
        this.other = edgeTreatment;
        this.offset = f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        this.other.getEdgePath(f, f2 - this.offset, f3, shapePath);
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    boolean forceIntersection() {
        return this.other.forceIntersection();
    }
}
