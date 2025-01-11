package com.bumptech.glide.load.resource.bitmap;

import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(InputStream inputStream, ArrayPool arrayPool) throws IOException {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(ByteBuffer byteBuffer, ArrayPool arrayPool) throws IOException {
        return getOrientation(ByteBufferUtil.toStream(byteBuffer), arrayPool);
    }
}
