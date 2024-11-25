package com.shockwave.pdfium;

import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class PdfDocument {
    long mNativeDocPtr;
    final Map<Integer, Long> mNativePagesPtr = new ArrayMap();
    ParcelFileDescriptor parcelFileDescriptor;

    /* loaded from: classes2.dex */
    public static class Meta {
        String author;
        String creationDate;
        String creator;
        String keywords;
        String modDate;
        String producer;
        String subject;
        String title;

        public String getTitle() {
            return this.title;
        }

        public String getAuthor() {
            return this.author;
        }

        public String getSubject() {
            return this.subject;
        }

        public String getKeywords() {
            return this.keywords;
        }

        public String getCreator() {
            return this.creator;
        }

        public String getProducer() {
            return this.producer;
        }

        public String getCreationDate() {
            return this.creationDate;
        }

        public String getModDate() {
            return this.modDate;
        }
    }

    /* loaded from: classes2.dex */
    public static class Bookmark {
        private List<Bookmark> children = new ArrayList();
        long mNativePtr;
        long pageIdx;
        String title;

        public List<Bookmark> getChildren() {
            return this.children;
        }

        public boolean hasChildren() {
            return !this.children.isEmpty();
        }

        public String getTitle() {
            return this.title;
        }

        public long getPageIdx() {
            return this.pageIdx;
        }
    }

    /* loaded from: classes2.dex */
    public static class Link {
        private RectF bounds;
        private Integer destPageIdx;
        private String uri;

        public Link(RectF rectF, Integer num, String str) {
            this.bounds = rectF;
            this.destPageIdx = num;
            this.uri = str;
        }

        public Integer getDestPageIdx() {
            return this.destPageIdx;
        }

        public String getUri() {
            return this.uri;
        }

        public RectF getBounds() {
            return this.bounds;
        }
    }

    public boolean hasPage(int i) {
        return this.mNativePagesPtr.containsKey(Integer.valueOf(i));
    }
}
