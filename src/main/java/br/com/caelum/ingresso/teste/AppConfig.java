package br.com.caelum.ingresso.teste;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@ComponentScan
@Configuration
public class AppConfig {
	  private static final String SENDER_EMAIL = "sourib418@gmail.com";//change with your sender email
	  
	  @Bean
	  public MailSender mailSender() {
	      JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");//Outgoing server requires authentication
	      props.put("mail.smtp.starttls.enable", "true");//TLS must be activated
	      mailSender.setJavaMailProperties(props);

	      mailSender.setUsername(SENDER_EMAIL);
	      mailSender.setPassword("caelum123");//change with your sender email password
	      mailSender.setHost("smtp.1and1.com"); //Outgoing smtp server - change it to your SMTP server
	      //mailSender.setHost("localhost"); //Outgoing smtp server - change it to your SMTP server
	      mailSender.setPort(587);//Outgoing port
	      return mailSender;
	  }

	  @Bean
	  public SimpleMailMessage defaultMessage() {
	      SimpleMailMessage smm = new SimpleMailMessage();
	      smm.setTo("anadeso90@gmail.com");
	      smm.setFrom(SENDER_EMAIL);
	      smm.setSubject("Default subject");
	      smm.setText("Default text");
	      return smm;
	  }
}
