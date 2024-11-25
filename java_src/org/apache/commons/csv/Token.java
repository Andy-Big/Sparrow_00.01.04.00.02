package org.apache.commons.csv;
/* loaded from: classes2.dex */
final class Token {
    private static final int INITIAL_TOKEN_LENGTH = 50;
    boolean isReady;
    Type type = Type.INVALID;
    final StringBuilder content = new StringBuilder(50);

    /* loaded from: classes2.dex */
    enum Type {
        INVALID,
        TOKEN,
        EOF,
        EORECORD,
        COMMENT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.content.setLength(0);
        this.type = Type.INVALID;
        this.isReady = false;
    }

    public String toString() {
        return this.type.name() + " [" + this.content.toString() + "]";
    }
}
