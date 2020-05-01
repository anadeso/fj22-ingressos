package br.com.caelum.ingresso.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.UsuarioDao;
import br.com.caelum.ingresso.helper.TokenHelper;
import br.com.caelum.ingresso.mail.EmailNovoUsuario;
import br.com.caelum.ingresso.mail.Mailer;
import br.com.caelum.ingresso.model.Token;
import br.com.caelum.ingresso.model.Usuario;
import br.com.caelum.ingresso.model.form.ConfirmacaoLoginForm;

@Controller
public class UsuarioController {
	
	@Autowired
	private Mailer mailer;
	@Autowired
	private TokenHelper tokenHelper;
	
	@Autowired
	private UsuarioDao usuarioDao;
	

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	
	@GetMapping("/usuario/request")
	public ModelAndView formSolicitacaoDeAcesso(){
		return new ModelAndView("usuario/form-email");
	}
	

	@PostMapping("/usuario/request")
	@Transactional
	public ModelAndView solicitacaoDeAcesso(String email){
		System.out.println("A  ");
	
		System.out.println("UsuarioController  " +email);
		ModelAndView view = new ModelAndView("usuario/adicionado");
		System.out.println("B");

		Token token = tokenHelper.generateFrom(email);
		System.out.println("C");

		mailer.send( new EmailNovoUsuario(token) );
		System.out.println("D");

		return view;
	}
	
	@GetMapping("/usuario/validate")
	public ModelAndView validaLink(@RequestParam("uuid") String uuid){
		
		Optional<Token> optionalToken = tokenHelper.getTokenFrom(uuid);
		
		if (!optionalToken.isPresent()){
			ModelAndView view = new ModelAndView("redirect:/login");
			
			view.addObject("msg", "O token do link utilizado não foi encontrado!");
			
			return view;
		}
		
		Token token = optionalToken.get();
		ConfirmacaoLoginForm confirmacaoLoginForm = new ConfirmacaoLoginForm(token);
		
		ModelAndView view = new ModelAndView("usuario/confirmacao");
		view.addObject("confirmacaoLoginForm", confirmacaoLoginForm);
		return view;
	}
	
	@PostMapping("/usuario/cadastrar")
	@Transactional
	public ModelAndView cadastrar(ConfirmacaoLoginForm form){
		System.out.println("Entrei cadastrar  ");
		System.out.println("Entrei cadastrar  ");
		System.out.println("Entrei cadastrar  ");
		System.out.println("Entrei cadastrar  ");
		System.out.println("Entrei cadastrar  ");

		ModelAndView view = new ModelAndView("redirect:/login");
		
		if ( form.isValid() ) {
			System.out.println("Entrei cadastrar  ");
			Usuario usuario = form.toUsuario(usuarioDao, passwordEncoder);			
			usuarioDao.save(usuario);
			view.addObject("msg", "Usuario cadastrado com sucesso!");
			return view;
		}
		
		view.addObject("msg", "O token do link utilizado não foi encontrado!");
		return view;
		
	}
	
}
