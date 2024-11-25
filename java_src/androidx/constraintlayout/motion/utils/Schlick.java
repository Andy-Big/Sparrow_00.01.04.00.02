package androidx.constraintlayout.motion.utils;
/* loaded from: classes.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double eps;
    double mS;
    double mT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Schlick(String str) {
        this.str = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.mS = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i = indexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    private double func(double d) {
        double d2 = this.mT;
        if (d < d2) {
            return (d2 * d) / (d + (this.mS * (d2 - d)));
        }
        return ((1.0d - d2) * (d - 1.0d)) / ((1.0d - d) - (this.mS * (d2 - d)));
    }

    private double dfunc(double d) {
        double d2 = this.mT;
        if (d < d2) {
            double d3 = this.mS;
            return ((d3 * d2) * d2) / ((((d2 - d) * d3) + d) * ((d3 * (d2 - d)) + d));
        }
        double d4 = this.mS;
        return (((d2 - 1.0d) * d4) * (d2 - 1.0d)) / (((((-d4) * (d2 - d)) - d) + 1.0d) * ((((-d4) * (d2 - d)) - d) + 1.0d));
    }

    @Override // androidx.constraintlayout.motion.utils.Easing
    public double getDiff(double d) {
        return dfunc(d);
    }

    @Override // androidx.constraintlayout.motion.utils.Easing
    public double get(double d) {
        return func(d);
    }
}
