package org.apache.commons.csv;

import java.io.Closeable;
import java.io.IOException;
import org.apache.commons.csv.Token;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Lexer implements Closeable {
    private static final char DISABLED = 65534;
    private final char commentStart;
    private final char delimiter;
    private final char escape;
    private String firstEol;
    private final boolean ignoreEmptyLines;
    private final boolean ignoreSurroundingSpaces;
    private final char quoteChar;
    private final ExtendedBufferedReader reader;
    private static final String CR_STRING = Character.toString('\r');
    private static final String LF_STRING = Character.toString('\n');

    boolean isEndOfFile(int i) {
        return i == -1;
    }

    boolean isStartOfLine(int i) {
        return i == 10 || i == 13 || i == -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getFirstEol() {
        return this.firstEol;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lexer(CSVFormat cSVFormat, ExtendedBufferedReader extendedBufferedReader) {
        this.reader = extendedBufferedReader;
        this.delimiter = cSVFormat.getDelimiter();
        this.escape = mapNullToDisabled(cSVFormat.getEscapeCharacter());
        this.quoteChar = mapNullToDisabled(cSVFormat.getQuoteCharacter());
        this.commentStart = mapNullToDisabled(cSVFormat.getCommentMarker());
        this.ignoreSurroundingSpaces = cSVFormat.getIgnoreSurroundingSpaces();
        this.ignoreEmptyLines = cSVFormat.getIgnoreEmptyLines();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Token nextToken(Token token) throws IOException {
        int lastChar = this.reader.getLastChar();
        int read = this.reader.read();
        boolean readEndOfLine = readEndOfLine(read);
        if (this.ignoreEmptyLines) {
            while (readEndOfLine && isStartOfLine(lastChar)) {
                int read2 = this.reader.read();
                readEndOfLine = readEndOfLine(read2);
                if (isEndOfFile(read2)) {
                    token.type = Token.Type.EOF;
                    return token;
                }
                int i = read;
                read = read2;
                lastChar = i;
            }
        }
        if (isEndOfFile(lastChar) || (!isDelimiter(lastChar) && isEndOfFile(read))) {
            token.type = Token.Type.EOF;
            return token;
        } else if (isStartOfLine(lastChar) && isCommentStart(read)) {
            String readLine = this.reader.readLine();
            if (readLine == null) {
                token.type = Token.Type.EOF;
                return token;
            }
            token.content.append(readLine.trim());
            token.type = Token.Type.COMMENT;
            return token;
        } else {
            while (token.type == Token.Type.INVALID) {
                if (this.ignoreSurroundingSpaces) {
                    while (isWhitespace(read) && !readEndOfLine) {
                        read = this.reader.read();
                        readEndOfLine = readEndOfLine(read);
                    }
                }
                if (isDelimiter(read)) {
                    token.type = Token.Type.TOKEN;
                } else if (readEndOfLine) {
                    token.type = Token.Type.EORECORD;
                } else if (isQuoteChar(read)) {
                    parseEncapsulatedToken(token);
                } else if (isEndOfFile(read)) {
                    token.type = Token.Type.EOF;
                    token.isReady = true;
                } else {
                    parseSimpleToken(token, read);
                }
            }
            return token;
        }
    }

    private Token parseSimpleToken(Token token, int i) throws IOException {
        while (true) {
            if (readEndOfLine(i)) {
                token.type = Token.Type.EORECORD;
                break;
            } else if (isEndOfFile(i)) {
                token.type = Token.Type.EOF;
                token.isReady = true;
                break;
            } else if (isDelimiter(i)) {
                token.type = Token.Type.TOKEN;
                break;
            } else if (isEscape(i)) {
                int readEscape = readEscape();
                if (readEscape == -1) {
                    StringBuilder sb = token.content;
                    sb.append((char) i);
                    sb.append((char) this.reader.getLastChar());
                } else {
                    token.content.append((char) readEscape);
                }
                i = this.reader.read();
            } else {
                token.content.append((char) i);
                i = this.reader.read();
            }
        }
        if (this.ignoreSurroundingSpaces) {
            trimTrailingSpaces(token.content);
        }
        return token;
    }

    private Token parseEncapsulatedToken(Token token) throws IOException {
        int read;
        long currentLineNumber = getCurrentLineNumber();
        while (true) {
            int read2 = this.reader.read();
            if (isEscape(read2)) {
                int readEscape = readEscape();
                if (readEscape == -1) {
                    StringBuilder sb = token.content;
                    sb.append((char) read2);
                    sb.append((char) this.reader.getLastChar());
                } else {
                    token.content.append((char) readEscape);
                }
            } else if (isQuoteChar(read2)) {
                if (isQuoteChar(this.reader.lookAhead())) {
                    token.content.append((char) this.reader.read());
                } else {
                    do {
                        read = this.reader.read();
                        if (isDelimiter(read)) {
                            token.type = Token.Type.TOKEN;
                            return token;
                        } else if (isEndOfFile(read)) {
                            token.type = Token.Type.EOF;
                            token.isReady = true;
                            return token;
                        } else if (readEndOfLine(read)) {
                            token.type = Token.Type.EORECORD;
                            return token;
                        }
                    } while (isWhitespace(read));
                    throw new IOException("(line " + getCurrentLineNumber() + ") invalid char between encapsulated token and delimiter");
                }
            } else if (isEndOfFile(read2)) {
                throw new IOException("(startline " + currentLineNumber + ") EOF reached before encapsulated token finished");
            } else {
                token.content.append((char) read2);
            }
        }
    }

    private char mapNullToDisabled(Character ch2) {
        return ch2 == null ? DISABLED : ch2.charValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getCurrentLineNumber() {
        return this.reader.getCurrentLineNumber();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getCharacterPosition() {
        return this.reader.getPosition();
    }

    int readEscape() throws IOException {
        int read = this.reader.read();
        if (read != -1) {
            if (read != 98) {
                if (read != 102) {
                    if (read != 110) {
                        if (read != 114) {
                            if (read != 116) {
                                if (read != 12 && read != 13) {
                                    switch (read) {
                                        case 8:
                                        case 9:
                                        case 10:
                                            break;
                                        default:
                                            if (isMetaChar(read)) {
                                                return read;
                                            }
                                            return -1;
                                    }
                                }
                                return read;
                            }
                            return 9;
                        }
                        return 13;
                    }
                    return 10;
                }
                return 12;
            }
            return 8;
        }
        throw new IOException("EOF whilst processing escape sequence");
    }

    void trimTrailingSpaces(StringBuilder sb) {
        int length = sb.length();
        while (length > 0) {
            int i = length - 1;
            if (!Character.isWhitespace(sb.charAt(i))) {
                break;
            }
            length = i;
        }
        if (length != sb.length()) {
            sb.setLength(length);
        }
    }

    boolean readEndOfLine(int i) throws IOException {
        if (i == 13 && this.reader.lookAhead() == 10) {
            i = this.reader.read();
            if (this.firstEol == null) {
                this.firstEol = "\r\n";
            }
        }
        if (this.firstEol == null) {
            if (i == 10) {
                this.firstEol = LF_STRING;
            } else if (i == 13) {
                this.firstEol = CR_STRING;
            }
        }
        return i == 10 || i == 13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isClosed() {
        return this.reader.isClosed();
    }

    boolean isWhitespace(int i) {
        return !isDelimiter(i) && Character.isWhitespace((char) i);
    }

    boolean isDelimiter(int i) {
        return i == this.delimiter;
    }

    boolean isEscape(int i) {
        return i == this.escape;
    }

    boolean isQuoteChar(int i) {
        return i == this.quoteChar;
    }

    boolean isCommentStart(int i) {
        return i == this.commentStart;
    }

    private boolean isMetaChar(int i) {
        return i == this.delimiter || i == this.escape || i == this.quoteChar || i == this.commentStart;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.close();
    }
}
