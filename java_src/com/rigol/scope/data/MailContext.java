package com.rigol.scope.data;
/* loaded from: classes2.dex */
public class MailContext {
    private String body;
    private String fromAddress;
    private String mailServerHost;
    private String mailServerPort;
    private String password;
    private String subject;
    private String toAddress;
    private String userName;
    private boolean validate = false;
    private boolean protocol = true;

    public String getMailServerHost() {
        return this.mailServerHost;
    }

    public String getMailServerPort() {
        return this.mailServerPort;
    }

    public void setMailServerHost(String str) {
        this.mailServerHost = str;
    }

    public void setMailServerPort(String str) {
        this.mailServerPort = str;
    }

    public boolean isValidate() {
        return this.validate;
    }

    public void setValidate(boolean z) {
        this.validate = z;
    }

    public String getFromAddress() {
        return this.fromAddress;
    }

    public void setFromAddress(String str) {
        this.fromAddress = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getToAddress() {
        return this.toAddress;
    }

    public void setToAddress(String str) {
        this.toAddress = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public boolean isProtocol() {
        return this.protocol;
    }

    public void setProtocol(boolean z) {
        this.protocol = z;
    }
}
