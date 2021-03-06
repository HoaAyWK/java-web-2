package fp.util;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





public class EmailUtility {
  public static boolean sendEmail(String host, String port, final String email, final String password,
		  String toAddress, String subject, String message) throws AddressException, MessagingException {
	 
	  //sets SMTP server properties
	  Properties properties = new Properties();
	  properties.put("mail.smtp.host", host);
	  properties.put("mail.smtp.port", port);
	  properties.put("mail.smtp.auth", "true");
	  properties.put("mail.smtp.starttls.enable", "true");
	  
	  //create a new session with an authenticator
	  Authenticator auth = new Authenticator() {
		  public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(email, password);
		  }
	};
	
	Session session = Session.getInstance(properties, auth);
	
	//create a new e-mail message
	Message msg = new MimeMessage(session);
	
	msg.setFrom(new InternetAddress(email));
	InternetAddress[] toAddresses= { new InternetAddress(toAddress) };
	msg.setRecipients(Message.RecipientType.TO, toAddresses);
	msg.setSubject(subject);
	msg.setSentDate(new Date());
	msg.setText(message);
	
	try {
		//send the e-mail
		Transport.send(msg);
	}
	catch(Exception e){
		return false;
	}
	return true;
  }
   
  public static String getRandom() {
	  Random rd = new Random();
	  int number = rd.nextInt(999999);
	  return String.format("%06d", number);
  }
}