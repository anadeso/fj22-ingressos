package br.com.caelum.ingresso.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Permissao implements GrantedAuthority {

	@Id
	private String nome;
	
	public static Permissao ADMIN = new Permissao("ROLE_ADMIN");
	public static Permissao COMPRADOR = new Permissao("ROLE_COMPRADOR");

	public Permissao(String nome) {

		this.nome = nome;
	}

	/*
	 * @deprecated hibernate only
	 */
	public Permissao() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return nome;
	}

}
