package com.devops.calculadoraAPI.issues;

import java.util.Date;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Issues {
 private void sendHtmlTls() throws AddressException, MessagingException {        
		//Desencriptar password
		String decPass = gNCCryptoHelper.decrypt(this.getPassword());
		this.setPassword(decPass);
        Properties properties = new Properties();
        properties.put("mail.smtp.host", this.getHost());
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", this.getPort());
        properties.put("mail.smtp.socketFactory.port", this.getPort());  
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
        properties.put("mail.smtp.socketFactory.fallback", "false");  
        Session session = Session.getDefaultInstance(properties, null);
        session.setDebug(false);
 }
}
