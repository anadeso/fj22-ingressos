package br.com.caelum.ingresso.teste;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class SpringDemo {
 
    public static void main(String a[]){
 
        String confFile = "spring-context.xml";
        ConfigurableApplicationContext context 
                        = new ClassPathXmlApplicationContext(confFile);
        EmailService emailService = (EmailService) context.getBean("emailService");
        String toAddr = "anadeso90@gmail.com";
        String fromAddr = "anadeso90@gmail.com";
        String subject = "My Test Mail";
        String body = "Test mail body";
        emailService.sendEmail(toAddr, fromAddr, subject, body);
    }
}