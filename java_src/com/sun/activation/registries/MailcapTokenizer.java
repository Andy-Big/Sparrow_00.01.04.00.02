package com.sun.activation.registries;

import androidx.core.os.EnvironmentCompat;
/* loaded from: classes2.dex */
public class MailcapTokenizer {
    public static final int EOI_TOKEN = 5;
    public static final int EQUALS_TOKEN = 61;
    public static final int SEMICOLON_TOKEN = 59;
    public static final int SLASH_TOKEN = 47;
    public static final int START_TOKEN = 1;
    public static final int STRING_TOKEN = 2;
    public static final int UNKNOWN_TOKEN = 0;
    private String data;
    private int dataLength;
    private int dataIndex = 0;
    private int currentToken = 1;
    private String currentTokenValue = "";
    private boolean isAutoquoting = false;
    private char autoquoteChar = ';';

    private static boolean isSpecialChar(char c) {
        if (c != '\"' && c != ',' && c != '/' && c != '(' && c != ')') {
            switch (c) {
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '?':
                case '@':
                    break;
                default:
                    switch (c) {
                        case '[':
                        case '\\':
                        case ']':
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    public static String nameForToken(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 5 ? i != 47 ? i != 59 ? i != 61 ? "really unknown" : "'='" : "';'" : "'/'" : "EOI" : "string" : "start" : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public MailcapTokenizer(String str) {
        this.data = str;
        this.dataLength = str.length();
    }

    public void setIsAutoquoting(boolean z) {
        this.isAutoquoting = z;
    }

    public int getCurrentToken() {
        return this.currentToken;
    }

    public String getCurrentTokenValue() {
        return this.currentTokenValue;
    }

    public int nextToken() {
        if (this.dataIndex < this.dataLength) {
            while (true) {
                int i = this.dataIndex;
                if (i >= this.dataLength || !isWhiteSpaceChar(this.data.charAt(i))) {
                    break;
                }
                this.dataIndex++;
            }
            int i2 = this.dataIndex;
            if (i2 < this.dataLength) {
                char charAt = this.data.charAt(i2);
                if (this.isAutoquoting) {
                    if (charAt == ';' || charAt == '=') {
                        this.currentToken = charAt;
                        this.currentTokenValue = new Character(charAt).toString();
                        this.dataIndex++;
                    } else {
                        processAutoquoteToken();
                    }
                } else if (isStringTokenChar(charAt)) {
                    processStringToken();
                } else if (charAt == '/' || charAt == ';' || charAt == '=') {
                    this.currentToken = charAt;
                    this.currentTokenValue = new Character(charAt).toString();
                    this.dataIndex++;
                } else {
                    this.currentToken = 0;
                    this.currentTokenValue = new Character(charAt).toString();
                    this.dataIndex++;
                }
            } else {
                this.currentToken = 5;
                this.currentTokenValue = null;
            }
        } else {
            this.currentToken = 5;
            this.currentTokenValue = null;
        }
        return this.currentToken;
    }

    private void processStringToken() {
        int i = this.dataIndex;
        while (true) {
            int i2 = this.dataIndex;
            if (i2 >= this.dataLength || !isStringTokenChar(this.data.charAt(i2))) {
                break;
            }
            this.dataIndex++;
        }
        this.currentToken = 2;
        this.currentTokenValue = this.data.substring(i, this.dataIndex);
    }

    private void processAutoquoteToken() {
        int i = this.dataIndex;
        boolean z = false;
        while (true) {
            int i2 = this.dataIndex;
            if (i2 >= this.dataLength || z) {
                break;
            } else if (this.data.charAt(i2) != this.autoquoteChar) {
                this.dataIndex++;
            } else {
                z = true;
            }
        }
        this.currentToken = 2;
        this.currentTokenValue = fixEscapeSequences(this.data.substring(i, this.dataIndex));
    }

    private static boolean isControlChar(char c) {
        return Character.isISOControl(c);
    }

    private static boolean isWhiteSpaceChar(char c) {
        return Character.isWhitespace(c);
    }

    private static boolean isStringTokenChar(char c) {
        return (isSpecialChar(c) || isControlChar(c) || isWhiteSpaceChar(c)) ? false : true;
    }

    private static String fixEscapeSequences(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '\\') {
                stringBuffer.append(charAt);
            } else if (i < length - 1) {
                i++;
                stringBuffer.append(str.charAt(i));
            } else {
                stringBuffer.append(charAt);
            }
            i++;
        }
        return stringBuffer.toString();
    }
}
