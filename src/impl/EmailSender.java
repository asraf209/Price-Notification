package impl;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/*
 * MOdule for sending email
 */
public class EmailSender
{	
	public static void send(String msgBody, String to){
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true"); 
        properties.put("mail.smtp.host", Global.host);
        properties.put("mail.smtp.user", Global.from);
        properties.put("mail.smtp.password", Global.fromPass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");                
        
		Session session = Session.getDefaultInstance(properties);
	    
		try{
	    	MimeMessage message = new MimeMessage(session);
	    	message.setFrom(new InternetAddress(Global.from));
	    	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    	message.setSubject(Global.subject);
	    	message.setText(msgBody);
	    	
	    	Transport transport = session.getTransport("smtp");
	        transport.connect(Global.host, Global.from, Global.fromPass);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();	    	
	        
	        System.out.println("Message sent successfully....");
	    }catch (MessagingException e){
	    	e.printStackTrace();
	    }
	}
	
}