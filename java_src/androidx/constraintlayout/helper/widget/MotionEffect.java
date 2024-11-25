package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R;
/* loaded from: classes.dex */
public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    private static final int UNSET = -1;
    public static final int WEST = 3;
    private float fadeAlpha;
    private int fadeEnd;
    private int fadeMove;
    private boolean fadeMoveStrict;
    private int fadeStart;
    private int fadeTranslationX;
    private int fadeTranslationY;
    private int viewTransitionId;

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isDecorator() {
        return true;
    }

    public MotionEffect(Context context) {
        super(context);
        this.fadeAlpha = 0.1f;
        this.fadeStart = 49;
        this.fadeEnd = 50;
        this.fadeTranslationX = 0;
        this.fadeTranslationY = 0;
        this.fadeMoveStrict = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fadeAlpha = 0.1f;
        this.fadeStart = 49;
        this.fadeEnd = 50;
        this.fadeTranslationX = 0;
        this.fadeTranslationY = 0;
        this.fadeMoveStrict = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
        init(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fadeAlpha = 0.1f;
        this.fadeStart = 49;
        this.fadeEnd = 50;
        this.fadeTranslationX = 0;
        this.fadeTranslationY = 0;
        this.fadeMoveStrict = true;
        this.viewTransitionId = -1;
        this.fadeMove = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionEffect_fadeMove_start) {
                    int i2 = obtainStyledAttributes.getInt(index, this.fadeStart);
                    this.fadeStart = i2;
                    this.fadeStart = Math.max(Math.min(i2, 99), 0);
                } else if (index == R.styleable.MotionEffect_fadeMove_end) {
                    int i3 = obtainStyledAttributes.getInt(index, this.fadeEnd);
                    this.fadeEnd = i3;
                    this.fadeEnd = Math.max(Math.min(i3, 99), 0);
                } else if (index == R.styleable.MotionEffect_fadeMove_translationX) {
                    this.fadeTranslationX = obtainStyledAttributes.getDimensionPixelOffset(index, this.fadeTranslationX);
                } else if (index == R.styleable.MotionEffect_fadeMove_translationY) {
                    this.fadeTranslationY = obtainStyledAttributes.getDimensionPixelOffset(index, this.fadeTranslationY);
                } else if (index == R.styleable.MotionEffect_fadeMove_alpha) {
                    this.fadeAlpha = obtainStyledAttributes.getFloat(index, this.fadeAlpha);
                } else if (index == R.styleable.MotionEffect_fadeMove_move) {
                    this.fadeMove = obtainStyledAttributes.getInt(index, this.fadeMove);
                } else if (index == R.styleable.MotionEffect_fadeMove_strict) {
                    this.fadeMoveStrict = obtainStyledAttributes.getBoolean(index, this.fadeMoveStrict);
                } else if (index == R.styleable.MotionEffect_fadeMove_viewTransition) {
                    this.viewTransitionId = obtainStyledAttributes.getResourceId(index, this.viewTransitionId);
                }
            }
            int i4 = this.fadeStart;
            int i5 = this.fadeEnd;
            if (i4 == i5) {
                if (i4 > 0) {
                    this.fadeStart = i4 - 1;
                } else {
                    this.fadeEnd = i5 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x017e, code lost:
        if (r14 == 0.0f) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0192, code lost:
        if (r14 == 0.0f) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01a2, code lost:
        if (r15 == 0.0f) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01b2, code lost:
        if (r15 == 0.0f) goto L56;
     */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout r22, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r23) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }
}
