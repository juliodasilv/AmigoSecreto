package br.com.fiap.trabalhofinal.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.trabalhofinal.model.Membro;
import br.com.fiap.trabalhofinal.service.AmigoSecretoService;

/**
 * @author Julio
 *
 */
@Controller
public class LoginController {
	@Autowired
	private AmigoSecretoService service;
	
	@RequestMapping("/")
	public String iniciar() {
		return "login";
	}

	@RequestMapping("/home")
	public String voltar() {
		return "home";
	}

	@RequestMapping(value="/logar", method=RequestMethod.POST)
	public String logar(@RequestParam("email") String email, @RequestParam("senha") String senha, HttpSession sessao,  ModelMap model) {
		try {
			Membro membro = service.verificaUsuario(email, senha);
			sessao.setAttribute("usuario", membro);
			return "home";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "login";
		}
	}

	@RequestMapping("/logooff")
	public String logooff(HttpSession sessao) {
		sessao.invalidate();
		return "login";
	}	 
}
