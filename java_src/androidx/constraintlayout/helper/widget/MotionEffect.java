package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

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
    */
    public void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> hashMap) {
        Key key;
        Key key2;
        Key key3;
        boolean z;
        HashMap<View, MotionController> hashMap2 = hashMap;
        View[] views = getViews((ConstraintLayout) getParent());
        if (views == null) {
            Log.v(TAG, Debug.getLoc() + " views = null");
            return;
        }
        Key keyAttributes = new KeyAttributes();
        Key keyAttributes2 = new KeyAttributes();
        keyAttributes.setValue(Key.ALPHA, Float.valueOf(this.fadeAlpha));
        keyAttributes2.setValue(Key.ALPHA, Float.valueOf(this.fadeAlpha));
        keyAttributes.setFramePosition(this.fadeStart);
        keyAttributes2.setFramePosition(this.fadeEnd);
        KeyPosition keyPosition = new KeyPosition();
        keyPosition.setFramePosition(this.fadeStart);
        keyPosition.setType(0);
        keyPosition.setValue(KeyPosition.PERCENT_X, 0);
        keyPosition.setValue(KeyPosition.PERCENT_Y, 0);
        KeyPosition keyPosition2 = new KeyPosition();
        keyPosition2.setFramePosition(this.fadeEnd);
        keyPosition2.setType(0);
        keyPosition2.setValue(KeyPosition.PERCENT_X, 1);
        keyPosition2.setValue(KeyPosition.PERCENT_Y, 1);
        Key key4 = null;
        if (this.fadeTranslationX > 0) {
            key = new KeyAttributes();
            key2 = new KeyAttributes();
            key.setValue(Key.TRANSLATION_X, Integer.valueOf(this.fadeTranslationX));
            key.setFramePosition(this.fadeEnd);
            key2.setValue(Key.TRANSLATION_X, 0);
            key2.setFramePosition(this.fadeEnd - 1);
        } else {
            key = null;
            key2 = null;
        }
        if (this.fadeTranslationY > 0) {
            key4 = new KeyAttributes();
            key3 = new KeyAttributes();
            key4.setValue(Key.TRANSLATION_Y, Integer.valueOf(this.fadeTranslationY));
            key4.setFramePosition(this.fadeEnd);
            key3.setValue(Key.TRANSLATION_Y, 0);
            key3.setFramePosition(this.fadeEnd - 1);
        } else {
            key3 = null;
        }
        int i = this.fadeMove;
        if (i == -1) {
            int[] iArr = new int[4];
            for (View view : views) {
                MotionController motionController = hashMap2.get(view);
                float finalX = motionController.getFinalX() - motionController.getStartX();
                float finalY = motionController.getFinalY() - motionController.getStartY();
                if (finalY < 0.0f) {
                    iArr[1] = iArr[1] + 1;
                }
                if (finalY > 0.0f) {
                    iArr[0] = iArr[0] + 1;
                }
                if (finalX > 0.0f) {
                    iArr[3] = iArr[3] + 1;
                }
                if (finalX < 0.0f) {
                    iArr[2] = iArr[2] + 1;
                }
            }
            int i2 = iArr[0];
            int i3 = 0;
            for (int i4 = 1; i4 < 4; i4++) {
                if (i2 < iArr[i4]) {
                    i3 = i4;
                    i2 = iArr[i4];
                }
            }
            i = i3;
        }
        int i5 = 0;
        while (i5 < views.length) {
            MotionController motionController2 = hashMap2.get(views[i5]);
            float finalX2 = motionController2.getFinalX() - motionController2.getStartX();
            float finalY2 = motionController2.getFinalY() - motionController2.getStartY();
            if (i == 0) {
                if (finalY2 > 0.0f) {
                    if (this.fadeMoveStrict) {
                    }
                    z = false;
                }
                z = true;
            } else if (i == 1) {
                if (finalY2 < 0.0f) {
                    if (this.fadeMoveStrict) {
                    }
                    z = false;
                }
                z = true;
            } else if (i == 2) {
                if (finalX2 < 0.0f) {
                    if (this.fadeMoveStrict) {
                    }
                    z = false;
                }
                z = true;
            } else {
                if (i == 3) {
                    if (finalX2 > 0.0f) {
                        if (this.fadeMoveStrict) {
                        }
                        z = false;
                    }
                }
                z = true;
            }
            if (z) {
                int i6 = this.viewTransitionId;
                if (i6 == -1) {
                    motionController2.addKey(keyAttributes);
                    motionController2.addKey(keyAttributes2);
                    motionController2.addKey(keyPosition);
                    motionController2.addKey(keyPosition2);
                    if (this.fadeTranslationX > 0) {
                        motionController2.addKey(key);
                        motionController2.addKey(key2);
                    }
                    if (this.fadeTranslationY > 0) {
                        motionController2.addKey(key4);
                        motionController2.addKey(key3);
                    }
                } else {
                    motionLayout.applyViewTransition(i6, motionController2);
                }
            }
            i5++;
            hashMap2 = hashMap;
        }
    }
}
