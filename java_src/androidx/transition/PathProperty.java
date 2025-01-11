package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes.dex */
class PathProperty<T> extends Property<T, Float> {
    private float mCurrentFraction;
    private final float mPathLength;
    private final PathMeasure mPathMeasure;
    private final PointF mPointF;
    private final float[] mPosition;
    private final Property<T, PointF> mProperty;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(Object obj) {
        return get((PathProperty<T>) obj);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f) {
        set2((PathProperty<T>) obj, f);
    }

    PathProperty(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.mPosition = new float[2];
        this.mPointF = new PointF();
        this.mProperty = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.mPathMeasure = pathMeasure;
        this.mPathLength = pathMeasure.getLength();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T t) {
        return Float.valueOf(this.mCurrentFraction);
    }

    /* renamed from: set  reason: avoid collision after fix types in other method */
    public void set2(T t, Float f) {
        this.mCurrentFraction = f.floatValue();
        this.mPathMeasure.getPosTan(this.mPathLength * f.floatValue(), this.mPosition, null);
        this.mPointF.x = this.mPosition[0];
        this.mPointF.y = this.mPosition[1];
        this.mProperty.set(t, this.mPointF);
    }
}
