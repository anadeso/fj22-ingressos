package br.com.caelum.ingresso.mail;

import br.com.caelum.ingresso.model.Token;

public class EmailNovoUsuario implements Email{

    private final Token token;
    
    public EmailNovoUsuario(Token token) {
    	System.out.println("Token:  " +token);
    	System.out.println("EmailNovoUsuario a");
    	this.token = token;
    	System.out.println("EmailNovoUsuario b");

    }
    
	@Override
	public String getTo() {
    	System.out.println("EmailNovoUsuario c");

		return token.getEmail();

		//return token.
	}

	@Override
	public String getBody() {
    	System.out.println("EmailNovoUsuario d");

		StringBuilder body = new StringBuilder("<html>");
    	System.out.println("EmailNovoUsuario e");

		body.append("<body>");
		body.append("<h2> Bem Vindo </h2>");
		body.append(String.format("Acesso o <a href=%s>link</a> para para criar seu login no sistema de ingressos.", makeURL() ));
		body.append("</body>");
		body.append("</html>");
    	System.out.println("EmailNovoUsuario f");

		return body.toString();
	}

	@Override
	public String getSubject() {
		// TODO Auto-generated method stub
    	System.out.println("EmailNovoUsuario g");

		return "Cadastro Sistema de Ingressos";
	}

	private String makeURL() {    	
		 System.out.println("EmailNovoUsuario h");

		 return String.format("http://localhost:8080/usuario/validate?uuid=%s", token.getUuid());
	}
}
