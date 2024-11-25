package com.rigol.scope.data;

import android.graphics.drawable.Drawable;
import java.io.File;
/* loaded from: classes2.dex */
public class FileParam extends File {
    private String info;
    private boolean isPic;
    private String lastModified;
    private Drawable pic;
    private boolean selected;
    private String size;

    public FileParam(String str) {
        super(str);
        this.pic = null;
        this.info = null;
        this.size = null;
        this.lastModified = null;
        this.selected = false;
        this.isPic = false;
    }

    public Drawable getPic() {
        return this.pic;
    }

    public void setPic(Drawable drawable) {
        this.pic = drawable;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(String str) {
        this.lastModified = str;
    }

    public boolean isPic() {
        return this.isPic;
    }

    public void setPic(boolean z) {
        this.isPic = z;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    public int compareTo(File file) {
        if (isFile() == file.isFile()) {
            return super.compareTo(file);
        }
        return isFile() ? 1 : -1;
    }
}
