package br.com.caelum.ingresso.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Mailer {
	
	@Autowired
	private JavaMailSender sender;
	
	private final String from = "Ingresso<cursofj22@gmail.com>";
	 
	public void send(Email email) {
		
		System.out.println("Mailer a " +email);
		MimeMessage message = sender.createMimeMessage();
		System.out.println("Mailer b " +email);

        MimeMessageHelper messageHelper = new MimeMessageHelper(message);
		System.out.println("Mailer c " +email);

        try {
    		System.out.println("Mailer d " +email);

        	messageHelper.setFrom(from);
    		System.out.println("from e " +from);

        	messageHelper.setTo(email.getTo());
    		System.out.println("email.getTo() f " +email.getTo());

        	messageHelper.setSubject(email.getSubject());
    		System.out.println("email.getSubject()" +email.getSubject());

        	messageHelper.setText(email.getBody(), true);
    		System.out.println("Memail.getBody() " +email.getBody());

        	
        	sender.send(message);
    		System.out.println("message " +message);

        } catch (MessagingException e) {
        	throw new IllegalArgumentException(e);
        }
		
	}
}
