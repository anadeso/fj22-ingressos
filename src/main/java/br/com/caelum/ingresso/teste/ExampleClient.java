package br.com.caelum.ingresso.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class ExampleClient {

	
	  @Autowired
	  private MailSender mailSender;
	  @Autowired
	  private SimpleMailMessage mailMessage;

	  public void sendMail(){
	      System.out.println("sending mail");
	      SimpleMailMessage msg = new SimpleMailMessage(mailMessage);//using copy constructor
	      msg.setTo("aps_sousa@hotmail.com");
	      msg.setSubject("test subject");
	      msg.setText("spring email integration test");
	      mailSender.send(msg);
	      System.out.println("done");
	  }
}
