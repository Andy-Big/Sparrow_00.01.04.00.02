package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class ImageViewBindingAdapter {
    public static void setImageUri(ImageView imageView, String str) {
        if (str == null) {
            imageView.setImageURI(null);
        } else {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public static void setImageUri(ImageView imageView, Uri uri) {
        imageView.setImageURI(uri);
    }

    public static void setImageDrawable(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }
}
