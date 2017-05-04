package br.com.fiap.trabalhofinal.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.trabalhofinal.model.Membro;
import br.com.fiap.trabalhofinal.model.dao.MembroDAO;

/**
 * @author Julio
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private MembroDAO membroDAO;
	
	@RequestMapping("/")
	public String iniciar() {
		return "login";
	}

	@RequestMapping(value="/logar", method=RequestMethod.POST)
	public String logar(@RequestParam("cpf") String cpf, @RequestParam("senha") String senha, HttpSession sessao,  ModelMap model) {
		try {
			Membro membro = membroDAO.verificaUsuario(cpf, senha);
			sessao.setAttribute("usuario", membro);
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
