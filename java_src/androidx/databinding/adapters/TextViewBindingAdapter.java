package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TextKeyListener;
import android.util.Log;
import android.widget.TextView;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.library.baseAdapters.R;
/* loaded from: classes.dex */
public class TextViewBindingAdapter {
    public static final int DECIMAL = 5;
    public static final int INTEGER = 1;
    public static final int SIGNED = 3;
    private static final String TAG = "TextViewBindingAdapters";

    /* loaded from: classes.dex */
    public interface AfterTextChanged {
        void afterTextChanged(Editable editable);
    }

    /* loaded from: classes.dex */
    public interface BeforeTextChanged {
        void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface OnTextChanged {
        void onTextChanged(CharSequence charSequence, int i, int i2, int i3);
    }

    public static void setText(TextView textView, CharSequence charSequence) {
        CharSequence text = textView.getText();
        if (charSequence != text) {
            if (charSequence == null && text.length() == 0) {
                return;
            }
            if (charSequence instanceof Spanned) {
                if (charSequence.equals(text)) {
                    return;
                }
            } else if (!haveContentsChanged(charSequence, text)) {
                return;
            }
            textView.setText(charSequence);
        }
    }

    public static String getTextString(TextView textView) {
        return textView.getText().toString();
    }

    public static void setAutoText(TextView textView, boolean z) {
        KeyListener keyListener = textView.getKeyListener();
        TextKeyListener.Capitalize capitalize = TextKeyListener.Capitalize.NONE;
        int inputType = keyListener != null ? keyListener.getInputType() : 0;
        if ((inputType & 4096) != 0) {
            capitalize = TextKeyListener.Capitalize.CHARACTERS;
        } else if ((inputType & 8192) != 0) {
            capitalize = TextKeyListener.Capitalize.WORDS;
        } else if ((inputType & 16384) != 0) {
            capitalize = TextKeyListener.Capitalize.SENTENCES;
        }
        textView.setKeyListener(TextKeyListener.getInstance(z, capitalize));
    }

    public static void setCapitalize(TextView textView, TextKeyListener.Capitalize capitalize) {
        textView.setKeyListener(TextKeyListener.getInstance((textView.getKeyListener().getInputType() & 32768) != 0, capitalize));
    }

    public static void setBufferType(TextView textView, TextView.BufferType bufferType) {
        textView.setText(textView.getText(), bufferType);
    }

    public static void setDigits(TextView textView, CharSequence charSequence) {
        if (charSequence != null) {
            textView.setKeyListener(DigitsKeyListener.getInstance(charSequence.toString()));
        } else if (textView.getKeyListener() instanceof DigitsKeyListener) {
            textView.setKeyListener(null);
        }
    }

    public static void setNumeric(TextView textView, int i) {
        textView.setKeyListener(DigitsKeyListener.getInstance((i & 3) != 0, (i & 5) != 0));
    }

    public static void setPhoneNumber(TextView textView, boolean z) {
        if (z) {
            textView.setKeyListener(DialerKeyListener.getInstance());
        } else if (textView.getKeyListener() instanceof DialerKeyListener) {
            textView.setKeyListener(null);
        }
    }

    private static void setIntrinsicBounds(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    public static void setDrawableBottom(TextView textView, Drawable drawable) {
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], drawable);
    }

    public static void setDrawableLeft(TextView textView, Drawable drawable) {
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    public static void setDrawableRight(TextView textView, Drawable drawable) {
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
    }

    public static void setDrawableTop(TextView textView, Drawable drawable) {
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        textView.setCompoundDrawables(compoundDrawables[0], drawable, compoundDrawables[2], compoundDrawables[3]);
    }

    public static void setDrawableStart(TextView textView, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 17) {
            setDrawableLeft(textView, drawable);
            return;
        }
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(drawable, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    public static void setDrawableEnd(TextView textView, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 17) {
            setDrawableRight(textView, drawable);
            return;
        }
        setIntrinsicBounds(drawable);
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        textView.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], drawable, compoundDrawablesRelative[3]);
    }

    public static void setImeActionLabel(TextView textView, CharSequence charSequence) {
        textView.setImeActionLabel(charSequence, textView.getImeActionId());
    }

    public static void setImeActionLabel(TextView textView, int i) {
        textView.setImeActionLabel(textView.getImeActionLabel(), i);
    }

    public static void setInputMethod(TextView textView, CharSequence charSequence) {
        try {
            textView.setKeyListener((KeyListener) Class.forName(charSequence.toString()).newInstance());
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Could not create input method: " + ((Object) charSequence), e);
        } catch (IllegalAccessException e2) {
            Log.e(TAG, "Could not create input method: " + ((Object) charSequence), e2);
        } catch (InstantiationException e3) {
            Log.e(TAG, "Could not create input method: " + ((Object) charSequence), e3);
        }
    }

    public static void setLineSpacingExtra(TextView textView, float f) {
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setLineSpacing(f, textView.getLineSpacingMultiplier());
        } else {
            textView.setLineSpacing(f, 1.0f);
        }
    }

    public static void setLineSpacingMultiplier(TextView textView, float f) {
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setLineSpacing(textView.getLineSpacingExtra(), f);
        } else {
            textView.setLineSpacing(0.0f, f);
        }
    }

    public static void setMaxLength(TextView textView, int i) {
        boolean z;
        InputFilter[] filters = textView.getFilters();
        if (filters == null) {
            filters = new InputFilter[]{new InputFilter.LengthFilter(i)};
        } else {
            int i2 = 0;
            while (true) {
                if (i2 >= filters.length) {
                    z = false;
                    break;
                }
                InputFilter inputFilter = filters[i2];
                if (inputFilter instanceof InputFilter.LengthFilter) {
                    if (Build.VERSION.SDK_INT < 21 || ((InputFilter.LengthFilter) inputFilter).getMax() != i) {
                        filters[i2] = new InputFilter.LengthFilter(i);
                    }
                    z = true;
                } else {
                    i2++;
                }
            }
            if (!z) {
                int length = filters.length + 1;
                InputFilter[] inputFilterArr = new InputFilter[length];
                System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                inputFilterArr[length - 1] = new InputFilter.LengthFilter(i);
                filters = inputFilterArr;
            }
        }
        textView.setFilters(filters);
    }

    public static void setPassword(TextView textView, boolean z) {
        if (z) {
            textView.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textView.setTransformationMethod(null);
        }
    }

    public static void setShadowColor(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setShadowLayer(textView.getShadowRadius(), textView.getShadowDx(), textView.getShadowDy(), i);
        }
    }

    public static void setShadowDx(TextView textView, float f) {
        if (Build.VERSION.SDK_INT >= 16) {
            int shadowColor = textView.getShadowColor();
            textView.setShadowLayer(textView.getShadowRadius(), f, textView.getShadowDy(), shadowColor);
        }
    }

    public static void setShadowDy(TextView textView, float f) {
        if (Build.VERSION.SDK_INT >= 16) {
            int shadowColor = textView.getShadowColor();
            textView.setShadowLayer(textView.getShadowRadius(), textView.getShadowDx(), f, shadowColor);
        }
    }

    public static void setShadowRadius(TextView textView, float f) {
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setShadowLayer(f, textView.getShadowDx(), textView.getShadowDy(), textView.getShadowColor());
        }
    }

    public static void setTextSize(TextView textView, float f) {
        textView.setTextSize(0, f);
    }

    private static boolean haveContentsChanged(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence == null) != (charSequence2 == null)) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static void setTextWatcher(TextView textView, final BeforeTextChanged beforeTextChanged, final OnTextChanged onTextChanged, final AfterTextChanged afterTextChanged, final InverseBindingListener inverseBindingListener) {
        TextWatcher textWatcher = (beforeTextChanged == null && afterTextChanged == null && onTextChanged == null && inverseBindingListener == null) ? null : new TextWatcher() { // from class: androidx.databinding.adapters.TextViewBindingAdapter.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                BeforeTextChanged beforeTextChanged2 = BeforeTextChanged.this;
                if (beforeTextChanged2 != null) {
                    beforeTextChanged2.beforeTextChanged(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                OnTextChanged onTextChanged2 = onTextChanged;
                if (onTextChanged2 != null) {
                    onTextChanged2.onTextChanged(charSequence, i, i2, i3);
                }
                InverseBindingListener inverseBindingListener2 = inverseBindingListener;
                if (inverseBindingListener2 != null) {
                    inverseBindingListener2.onChange();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AfterTextChanged afterTextChanged2 = afterTextChanged;
                if (afterTextChanged2 != null) {
                    afterTextChanged2.afterTextChanged(editable);
                }
            }
        };
        TextWatcher textWatcher2 = (TextWatcher) ListenerUtil.trackListener(textView, textWatcher, R.id.textWatcher);
        if (textWatcher2 != null) {
            textView.removeTextChangedListener(textWatcher2);
        }
        if (textWatcher != null) {
            textView.addTextChangedListener(textWatcher);
        }
    }
}
