package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

/* loaded from: classes.dex */
class MediaDescriptionCompatApi23 {
    public static Uri getMediaUri(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }

    /* loaded from: classes.dex */
    static class Builder {
        public static void setMediaUri(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }

        private Builder() {
        }
    }

    private MediaDescriptionCompatApi23() {
    }
}
