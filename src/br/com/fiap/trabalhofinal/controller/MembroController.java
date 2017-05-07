package br.com.fiap.trabalhofinal.controller;


import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.trabalhofinal.model.Membro;
import br.com.fiap.trabalhofinal.service.AmigoSecretoService;

/**
 * @author Julio
 *
 */
@Controller
@Transactional
@RequestMapping("/membro")
public class MembroController {
	@Autowired
	private AmigoSecretoService service;
	
	@RequestMapping("/iniciarCadastro")
	public String iniciarCadastro(Membro membro) {
		return "cadastro/cadastrarMembro";
	}

	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public String cadastrar(@Valid Membro membro, BindingResult bindingResult, HttpSession sessao,  ModelMap model) {
		try {
			if (bindingResult.hasErrors()) {
				throw new BindException(bindingResult);
			}
			
			membro = service.cadastrarMembro(membro);
			sessao.setAttribute("usuario", membro);
			model.addAttribute("msg", "Cadastro de membro realizado com sucesso!");
			return "home";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("msg", e.getMessage());
			return "cadastro/cadastrarMembro";
		}
	}

	@RequestMapping("/visualizarAmigoSecreto")
	public String visualizar(HttpSession sessao, ModelMap model) {
		Membro membro = (Membro) sessao.getAttribute("usuario");
		model.addAttribute("msg", service.nomeAmigoSecretoSorteado(membro));
		return "visualizar/visualizarAmigoSecreto";
	}
	
}
