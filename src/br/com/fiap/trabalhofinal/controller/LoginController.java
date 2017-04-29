package br.com.fiap.trabalhofinal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Julio
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String iniciar() {
		return "login";
	}

	@RequestMapping("/logar")
	public String logar(String cpf, String senha, ModelMap model) {
		try {
			//tenta logar
			return "home";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "login";
		}
	}

	@RequestMapping("/logooff")
	public String logooff() {
		return "login";
	}
}
