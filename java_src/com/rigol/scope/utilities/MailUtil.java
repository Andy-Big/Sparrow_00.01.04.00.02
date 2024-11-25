package com.rigol.scope.utilities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.rigol.scope.data.MailAuthenticator;
import com.rigol.scope.data.MailContext;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/* loaded from: classes2.dex */
public class MailUtil {
    public static boolean sendMail(MailContext mailContext, String str) {
        Session session;
        Properties properties = getProperties(mailContext);
        if (mailContext.isValidate()) {
            Log.d("szl", "create authenticator");
            session = Session.getInstance(properties, new MailAuthenticator(mailContext.getUserName(), mailContext.getPassword()));
        } else {
            session = null;
        }
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(mailContext.getFromAddress()));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailContext.getToAddress()));
            mimeMessage.setSubject(mailContext.getSubject());
            mimeMessage.setSentDate(new Date());
            String body = mailContext.getBody();
            mimeMessage.setText(body);
            if (!TextUtils.isEmpty(str)) {
                Multipart mimeMultipart = new MimeMultipart();
                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.setText(body);
                mimeMultipart.addBodyPart(mimeBodyPart);
                try {
                    MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
                    mimeBodyPart2.attachFile(str);
                    mimeMultipart.addBodyPart(mimeBodyPart2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mimeMessage.setContent(mimeMultipart);
            }
            Transport.send(mimeMessage);
            Log.d("szl", "sendMail success");
            return true;
        } catch (MessagingException e2) {
            e2.printStackTrace();
            Log.d("szl", "sendMail fail " + e2.toString());
            return false;
        }
    }

    private static Properties getProperties(MailContext mailContext) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", mailContext.getMailServerHost());
        properties.put("mail.smtp.port", mailContext.getMailServerPort());
        properties.put("mail.smtp.auth", mailContext.isValidate() ? "true" : "false");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.timeout", "4000");
        if (mailContext.isProtocol()) {
            properties.setProperty("mail.smtp.ssl.enable", "true");
            properties.setProperty("mail.smtp.socketFactory.port", Integer.toString(465));
            properties.setProperty("mail.smtp.socketFactory.fallback", "false");
            properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            Log.e("szl", "我已经打开ssl安全协议");
        }
        return properties;
    }

    public static void sendMailViaThirdPartyApp(MailContext mailContext, String str, Context context) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{mailContext.getToAddress()});
        intent.putExtra("android.intent.extra.SUBJECT", mailContext.getSubject());
        intent.putExtra("android.intent.extra.TEXT", mailContext.getBody());
        if (str != null) {
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
        }
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
