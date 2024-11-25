package javax.mail;
/* loaded from: classes2.dex */
public final class PasswordAuthentication {
    private final String password;
    private final String userName;

    public PasswordAuthentication(String str, String str2) {
        this.userName = str;
        this.password = str2;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }
}
