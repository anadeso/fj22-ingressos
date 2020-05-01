package br.com.caelum.ingresso.teste;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringEmailExampleMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ExampleClient bean = context.getBean(ExampleClient.class);
		bean.sendMail();
	}
}
